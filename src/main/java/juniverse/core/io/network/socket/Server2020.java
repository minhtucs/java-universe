package juniverse.core.io.network.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tunm2
 */
public class Server2020 {

    int port;

    public Server2020(int port) {
        this.port = port;
    }
    
    public static void main(String[] args) throws IOException {
        new Server2020(9999).serve();
    }
    
    public void serve() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("serving...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }
    
    private void handleRequest(Socket clientSocket) throws IOException {
        InetSocketAddress clientAddr = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
        String clientName = clientAddr.getHostName() + ":" + clientAddr.getPort();
        System.err.println("accept connection from " + clientName);
            
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        
        // receive message from client
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String msgReceived = reader.readLine();
        System.err.println("received from " + clientName + ": " + msgReceived);
        
        // respond back
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello " + msgReceived);
        writer.newLine(); //!important, without this client will block forever
        writer.flush();
    }
    
}
