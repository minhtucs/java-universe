package juniverse.core.io.network.serverimpls;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SimpleNonblockServer {
    private static final int NCHANNELS = 10;
    private static final int PORT = 8080;
    
    public static void main(String[] args) {
        try {
            // set up server sockets for the given ports
            ServerSocketChannel[] socketChanels = new ServerSocketChannel[NCHANNELS];
            Selector selector = Selector.open();
            for (int i = 0; i < NCHANNELS; i++) {
                socketChanels[i] = ServerSocketChannel.open();
                socketChanels[i].configureBlocking(false);
                socketChanels[i].socket().bind(new InetSocketAddress(Integer.parseInt(args[i])));
                socketChanels[i].register(selector, SelectionKey.OP_ACCEPT);
            }

            ByteBuffer buf = ByteBuffer.allocateDirect(1024);
            while (true) {
                // wait for a client to connect
                selector.select();

                // process each connection
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = (SelectionKey) keys.next();
                    keys.remove();
                    if (key.isAcceptable()) {
                        // establish connection
                        ServerSocketChannel s = (ServerSocketChannel) key.channel();
                        SocketChannel c = s.accept();
                        c.configureBlocking(false);

                        try {
                            // read input
                            Selector readSelector = Selector.open();
                            c.register(readSelector, SelectionKey.OP_READ);
                            StringBuffer msg = new StringBuffer();
                            boolean eos = false;
                            while (!eos) {
                                buf.clear();
                                readSelector.select(); // wait for a chunk of input
                                c.read(buf);

                                int p = buf.position();
                                if (p > 0 && buf.get(p - 1) == 0) {
                                    eos = true; // we have reached the terminating 0
                                    buf.position(p - 1);
                                }

                                buf.flip();
                                byte[] bb = new byte[buf.remaining()];
                                buf.get(bb);
                                msg.append(new String(bb));
                            }

                            // write output
                            Selector writeSelector = Selector.open();
                            c.register(writeSelector, SelectionKey.OP_WRITE);
                            buf.clear();
                            buf.put(("Rumors at port " + c.socket().getLocalPort() + ": " + msg).getBytes());
                            buf.flip();
                            while (buf.remaining() > 0) {
                                writeSelector.select(); // wait for client to be ready
                                c.write(buf);
                            }
                            c.socket().shutdownOutput();
                        } catch (Exception e) { // presumably lost connection
                            continue;
                        }
                        c.close();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}