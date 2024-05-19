package juniverse.core.endianness;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkEndiannessClient {
    private static final String HOST = "127.0.0.1";
    
    Socket socket;
    InputStream inputStream;
    
    public static void main(String[] args) throws IOException {
        NetworkEndiannessClient client = new NetworkEndiannessClient();
        client.connect(HOST, NetworkEndiannessServer.PORT);
        
        byte value = client.readByte();
        System.out.println(value);
    }
    
    public void connect(String host, int port) throws IOException {
        socket = new Socket(HOST, NetworkEndiannessServer.PORT);
        inputStream = socket.getInputStream();
    }
    
    public byte readByte() throws IOException {
        return (byte) inputStream.read();
    }
    
    public byte[] readBytes(int len) throws IOException {
        byte[] bytes = new byte[len];
        inputStream.read(bytes);
        return bytes;
    }
    
    public int readInt() throws IOException {
        DataInputStream dis = new DataInputStream(inputStream);
        return dis.readInt();
    }
    
    public String readString() throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] cbuf = new char[2048];
        reader.read(cbuf);
        
        return new String(cbuf);
    }

    public void close() throws IOException {
        socket.close();
    }
       
}