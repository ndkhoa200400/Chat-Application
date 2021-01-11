
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    public static Account account;
    public static Socket server;

    public static boolean logIn(String username, String password) throws IOException, ClassNotFoundException {
        boolean isAccountValid = false;

        String mode = Account.setMode(username);

        out.writeUTF("1");
        out.writeUTF(username);
        out.writeUTF(password);
        out.writeUTF(mode);

        String isValid = in.readUTF();

        if (isValid.equals("true")) {
            isAccountValid = true;
            account = new Account(username, password);

        }

        return isAccountValid;
    }

    public static boolean signUp(String username, String password) throws IOException, ClassNotFoundException {
        boolean isAccountValid = false;
        do {

            String mode = Account.setMode(username);

            // System.out.println("Your profile picture: ");
            // String filePath = keyboard.readLine();
            // file obj = new file();
            // obj.getFileInfo(filePath,"./");
            out.writeUTF("0");
            out.writeUTF(username);
            out.writeUTF(password);
            out.writeUTF(mode);

            // String isValid = in.readLine();
            String isValid = in.readUTF();
            if (isValid.equals("true")) {
                isAccountValid = true;
                account = new Account(username, password);
            }
        } while (!isAccountValid);
        return isAccountValid;

    }

    public static void signUp(BufferedReader keyboard) throws IOException, ClassNotFoundException {
        boolean isAccountValid = false;
        do {
            System.out.print("Your username: ");
            String username = keyboard.readLine();

            System.out.print("Your password: ");
            String password = keyboard.readLine();

            String mode = Account.setMode(username);

            // System.out.println("Your profile picture: ");
            // String filePath = keyboard.readLine();
            // file obj = new file();
            // obj.getFileInfo(filePath,"./");
            out.writeUTF("0");
            out.writeUTF(username);
            out.writeUTF(password);
            out.writeUTF(mode);

            // String isValid = in.readLine();
            String isValid = in.readUTF();
            if (isValid.equals("true")) {
                isAccountValid = true;
                account = new Account(username, password);
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
            String mode = Account.setMode(username);

            out.writeUTF("1");
            out.writeUTF(username);
            out.writeUTF(password);
            out.writeUTF(mode);

            String isValid = in.readUTF();

            if (isValid.equals("true")) {
                isAccountValid = true;
                account = new Account(username, password);

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

    public static void connectToServer() throws IOException {
        server = new Socket(SERVER_IP, SERVER_PORT);
        out = new DataOutputStream(server.getOutputStream());
        in = new DataInputStream(server.getInputStream());
    }

    static void send(String message) {
        try {
            out.writeUTF(message);
        } catch (Exception ex) {

        }

    }

    static void send(Socket server) throws IOException {
        // Send msg to server and let server send it to other client
        while (true) {
            String command = keyboard.readLine();
            String[] messages = command.split(" ");
            if (command.startsWith("/")) {
                switch (messages[0]) {
                    // sendfile ./testfile/hinh.jpg => send file public
                    case "/sendfile":
                        out.writeUTF(command);
                        sendFile(server, messages[1]);
                        break;
//                     //recv hinh.jpg
                    case "/receive":
                        out.writeUTF(command);
                        break;
                    case "/showonline":
                        System.out.println(in.readUTF());
                        break;

                    default:
                        out.writeUTF("Command is invalid");
                        break;
                }
            } else {
                out.writeUTF(command);
            }
        }
    }

    static String listen() {

        try {

            String serverResponse = in.readUTF();
            if (serverResponse.equals("The file is downloading")) {
                //prepare to receive file
                if (recvFile(server)) {
                    System.out.println("Receiving file successfully");
                    send("Receiving file successfully");
                }
            } else {
                System.out.println(serverResponse);
            }
            return serverResponse;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void listen(Socket server) {

        try {
            while (true) {
                String serverResponse = in.readUTF();
                if (serverResponse.equals("The file is downloading")) {
                    //prepare to receive file
                    if (recvFile(server)) {
                        System.out.println("Receving file successfully");
                        out.writeUTF("The file has been downloaded to your local disk");
                    }
                } else {
                    System.out.println(serverResponse);
                }
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

    public static void sendFile(Socket server, String src) throws IOException {
        try {
            //fout = new ObjectOutputStream(server.getOutputStream());
            //fout.flush();
            // get file info
            file fileInfo = new file();
            fileInfo.getFileInfo(src);

            // send file content
            out.writeInt(fileInfo.getDataBytes().length);
            out.write(fileInfo.getDataBytes(), 0, fileInfo.getDataBytes().length);
            out.writeUTF(fileInfo.getFilename());
            out.writeUTF(fileInfo.getFileType());
            out.writeLong(fileInfo.getLastModified());
            out.flush();
            //fout.writeObject(fileInfo);
            //fout.flush();
            System.out.println("Sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static boolean recvFile(Socket server) throws IOException {
        file newFile = new file();
        boolean isValid = false;
        BufferedOutputStream bos = null;
        System.out.println("Downloading");

        try {
            // this.fout = new ObjectOutputStream(client.getOutputStream());
            //newFile = (file) fin.readObject();
            //in.readInt();
            int length = in.readInt();

            byte[] bytearray = new byte[length];
            int byteReads = in.read(bytearray, 0, length);
            System.out.println(byteReads);
            newFile.setDataBytes(bytearray);
            newFile.setFilename(in.readUTF());
            newFile.setFileType(in.readUTF());

            String recv = in.readUTF();
            String sender = in.readUTF();
            newFile.setCommunication(sender, recv);
            newFile.setLastModified(in.readLong());
            newFile.setDestinationDirectory("D:");

            if (newFile != null) {
                File fileRecv = new File(
                        newFile.getDestinationDirectory() + newFile.getSender() + "_" + newFile.getRecver() + "_" + newFile.getFilename());
                bos = new BufferedOutputStream(new FileOutputStream(fileRecv));
                // write file content
                bos.write(bytearray);
                bos.flush();

                // send confirmation
                newFile.setStatus("Success");
                isValid = true;
                System.out.println("Downloaded! ");

                bos.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isValid;
    }

    public static void close() {
        try {
            server.close();
            out.close();
            in.close();
        } catch (Exception e) {
        }
    }
}
