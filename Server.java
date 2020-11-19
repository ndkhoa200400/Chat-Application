import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 * Start Server 
 * Listen to clients' connection
 */
class Server {
    private static final int PORT = 9090;
    private static ArrayList<ClientHandle> clients = new ArrayList<>();
    
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("IP: " + listener.getLocalSocketAddress());
        System.out.println("WAITING FOR CLIENT CONNECTION ON PORT " + PORT);
        while (true) {
           
            Socket client = listener.accept();
            System.err.println("Client " + client  + " has connected");

            ClientHandle clientThread = new ClientHandle(client, clients);
            clients.add(clientThread);
            
            // Create new theard to handle new client
            pool.execute(clientThread);
        }
    }
}
