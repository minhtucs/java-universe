package juniverse.core.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class NIOServer {

    public final static String HOST = "127.0.0.1";
    public final static int PORT = 8511;
    
    public final static long TIMEOUT = 10000;
    public final static int BUFFER_SIZE = 1024;

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    private ConcurrentMap<String, SocketChannel> connections;
    
    /**
     * This map is important. It keeps track of the data that will be written to the clients.
     * This is needed because we read/write asynchronously and we might be reading while the
     * server wants to write. In other words, we tell the Selector we are ready to write
     * (SelectionKey.OP_WRITE) and when we get a key for writing, we then write from the map.
     * The write() method explains this further.
     */
    private Map<SocketChannel, byte[]> dataTracking = new HashMap<>();

    public static void main(String[] args) {
        NIOServer server = new NIOServer();
        try {
            server.serve();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            server.closeConnection();
        }
    }

    public NIOServer() {
        init();
    }

    private void init() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(HOST, PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Initialized server");
    }

    public void serve() throws IOException {
        while (true) {
            // Block here until at least one operation occurs
            selector.select();

            // If we are here, it is because an operation happened (or the TIMEOUT expired).
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                // remove the key so that we don't process this OPERATION again.
                keys.remove();

                if (!key.isValid())
                    continue;

                if (key.isAcceptable()) {
                    System.out.println("Accepted connection");
                    handleAccept(key);
                }

                if (key.isWritable()) {
                    System.out.println("Writing data...");
                    handleWrite(key);
                }

                if (key.isReadable()) {
                    System.out.println("Reading data...");
                    handleRead(key);
                }
            }
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.configureBlocking(false);

        int interestOps = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        socketChannel.register(selector, interestOps);

        byte[] hello = "Welcome to connected to server".getBytes("UTF-8");
        dataTracking.put(socketChannel, hello);
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        buffer.clear();

        int bytes;
        try {
            bytes = channel.read(buffer);
        } catch (IOException e) {
            System.out.println("Reading problem, closing connection");
            key.cancel();
            channel.close();
            return;
        }

        if (bytes == -1) {
            System.out.println("Nothing was there to be read, closing connection");
            channel.close();
            key.cancel();
            return;
        }

        // IMPORTANT - don't forget the flip() the buffer. It is like a reset without clearing it.
        buffer.flip();
        byte[] data = new byte[bytes];
        buffer.get(data, 0, bytes);
        System.out.println("Received: " + new String(data));

        dataTracking.put(channel, data);
        key.interestOps(SelectionKey.OP_WRITE);
    }

    private void handleWrite(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        byte[] data = dataTracking.get(channel);
        dataTracking.remove(channel);

        // Something to notice here is that reads and writes in NIO go directly to the channel
        // and in form of a buffer.
        if (data != null) {
            byte[] processedData = processData(data);
            channel.write(ByteBuffer.wrap(processedData));
        }

        key.interestOps(SelectionKey.OP_READ);
    }

    private void closeConnection() {
        System.out.println("Closing server down");
        if (selector != null) {
            try {
                selector.close();
                serverSocketChannel.socket().close();
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Just reverse the input string
    private byte[] processData(byte[] data) {
        if (data == null) {
            return null;
        }

        String input = new String(data);
        StringBuilder builder = new StringBuilder(input);
        String result = builder.reverse().toString();

        return result.toUpperCase().getBytes();
    }

}