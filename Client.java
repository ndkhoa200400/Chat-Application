import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;


public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    private static Account account;
    public static void signUp(BufferedReader keyboard)  throws IOException
    {
        boolean isAccountValid = false;
        do{
            System.out.print("Your username: ");
            String username = keyboard.readLine();
            System.out.print("Your password: ");
            String password = keyboard.readLine();
            if (!Account.isExisted(username))
            {
                account = new Account(username, password);
                Account.signUp(username, password);
                isAccountValid = true;
            }
            else{
                System.out.println("Username has already been taken");
            }

        }while(!isAccountValid);
       
    }
    public static void signIn(BufferedReader keyboard) throws IOException
    {
        boolean isAccountValid = false;
        do
        {     
            System.out.print("Username: ");
            String username = keyboard.readLine();
            System.out.print("Password: ");
            String password = keyboard.readLine();
            if (Account.checkAccount(username, password))
            {
                account = new Account(username, password);
                isAccountValid = true;
            }
            if (!isAccountValid)
            {
                System.out.println("Your username or your password is invalid");
               
            }
        } while(isAccountValid == false);
    }
    static void signingMenu(BufferedReader keyboard) throws IOException
    {
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.print(">> ");
        String choice = keyboard.readLine();
        if (choice.equals("1"))
        {
            signIn(keyboard);
        }
        else{
            signUp(keyboard);
        }
    }

    public static void main(String[] args)  throws IOException{
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
     
        ServerConnection serverConn = new ServerConnection(socket);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        signingMenu(keyboard);
        out.println(account.getUserName() + " has joined");
       // Listen incoming msg from server (other clients)
        new Thread(serverConn).start();
        

       
          // Send msg to server and let server send it to other client
        while (true)
        {
            String command = keyboard.readLine();
            command = account.getUserName() + ": " + command;
            out.println(command);
        }

    
    }
}
