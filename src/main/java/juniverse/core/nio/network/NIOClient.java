package juniverse.core.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static juniverse.core.nio.network.NIOServer.*;

public class NIOClient {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String string1 = "Sending a test message";
        Client client = new Client(string1);
        try {
            client.start();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            client.close();
        }
    }

    static class Client {
        private static final int BUFFER_SIZE = 1024;
        
        private SocketChannel channel;
        private Selector selector;
        
        private ByteBuffer readBuffer;
        private ByteBuffer writeBuffer;
        
        private String message = "";

        public Client(String message) {
            this.message = message;
            init();
        }
        
        private void init() {
            try {
                selector = Selector.open();
                channel = SocketChannel.open();
                channel.configureBlocking(false);
                channel.connect(new InetSocketAddress(HOST, PORT));
                channel.register(selector, SelectionKey.OP_CONNECT);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        public void start() throws IOException {
            while (true) {
                // Block here until at least one operation occurs
                selector.select();
                
                // If we are here, it is because an operation happened (or the TIMEOUT expired).
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    // A key can holds multiple operations for processing. Why?
                    // OP_READ: 0x01, OP_WRITE: 0x04, OP_CONNECT: 0x08, OP_ACCEPT: 0x10
                    // So if using OR between operations, we can parse the key to get corresponding ops.
                    // Therefore, use IF (key's status) below is total exactly, 
                    // otherwise, use SWITCH (key.ops) is wrong 
                    SelectionKey key = keys.next();
                    keys.remove();

                    if (!key.isValid()) continue;
                    
                    if (key.isConnectable()) {
                        System.out.println("Connected to the server");
                        connect(key);
                    }
                    if (key.isWritable()) {
                        System.out.println(System.currentTimeMillis() + " Writing...");
                        write(key);
                    }
                    if (key.isReadable()) {
                        System.out.println("Reading...");
                        read(key);
                    }
                }
            }
        }

        private void connect(SelectionKey key) throws IOException {
            if (channel.isConnectionPending()) {
                channel.finishConnect();
            }
            channel.configureBlocking(false);
            
            int interestOps = SelectionKey.OP_WRITE;
            channel.register(selector, interestOps);
        }
        
        private void close() {
            try {
                selector.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void read(SelectionKey key) throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            buffer.clear();
            
            int bytesRead;
            try {
                bytesRead = channel.read(buffer);
            } catch (IOException e) {
                System.out.println("Reading problem, closing connection");
                key.cancel();
                channel.close();
                return;
            }
            
            if (bytesRead == -1) {
                System.out.println("Nothing was read from server");
                channel.close();
                key.cancel();
                return;
            }
            
            buffer.flip();
            byte[] data = new byte[bytesRead];
            buffer.get(data, 0, bytesRead);
            System.out.println("From server: " + new String(data, "UTF-8"));
            
            key.interestOps(SelectionKey.OP_WRITE);
        }

        public void write(SelectionKey key) throws IOException {
            channel.write(ByteBuffer.wrap(message.getBytes()));
            key.interestOps(SelectionKey.OP_READ);
        }
    }
}
