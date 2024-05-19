package juniverse.core.io.network.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private static final int MAX_REQUESTS = 1;
    private static final int PORT_NUMBER = 9999;

    private ServerSocket serverSocket = null;
    
    public static void main(String args[]) {
        Server server = new Server();
        try {
            server.serve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void serve() throws IOException {
        // Try to open a server socket on port 9999
        // Note that we can't choose a port less than 1023 if we are not
        // privileged users (root)
        serverSocket = new ServerSocket(PORT_NUMBER, MAX_REQUESTS);

        // Wait for new connection from client
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handle(clientSocket);
        }
    }
    
    private void handle(Socket clientSocket) throws IOException {
        InputStream inStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inStream));
        BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(outStream));

        String clientAddress = clientSocket.getInetAddress().getHostName();
        int clientPort = clientSocket.getPort();

        // Poll message from client
        String msgFromClient;
        while ((msgFromClient = bufferReader.readLine()) != null) {
            System.out.println("[server] received: " + msgFromClient);

            String msgToClient = "From " + clientAddress + ":" + clientPort + ": " + msgFromClient;
            bufferWriter.write(msgToClient);
        }
    }
}
