package juniverse.core.io.network.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author tunm2
 */
public class Client2020 {

    String host;
    int port;

    public Client2020(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public static void main(String[] args) throws IOException {
        Client2020 client = new Client2020("localhost", 9999);
        client.request();
    }
    
    public void request() throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(5000);
        socket.connect(new InetSocketAddress(host, port));
        
        boolean connected = socket.isConnected();
        System.err.println("isConnected: " + connected);
        
        // send a message
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello server");
        writer.newLine(); // !important, without this, the server will block forever
        writer.flush();
        
        // receive something
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String msgReceived = reader.readLine();
        System.err.println("received: " + msgReceived);
    }
    
}
