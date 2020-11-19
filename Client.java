import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    private static Account account;
    private static BufferedReader in; // Receive msg from the server
    private static BufferedReader keyboard; // Receive msg from this client
    private static PrintWriter out; // Send this client's msg to the server
    private static ObjectOutputStream fout; // send bytes of file to server
    private static ObjectInputStream fin;

    public static void signUp(BufferedReader keyboard) throws IOException {
        boolean isAccountValid = false;
        do {
            System.out.print("Your username: ");
            String username = keyboard.readLine();

            System.out.print("Your password: ");
            String password = keyboard.readLine();
            out.println("0");
            out.println(username);
            out.println(password);
            String isValid = in.readLine();
            if (isValid.equals("true")) {
                isAccountValid = true;
                account = new Account(username, password);
            } else {
                System.out.println("Username has already been taken");
            }

        } while (!isAccountValid);
        System.out.println("Welcome to Forum");

    }

    public static void signIn(BufferedReader keyboard) throws IOException {
        boolean isAccountValid = false;
        do {
            System.out.print("Username: ");
            String username = keyboard.readLine();
            System.out.print("Password: ");
            String password = keyboard.readLine();
            out.println("1");
            out.println(username);
            out.println(password);
            String isValid = in.readLine();
            System.out.println(isValid);
            if (isValid.equals("true")) {
                isAccountValid = true;
                account = new Account(username, password);
                System.out.println(isValid);
            }
            if (!isAccountValid) {
                System.out.println("Your username or your password is invalid");

            }
        } while (isAccountValid == false);
        System.out.println("Welcome to Forum");
    }

    static void signingMenu(BufferedReader keyboard) throws IOException {
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.print(">> ");
        String choice = keyboard.readLine();
        if (choice.equals("1")) {
            signIn(keyboard);
        } else {
            signUp(keyboard);
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        // ServerConnection serverConn = new ServerConnection(socket);
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        fout = new ObjectOutputStream(socket.getOutputStream());

        signingMenu(keyboard);
        out.println(account.getUserName() + " has joined");
        // Listen incoming msg from server (other clients)
        new Thread(() -> {
            listen();
        }).start();
        send();

    }

    static void send() throws IOException {
        // Send msg to server and let server send it to other client
        while (true) {
            String command = keyboard.readLine();
            if (command.startsWith("/sendfile")) {
                String[] msg = command.split(" ");
                String sourcePath = msg[1];
                String desPath = msg[2];
                sendFile(sourcePath, desPath);
            }
            // command = account.getUserName() + ": " + command;
            out.println(command);
        }
    }

    static void listen() {

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

                e.printStackTrace();
            }
        }
    }

    public static void sendFile(String src, String des) {
        // fin = null;
        // fout= null;
        try {
            // fout = new ObjectOutputStream(socket.getOutputStream());
            // get file info
            file fileInfo = getFileInfo(src, des);

            // send file content
            fout.writeObject(fileInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static file getFileInfo(String source, String des) {
        file newFile = new file();
        try {
            File sourceFile = new File(source);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));

            byte[] bytes = new byte[(int) sourceFile.length()];
            // get file info
            bis.read(bytes, 0, bytes.length);
            newFile.setFilename(sourceFile.getName());
            newFile.setDataBytes(bytes);
            newFile.setDestinationDirectory(des);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newFile;
    }
}
