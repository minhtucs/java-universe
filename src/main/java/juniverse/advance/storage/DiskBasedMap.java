package juniverse.advance.storage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author tunm2
 */
public class DiskBasedMap<K, V> {
    
    public int tableSize;
    public int lastOffset;
    
    public int currentSize;
    
    public RandomAccessFile metaStorage;
    public RandomAccessFile dataStorage;
    
    public DiskBasedMap(String storagePath, int tableSize) throws IOException {
        this.tableSize = tableSize;
        
        try {
            File file = new File(storagePath);
            if (!file.exists())
                file.createNewFile();
            this.dataStorage = new RandomAccessFile(file, "rw");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
//        this.dataStorage.seek(0);
        this.lastOffset = this.dataStorage.readInt();
    }
    
    public V get(K key) throws IOException {
        int index = hash(key);
        Meta meta = readMeta(index);
        if (meta.offset == 0)
            return null;
        
        return null;
    }
    
    public void put(K key, V value) throws IOException {
        int index = hash(key);
        Meta meta = readMeta(index);
        
    }
    
    public void remove(K key) {
        // update status to 
    }
    
    private Meta readMeta(int index) throws IOException {
        byte[] buffer = new byte[Meta.SIZE];
        metaStorage.seek(index); // seek pointer to the right position
        metaStorage.read(buffer, 0, Meta.SIZE);
        Meta header = new Meta();
        header.deserialize(buffer);
        return header;
    }
    
    private Record readRecord(int offset) {
        return null;
    }
    
    private int hash(K key) {
        return key.hashCode() % tableSize;
    }
}
