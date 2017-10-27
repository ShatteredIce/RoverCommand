import java.net.*;
import java.io.*;

public class MainServer {
	
	int portNumber = 567;
	boolean listening = true;
	
	public MainServer() {
		try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
			System.out.println("Server Started");
			System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
            while (listening) {
            	System.out.println("scanning for connections...");
	            new ServerThread(serverSocket.accept()).start();
	            System.out.println("connection established");
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

	public static void main(String[] args) {
		new MainServer();
	}

}
