import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

/**
 * ServerConnection
 * Used to receive msg from server (another client) and print out on this client's screen 
 */
public class ServerConnection implements Runnable {
    private Socket server;
    private BufferedReader in;


    ServerConnection(Socket s) throws IOException {
        server = s;
        this.in = new BufferedReader(new InputStreamReader(server.getInputStream()));

    }

    @Override
    public void run() {
        
        try {
            while (true) {
                String serverResponse = in.readLine();
                System.out.println(serverResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
}