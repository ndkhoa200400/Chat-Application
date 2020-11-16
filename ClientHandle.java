import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * ClientHandle
 * Used to send one client's msg to other clients
 */
public class ClientHandle implements Runnable {
    private Socket client;
    private BufferedReader receiver; // Receive msg from server (sent by other clients)
    private PrintWriter sender; // Send this client's msg to server
    private ArrayList<ClientHandle> clients; // Keep trace the other clients

    ClientHandle(Socket clientSocker, ArrayList<ClientHandle> clients)
    throws IOException  
    {
        this.clients = clients;
        this.client = clientSocker;
        this.receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.sender = new PrintWriter(client.getOutputStream(), true);
    }


    @Override
    public void run() {
        // Method to send client's msg to others parallelly 
        try {
            while (true)
            {
                String request = receiver.readLine();
                sendToAll(request);
            }
           
        } 
        catch (Exception e) {
           
            System.err.println("IO exception in client handler");
            System.err.println(e.getStackTrace());
        }
        finally{
            sender.close();
            try{
                receiver.close();
            }catch(Exception e)
            {
                System.err.println("Exception in closing");
                System.err.println(e.getStackTrace());
                
            }
        }
    }
    void sendToAll(String msg)
    {
        for (ClientHandle clientHandle : clients) {
            if (clientHandle != this)
                clientHandle.sender.println(msg);   
        }
    }
}