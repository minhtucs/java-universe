package juniverse.core.io.network.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;
    
    /** Timeout for read() method on the InputStream associated with this socket */
    private static final int SOCKET_TIMEOUT = 2 * 1000;
    /** Timeout for connecting to the address */
    private static final int CONN_TIMEOUT = 5 * 1000;
    
    private Socket socket = null;
    private BufferedReader readBuffer = null;
    private BufferedWriter writeBuffer = null;
    
    public void connect(String host, int port) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(host, port);
        socket = new Socket();
        socket.setSoTimeout(SOCKET_TIMEOUT);
        socket.connect(addr, CONN_TIMEOUT);
    }
    
    public Object read() {
        try {
            BufferedReader readBuf = getReadBuffer();
            return readBuf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void write(Object value) {
        try {
            BufferedWriter writeBuf = getWriteBuffer();
            writeBuf.write(value.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private BufferedReader getReadBuffer() throws IOException {
        if (readBuffer == null) {
            InputStreamReader isreader = new InputStreamReader(socket.getInputStream());
            readBuffer = new BufferedReader(isreader);
        }
        
        return readBuffer;
    }
    
    private BufferedWriter getWriteBuffer() throws IOException {
        if (writeBuffer == null) {
            OutputStreamWriter oswriter = new OutputStreamWriter(socket.getOutputStream());
            writeBuffer = new BufferedWriter(oswriter);
        }
        
        return writeBuffer;
    }

    public static void main(String[] args) throws IOException {
        Client cli = new Client();
        cli.connect(HOST, PORT);
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            cli.write(input);
            Object msgReceived = cli.read();
            System.out.println("[client] received: " + msgReceived);
        }
    }
}
