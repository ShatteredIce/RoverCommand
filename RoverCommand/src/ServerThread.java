import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        super("ServerThread");
        this.socket = socket;
    }
    
    public void run() {
    	
    	System.out.println(socket.getInetAddress());

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine;
            while (true) {
            	try {
            		if((inputLine = in.readLine()) != null) {
	            		System.out.println("Recieved: " + inputLine);
	            		out.println("Recieved: " + inputLine);
	                    if (inputLine.equals("Exit"))
	                        break;
            		}
            	}
            	catch (SocketException e) {
            		System.out.println("Client Disconnected");
            		break;
            	}
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}