import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    // private static BufferedReader in; // Receive msg from the server
    private static DataInputStream in;
    private static DataOutputStream out;
    private static BufferedReader keyboard; // Receive msg from this client
    // private static PrintWriter out; // Send this client's msg to the server
    private static ObjectOutputStream fout; // send bytes of file to server
    private static ObjectInputStream fin;

    public static void signUp(BufferedReader keyboard) throws IOException, ClassNotFoundException {
        boolean isAccountValid = false;
        do {
            System.out.print("Your username: ");
            String username = keyboard.readLine();

            System.out.print("Your password: ");
            String password = keyboard.readLine();

            out.writeUTF("0");
            out.writeUTF(username);
            out.writeUTF(password);
            // String isValid = in.readLine();
            String isValid = in.readUTF();
            if (isValid.equals("true")) {
                isAccountValid = true;

            } else {
                System.out.println("Username has already been taken");
            }

        } while (!isAccountValid);
        System.out.println("Welcome to Forum");

    }

    public static void signIn(BufferedReader keyboard) throws IOException, ClassNotFoundException {
        boolean isAccountValid = false;
        do {
            System.out.print("Username: ");
            String username = keyboard.readLine();
            System.out.print("Password: ");
            String password = keyboard.readLine();

            out.writeUTF("1");
            out.writeUTF(username);
            out.writeUTF(password);

            String isValid = in.readUTF();

            if (isValid.equals("true")) {
                isAccountValid = true;

            }
            if (!isAccountValid) {
                System.out.println("Your username or your password is invalid");

            }
        } while (isAccountValid == false);
        System.out.println("Welcome to Forum");
    }

    static void signingMenu(BufferedReader keyboard) throws IOException, ClassNotFoundException {
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

    static void changePassword() throws IOException {
        System.out.println("Enter your current password: ");
        String password = keyboard.readLine();
        out.writeUTF(password);
        System.out.println("Enter new password: ");
        String newPassword = keyboard.readLine();
        out.writeUTF(newPassword);
        
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket server = new Socket(SERVER_IP, SERVER_PORT);

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        out = new DataOutputStream(server.getOutputStream());
        in = new DataInputStream(server.getInputStream());

        // fout = new ObjectOutputStream(socket.getOutputStream());

        signingMenu(keyboard);

        // Listen incoming msg from server (other clients)
        new Thread(() -> {
            listen(server);
        }).start();
        send(server);

    }

    static void send(Socket server) throws IOException {
        // Send msg to server and let server send it to other client
        while (true) {
            String command = keyboard.readLine();
            if (command.startsWith("/sendfile")) {
                out.writeUTF(command);
                String[] msg = command.split(" ");
                String sourcePath = msg[1];
                String desPath = msg[2];
                sendFile(server, sourcePath, desPath);
            } else if (command.startsWith("/changepassword")) {
                out.writeUTF(command);
                changePassword();

            } else
                // command = account.getUserName() + ": " + command;
                out.writeUTF(command);
        }
    }

    static void listen(Socket server) {

        try {
            while (true) {
                String serverResponse = in.readUTF();
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

    public static void sendFile(Socket server, String src, String des) throws IOException {

        fout = null;

        try {
            fout = new ObjectOutputStream(server.getOutputStream());
            fout.flush();
            // fin = new ObjectInputStream(server.getInputStream());

            // get file info
            file fileInfo = new file();
            fileInfo = getFileInfo(src, des);

            // send file content
            fout.writeObject(fileInfo);
            fout.flush();
            System.out.println("Sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

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
            newFile.setFileSize(sourceFile.length());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newFile;
    }
}
