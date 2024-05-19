package juniverse.advance.storage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tunm2
 */
public class DiskBasedList<E> {
    
    private static final int HEAD_OFFSET_OFFSET     = 0;
    private static final int LAST_OFFSET_OFFSET     = 4;
    private static final int LIST_SIZE_OFFSET       = 8;

    // 4bytes for headOffset
    // 4bytes for lastOffset
    // 4bytes for list's size
    public static final int LIST_HEADER_SIZE = 12;
    
    // offset of the head
    public int headOffset;
    // last offset where new element will be put on
    public int lastOffset;
    // list's size
    public int size;
    
    private RandomAccessFile storage;
    
    private static Serializer serializer = new NativeSerializer();
    
    public DiskBasedList(String storagePath) throws IOException {
        try {
            File file = new File(storagePath);
            if (!file.exists())
                file.createNewFile();
            this.storage = new RandomAccessFile(file, "rw");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
        if (this.storage.length() == 0) {
            this.headOffset = -1;
            this.lastOffset = 12;
            this.size = 0;
            
            this.storage.seek(0);
            this.storage.writeInt(this.headOffset);
            this.storage.writeInt(this.lastOffset);
            this.storage.writeInt(this.size);
        } else {
            this.headOffset = this.storage.readInt();
            this.lastOffset = this.storage.readInt();
            this.size = this.storage.readInt();
        }
    }
    
    public E get(int index) throws IOException {
        return getNode(index).data;
    }
    
    private Node<E> getNode(int index) throws IOException {
        if (index >= this.size || index < 0)
            throw new IndexOutOfBoundsException();
        
        int _offset = this.headOffset;
        Node<E> node = null;
        while (index-- >= 0) {
            node = readNode(_offset);
            _offset = node.pnext;
        }
        return node;
    }
    
    public void add(int index, E element) throws IOException {
        if (index > this.size || index < 0)
            throw new IndexOutOfBoundsException();
        
        Node<E> newNode = new Node<>(element);
        
        if (isEmpty()) {
            this.headOffset = this.lastOffset;
            writeNode(newNode, this.headOffset);
        } else {
            // walk to node (index-1)th
            int prevOffset = -1;
            int walkOffset = this.headOffset;
            Node<E> prevNode = null;
            while (index-- > 0) {
                prevNode = readNode(walkOffset);
                prevOffset = walkOffset;
                walkOffset = prevNode.pnext;
            }

            // set pnext of new node to pnext of prev node
            newNode.pnext = prevNode.pnext;
            // update pnext of node prev node to new node (actually, lastOffset)
            prevNode.pnext = this.lastOffset;
            writeNode(prevNode, prevOffset);

            // write new node at the last offset
            writeNode(newNode, this.lastOffset);
        }

        // update lastOffset & size of the list
        this.lastOffset += newNode.size();
        this.size += 1;
        // persist lastOffset & size of the list
        this.storage.seek(0);
        this.storage.writeInt(this.headOffset);
        this.storage.writeInt(this.lastOffset);
        this.storage.writeInt(this.size);
    }
    
    public E remove(int index) {
        return null;
    }
    
    public void append(E element) throws IOException {
        add(this.size, element);
    }
    
    public E getLast() throws IOException {
        return get(this.size-1);
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    private Node<E> readNode(int offset) throws IOException {
        Node<E> node = new Node();
        
        // read header
        storage.seek(offset);
        node.dsize = storage.readInt();
        node.pnext = storage.readInt();
        
        // read data
        byte[] dbytes = new byte[node.dsize];
        storage.read(dbytes);
        node.data = serializer.deserialize(dbytes);
        return node;
    }
    
    private void writeNode(Node<E> node, int offset) throws IOException {
        storage.seek(offset);
        storage.write(node.serialize());
    }
    
    public static class Node<E> {
        // 4bytes for item's size, 4bytes for pointer to next node
        public static final int NODE_HEADER_SIZE = 8;
        
        // header
        public int dsize;
        public int pnext;
        // data
        public E data;
        
        public Node() {
            this(-1, null);
        }

        public Node(E data) {
            this(-1, data);
        }
        
        public Node(int pnext, E data) {
            this.dsize = data != null ? serializer.serialize(data).length : 0;
            this.pnext = pnext;
            this.data = data;
        }

        public byte[] serialize() {
            ByteBuffer bb = ByteBuffer.allocate(NODE_HEADER_SIZE + dsize);
            bb.putInt(dsize);
            bb.putInt(pnext);
            bb.put(serializer.serialize(data));
            return bb.array();
        }
        
        public void deserialize(byte[] bytes) {
            ByteBuffer bb = ByteBuffer.wrap(bytes);
            this.dsize = bb.getInt();
            this.pnext = bb.getInt();
            byte[] dbytes = new byte[this.dsize];
            bb.get(dbytes);
            this.data = serializer.deserialize(dbytes);
        }

        public int size() {
            return NODE_HEADER_SIZE + dsize;
        }
        
        @Override
        public String toString() {
            return "Node{" + "dsize=" + dsize + ", pnext=" + pnext + ", data=" + data + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> memList = new LinkedList<>();
        DiskBasedList<Integer> diskList = new DiskBasedList<>("/home/tunm2/list.dat");
        
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int el = i; // rand.nextInt();
            diskList.add(i, el);
            memList.add(i, el);
        }
        
        int pos = 21;
        System.out.println(diskList.get(pos));
        System.out.println(memList.get(pos));
    }
}