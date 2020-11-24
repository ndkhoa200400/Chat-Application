import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * ClientHandle Used to send one client's msg to other clients
 */
public class ClientHandle implements Runnable {
    private Socket client;
    private DataOutputStream out;
    private DataInputStream in;
    private ArrayList<ClientHandle> clients; // Keep trace the other clients
    private Account account;
    private ObjectInputStream fin;
    private ObjectOutputStream fout;

    // Private room chat
    private ArrayList<RoomChat> rooms;

    ClientHandle(Socket clientSocker, ArrayList<ClientHandle> clients, ArrayList<RoomChat> rooms) throws IOException {
        this.clients = clients;
        this.client = clientSocker;
        this.rooms = rooms;
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());

    }

    boolean checkSignUp(String username, String password) {
        if (Account.isExisted(username)) {
          
            return false;
        }
        if (!Account.isValidString(username)) {
        
            return false;
        }
        Account.signUp(username, password);

        return true;
    }

    boolean checkSignIn(String username, String password) throws IOException {
        for (ClientHandle clientHandle : clients) {
            if (clientHandle != this)
                if (clientHandle.account.getUserName().equals(username))
                    return false;
        }
        return (Account.checkAccount(username, password));
    }

    void inviteToRoom(String[] messages) throws IOException {
        if (!checkValidRoomMessage(messages)) {
            return;
        }
        Integer ID_ROOM = Integer.parseInt(messages[1]);
        String invitedUsername = messages[2];

        for (RoomChat room : rooms) {

            // Check if id room exists
            if (room.getID().equals(ID_ROOM)) {
                // Check if this client is the host of the room
                if (room.getHost().getUsername().equals(this.getUsername())) {
                    // Check if user is online
                    for (ClientHandle clientHandle : clients) {
                        if (clientHandle.getUsername().equals(invitedUsername)) {

                            room.add(clientHandle);
                            this.out.writeUTF("Invited " + invitedUsername + " to room " + ID_ROOM);
                            clientHandle.out.writeUTF("You have been invited to room #" + room.getID());
                            return;
                        }
                    }
                    this.out.writeUTF("User " + invitedUsername + " is currently offline");
                    return;
                }
                this.out.writeUTF("You are not allowed to invite");
                return;
            }
         
        }
    }

    // }
    // System.out.println("Room " + ID_ROOM + " is not existed...");
    // }

    @Override
    public void run() {

        // Method to send client's msg to others parallel
        try {
            boolean isAccountValid = false;
            // Check account from client
            do {
                String mode = in.readUTF();
                String username = in.readUTF();
                String password = in.readUTF();

                if (mode.equals("0")) {
                    isAccountValid = checkSignUp(username, password);

                } else {
                    isAccountValid = checkSignIn(username, password);
                }
                if (isAccountValid) {
                    this.out.writeUTF("true");
                    account = new Account(username, password);
                } else {
                    this.out.writeUTF("false");
                }
            } while (!isAccountValid);

            while (true) {
                String request = in.readUTF();
                if (request.equals("null")) {
                    {
                        this.out.writeUTF("Out");
                        break;
                    }
                } else if (request.startsWith("/")) {
                    request = request.substring(1);
                    String[] messages = request.split(" ");
                    switch (messages[0]) {
                        case "showonline":
                            showOnlineUsers();
                            break;
                            
                        case "createroom":
                            RoomChat room = new RoomChat(this);
                            rooms.add(room);
                            this.out.writeUTF("Room has been created! ID: " + room.getID());
                            break;

                        // Syntax: /invite room_chat username
                        case "invite":
                            inviteToRoom(messages);
                            break;

                        case "sendfile":
                            request = account.getUserName() + " has already sent a new attachment.";
                            if (recvFile(this.client,messages[1], messages[2]))
                                sendToAll(request);
                            else 
                                sendToAll("Failed in sending attachment.");
                            break;

                        case "showroom":
                            for (RoomChat r : rooms) {
                                out.writeInt(r.getID());
                            }
                            break;

                        default:
                            // this.sender.println("Command is invalid");
                            this.out.writeUTF("Command is invalid");
                            break;
                    }
                } else {
                    request = account.getUserName() + ": " + request;
                    sendToAll(request);
                }

            }

        } catch (Exception e) {
            System.err.println("IO exception in client handler");
            System.err.println(e.getStackTrace());
        } finally {
            try {
                out.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                in.close();
            } catch (Exception e) {
                System.err.println(e.getStackTrace());

            }
            clients.remove(this);
            try {
                sendToAll(this.account.getUserName() + " has left!");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                this.client.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    boolean recvFile(Socket client,String src, String des) throws IOException {
        file newFile;
        boolean isValid = false;
        this.fin = new ObjectInputStream(client.getInputStream());
        try {

            // this.fout = new ObjectOutputStream(client.getOutputStream());
            newFile = (file) fin.readObject();
            if (newFile != null){
                createFile(newFile);
                //send confirmation
                newFile.setStatus("Success");
                isValid = true;
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isValid;
    }

    public boolean createFile(file newFile) {
        BufferedOutputStream bos = null;
        try {
            if (newFile != null) {
                File fileRecv = new File(newFile.getDestinationDirectory() + newFile.getFilename());
                bos = new BufferedOutputStream(new FileOutputStream(fileRecv));
                // write file content
                bos.write(newFile.getDataBytes());
                bos.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void sendToRoom(String[] message) throws IOException {
        if (!checkValidRoomMessage(message)) {
            return;
        }
        String msg = this.getUsername() + "(from " + message[1] + "): ";

        for (int i = 2; i < message.length; i++) {
            msg += message[i] + " ";
        }

        Integer ID_ROOM = Integer.parseInt(message[1]);
        for (RoomChat room : rooms) {
            if (room.getID().equals(ID_ROOM)) {

                if (msg.contains("/showuser")) {
                    for (ClientHandle participant : room.getParticipants()) {    
                        this.out.writeUTF(". " + participant.getUsername());
                    }
                }
                else{
                    for (ClientHandle participant : room.getParticipants()) {
                        if (participant != this)
                            participant.out.writeUTF(msg);
                    }
                }
                break;
            }
        }
    }

    void sendToAll(String msg) throws IOException {
        if (msg.equals("null"))
            return;
        for (ClientHandle clientHandle : clients) {
            if (clientHandle != this)
                // clientHandle.sender.println(msg);
                clientHandle.out.writeUTF(msg);
        }
    }

    void showOnlineUsers() throws IOException {
        // this.sender.println("Number of online users: " + clients.size());
        this.out.writeUTF("Number of online users: " + clients.size());
        for (ClientHandle clientHandle : clients) {
            // this.sender.println(". " + clientHandle.account.getUserName());
            this.out.writeUTF(". " + clientHandle.account.getUserName());
        }
    }

    String getUsername() {
        return account.getUserName();
    }

    public boolean checkValidRoomMessage(String[] message) throws IOException {
        if (message.length < 3) {
            this.out.writeUTF("Command is invalid! Please try again");
            return false;
        }
        if (!isNumeric(message[1])) {
            this.out.writeUTF("ID ROOM is invalid! Please try again");
            return false;
        }
        return true;
    }

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}