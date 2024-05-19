package juniverse.core.io.network.serverimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 8080;
	
	private ServerSocket serverSocket;
	
	public void start() {
		try {
			serverSocket = new ServerSocket(PORT);
			
			while (true) {
				// Listen requests
				final Socket clientSocket = serverSocket.accept();
				// Process incoming requests in new threads
				Thread processThread = new Thread() {
					public void run() {
						processClientRequest(clientSocket);
					};
				};
				processThread.start();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	private void processClientRequest(Socket clientSocket) {
	    BufferedReader readBuffer = null;
        BufferedWriter writeBuffer = null;
        
        try {
            // read data from client
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            readBuffer = new BufferedReader(reader);
            String dataFromClient = readBuffer.readLine();
            System.out.println(dataFromClient);
            
            // write data to client
            OutputStream output = clientSocket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            writeBuffer = new BufferedWriter(writer);
            writeBuffer.write("hello client");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                readBuffer.close();
                writeBuffer.close();
            } catch (IOException e) {}
        }
	}
	
	public static void main(String[] args) {
		MultiThreadedServer server = new MultiThreadedServer();
		server.start();
	}
}
