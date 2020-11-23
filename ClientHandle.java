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
<<<<<<< Updated upstream
    private ObjectOutputStream fout;
=======

>>>>>>> Stashed changes
    // Private room chat
    private ArrayList<RoomChat> rooms;

    ClientHandle(Socket clientSocker, ArrayList<ClientHandle> clients, ArrayList<RoomChat> rooms) throws IOException {
        this.clients = clients;
        this.client = clientSocker;
<<<<<<< Updated upstream
        this.rooms = rooms;
        this.receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.sender = new PrintWriter(client.getOutputStream(), true);
        // this.fout = new ObjectOutputStream(client.getOutputStream());

        // this.fin = new ObjectInputStream(client.getInputStream());
=======
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());
      

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    void inviteToRoom(String[] messages) {
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
                            this.sender.println("Invited " + invitedUsername + " to room " + ID_ROOM);
                            clientHandle.sender.println("You have been invited to room #" + room.getID());
                            return;
                        }
                    }
                    this.sender.println("User " + invitedUsername + " is currently offline");
                    return;
                }
                this.sender.println("You are not allowed to invite");
                return;
            }
=======
    // void inviteToRoom(String[] messages) {
    // if (!checkValidRoomMessage(messages)) {
    // return;
    // }
    // Integer ID_ROOM = Integer.parseInt(messages[1]);
    // String newUsername = messages[2];
    // for (RoomChat room : rooms) {
    // // Check if id room exists
    // if (room.getID() == (ID_ROOM)) {
    // // Check if this client is the host of the room
    // if (room.getHost() == this) {
    // // Check if user is online
    // for (ClientHandle clientHandle : clients) {
    // if (clientHandle.getUsername().equals(newUsername)) {
    // room.add(clientHandle);
    // return;
    // }
    // }
    // System.out.println("User " + newUsername + " is currently offline");
    // return;
    // }
    // System.out.println("You are not allowed to invite");
    // return;
    // }
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
                String mode = receiver.readLine();
                String username = receiver.readLine();
                String password = receiver.readLine();
=======
                String mode = in.readUTF();
                String username = in.readUTF();
                String password = in.readUTF();
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
                        this.sender.println("Out");

=======
              
                        this.out.writeUTF("Out");
>>>>>>> Stashed changes
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
                            // this.sender.println("Room has been created! ID: " + room.getID());
                            this.out.writeUTF("Room has been created! ID: " + room.getID());
                            break;

                        // Syntax: /invite room_chat username
<<<<<<< Updated upstream
                        case "invite":
                            inviteToRoom(messages);
                            break;

=======
                        // case "invite":
                        // inviteToRoom(messages);
                        // break;
>>>>>>> Stashed changes
                        // Syntax: /room ID_room msg
                        // case "room":
                        // sendToRoom(messages);
                        // // break;
                        case "sendfile":
<<<<<<< Updated upstream
                            recvFile(messages[1], messages[2]);
                            break;
                        case "showroom":
                            for (RoomChat r : rooms) {
                                sender.println(r.getID());
                            }
=======
                            recvFile(this.client,messages[1], messages[2]);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

    void recvFile(String src, String des) {
=======
    void recvFile(Socket client,String src, String des) throws IOException {
>>>>>>> Stashed changes
        file newFile;
        // this.fout = new ObjectOutputStream(client.getOutputStream());
        this.fin = new ObjectInputStream(client.getInputStream());

        try {
            newFile = (file) fin.readObject();
            if (newFile != null)
                createFile(newFile);
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
<<<<<<< Updated upstream

    void sendToRoom(String[] message) {
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
                        this.sender.println(". " + participant.getUsername());
                    }
                }
                else{
                    for (ClientHandle participant : room.getParticipants()) {
                        if (participant != this)
                            participant.sender.println(msg);
                    }
                }
                break;
            }
        }
    }
=======
    
    // void sendToRoom(String[] message) {
    //     if (!checkValidRoomMessage(message))
    //     {
    //        return;
    //     }
    //     String msg = "";
    //     for (int i = 2; i < message.length; i++) {
    //         msg += message[i] + " ";
    //     }
    //     Integer ID_ROOM = Integer.parseInt(message[1]);
    //     for (RoomChat room : rooms) {
    //         if (room.getID() == ID_ROOM)
    //         {
    //             for(ClientHandle participant: room.getParticipants()){
    //                 participant.sender.println(msg);
    //             }
    //             break;
    //         }
    //     }
    // }
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
    public boolean checkValidRoomMessage(String[] message) {
        if (message.length < 3) {
            this.sender.print("Command is invalid! Please try again");
            return false;
        }
        if (!isNumeric(message[1])) {
            this.sender.print("ID ROOM is invalid! Please try again");
            return false;
        }
        return true;
    }

=======
    // public boolean checkValidRoomMessage(String []message)
    // {
    //     if (message.length < 3) {
    //         this.sender.print("Command is invalid! Please try again");
    //         return false;
    //     }
    //     if (!isNumeric(message[1])) {
    //         this.sender.print("ID ROOM is invalid! Please try again");
    //         return false;
    //     }
    //     return true; 
    // }
>>>>>>> Stashed changes
    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}