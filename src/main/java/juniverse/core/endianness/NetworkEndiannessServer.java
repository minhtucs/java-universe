package juniverse.core.endianness;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This server only serve one request
 * @author nminhtu
 *
 */
public class NetworkEndiannessServer {
    public static final int PORT = 9990;
    public static final int MAX_REQUESTS = 1;
    
    ServerSocket socketServer;
    OutputStream outputStream;
    
    static int value = 0x01020304;
    
    public NetworkEndiannessServer(int port) throws IOException {
        socketServer = new ServerSocket(port, MAX_REQUESTS);
    }
    
    public static void main(String args[]) throws IOException {
        NetworkEndiannessServer server = new NetworkEndiannessServer(PORT);
        server.serve();
        byte[] bytes = getBytes(value); // { 0x01, 0x02, 0x03, 0x04 }
        server.writeBytes(bytes);
        
        server.shutdown();
    }
    
    public void serve() throws IOException {
        Socket clientSocket = socketServer.accept();
        outputStream = clientSocket.getOutputStream();
        
        System.out.println("Server is listening...");
    }
    
    /** This will write the least significant byte of the input integer */
    public void write(int b) throws IOException {
        outputStream.write(b);
    }
    
    public void writeBytes(byte[] bytes) throws IOException {
        outputStream.write(bytes);
    }
    
    public void writeInt(int value) throws IOException {
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeInt(value);
    }
    
    public void writeString(String str) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write(str);
    }
    
    public void shutdown() throws IOException {
        outputStream.close();
        socketServer.close();
    }
    
    static byte[] getBytes(int value) {
        byte[] b = new byte[4];
        b[0] = (byte) ((value >> 24) & 0xFF);
        b[1] = (byte) ((value >> 16) & 0xFF);
        b[2] = (byte) ((value >> 8) & 0xFF);
        b[3] = (byte) ((value >> 0) & 0xFF);
        return b;
    }
}