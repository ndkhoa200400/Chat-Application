
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * ClientHandle Used to send one client's msg to other clients
 */
public class ClientHandle implements Runnable {

    private final Socket client;
    private final DataOutputStream out;
    private final DataInputStream in;
    private final ArrayList<ClientHandle> clients; // Keep trace the other clients
    private Account account;
    private ObjectInputStream fin;
    private ObjectOutputStream fout;
    private ArrayList<file> fileList = new ArrayList<file>();
    private Gson gson = new Gson();

    // Private room chat
    private final HashMap<Integer, RoomChat> rooms;

    ClientHandle(Socket clientSocker, ArrayList<ClientHandle> clients, HashMap<Integer, RoomChat> rooms)
            throws IOException {
        this.clients = clients;
        this.client = clientSocker;
        this.rooms = rooms;
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());
    }

    boolean checkSignUp(String username, String password) throws IOException {
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
        if (!clients.stream().filter(clientHandle -> (clientHandle != this)).noneMatch(clientHandle -> (clientHandle.account.getUserName().equals(username)))) {
            return false;
        }
        return (Account.checkAccount(username, password));
    }

    void inviteToRoom(String messages) throws IOException {
        // messages = "room_id: username"
        if (!checkValidRoomMessage(messages)) {
            return;
        }
        int indexIDROOM = messages.indexOf(": ");
        Integer ID_ROOM = Integer.parseInt(messages.substring(0, indexIDROOM));
        String invitedUsername = messages.substring(indexIDROOM + 2);
        RoomChat room = rooms.get(ID_ROOM);
        if (room != null) {
            if (room.getID().equals(ID_ROOM)) {
                // Check if this client is the host of the room
                if (room.getHost().getUsername().equals(this.getUsername())) {

                    // Check if user is online
                    for (ClientHandle clientHandle : clients) {
                        // Check if user is matched.
                        if (clientHandle.getUsername().equals(invitedUsername)) {
                            // check if user is already in room?
                            if (!room.isInRoom(invitedUsername)) {
                                room.add(clientHandle);
                                this.out.writeUTF("Invited " + invitedUsername + " to room " + room.getName());
                                // Send to invited client the confirm msg
                                clientHandle.out.writeUTF("invite " + room.getID() + " " + room.getName());
                                return;
                            } else {
                                this.out.writeUTF("This user is already in room");
                            }
                        }
                    }
                    this.out.writeUTF("User " + invitedUsername + " is currently offline");
                    return;
                }
                this.out.writeUTF("You are not allowed to invite");
                return;
            }
        } else {
            this.out.writeUTF("Room " + ID_ROOM + " is not existed...");

        }
    }

    void preJoining() {

        try {
            boolean isAccountValid = false;
            // Check account from client
            do {
                String mode = in.readUTF();
                String username = in.readUTF();
                String password = in.readUTF();
                String role = in.readUTF();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String getNameFileFromString(String filePath){
        int index = 0;
        for(int i = 0; i < filePath.length(); i++){
            if(filePath.charAt(i) == 92 || filePath.charAt(i) == ':'){
                index = i;
            }
        }
        return  filePath.substring(index + 1);
    }

    @Override
    public void run() {
        // Check status of sign up or log in 
        preJoining();

        // Method to send client's msg to others parallel
        try {
            sendToAll(this.getUsername() + " has joined");
            this.out.writeUTF("welcome to forum!");
            while (true) {
                String request = in.readUTF();
                System.out.println(request);
                if (request.equals("null")) {
                    {

                        break;
                    }
                } else if (request.startsWith("/")) {
                    request = request.substring(1);
                    int indexOfCommand = request.indexOf(" ");
                    String command = request.substring(0, indexOfCommand);
                    switch (command) {
                        // Command: /showonline id_room
                        // id_room = 0 if it is a public room
                        case "showonline":
                            Integer destination = Integer.parseInt(request.substring(indexOfCommand + 1));
                            if (destination == 0) {
                                showOnlineUsers();
                            } else {
                                RoomChat room = this.rooms.get(destination);
                                String onlineLists = "";

                                for (ClientHandle p : room.getParticipants()) {
                                    onlineLists += p.getUsername() + "\n";
                                }
                                this.out.writeUTF("showonline " + onlineLists);

                            }

                            break;
                        // Command: /createroom 
                        case "createroom":
                            String roomName = request.substring("createroom".length() + 1);
                            RoomChat room = new RoomChat(this, roomName);
                            rooms.put(room.getID(), room);
                            // Server will send back to client information of created room
                            this.out.writeUTF("createroom " + room.getID() + " " + room.getName());
                            break;

                        // Command: /invite room_chat: username
                        case "invite":
                            // Pass String "room_chat: username" to inviteToRoom
                            inviteToRoom(request.substring(indexOfCommand + 1));
                            break;

                        case "sendfile":
                            //request = account.getUserName() + " has already sent a new attachment.";
                            System.out.println("Client handle: path file: " + request.substring(indexOfCommand + 1));
                            if (recvFile(this.client, request.substring(indexOfCommand + 1))) {
                                String nameFile = getNameFileFromString(request.substring(indexOfCommand + 1));
                                sendToAll("sendfile " + this.account.getUserName() + " " + nameFile);
                                this.out.writeUTF("sendfile " + this.account.getUserName() + " " + nameFile);
                            } else {
                                this.out.writeUTF("Failed to send file");
                            }
                            break;
                        case "receivefile":
                            
                            sendFile(this.client, request.substring(indexOfCommand + 1));
                            this.out.writeUTF(this.account.getUserName() + "has downloaded " + request.substring(indexOfCommand + 1));
                            sendToAll(this.account.getUserName() + "has downloaded " + request.substring(indexOfCommand + 1));
                            System.out.println(request.substring(indexOfCommand + 1) + " has been downloaded");
                            break;
                        case "receivefile hinh.jpg":
                            sendFile(this.client, request.substring(indexOfCommand + 1));
                            break;

                        case "showroom":
                            for (RoomChat r : rooms.values()) {
                                if (r.getParticipants().contains(this)) {
                                    out.writeInt(r.getID());
                                }
                            }   
                            break;
                        case "showonlineroom":
                            RoomChat r = rooms.get(Integer.parseInt(request.substring(indexOfCommand + 1)));
                            r.getParticipants().forEach(p -> {
                                System.out.println(p.getUsername());
                            });
                            break;

                        // Send msg to specific room
                        case "room":
                            // Pass an argument: "room_id: msg" 
                            sendToRoom(request.substring(indexOfCommand + 1));
                            break;
                        case "changepassword":
                            changePassword();
                            break;

                        default:
                            // this.sender.println("Command is invalid");
                            this.out.writeUTF("Command is invalid");
                            break;
                    }
                } else {
                    request = this.account.getUserName() + ": " + request;
                    sendToAll(request);
                }

            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("IO exception in client handler");
            e.getStackTrace();
            e.printStackTrace();
        } finally {
            for (RoomChat room : this.rooms.values()) {
                room.remove(this);
            }
            clients.remove(this);
            try {
                //sendToAll(this.account.getUserName() + " has left!");
                this.client.close();
                out.close();
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }

    void changePassword() throws IOException {
        String currentPassword = in.readUTF();
        String newPassword = in.readUTF();
        if (!this.account.checkPassword(currentPassword)) {
            out.writeUTF("Your current password is incorrect. Please try again");
        } else {
            this.account.changePassword(newPassword);
            out.writeUTF("Changed password successfully");
        }
    }

    public void sendFile(Socket server, String fileName) {

        try {
            fout = new ObjectOutputStream(server.getOutputStream());
            fout.flush();
            // fin = new ObjectInputStream(server.getInputStream());
            for (file x : fileList) {
                if (x.getFilename().equals(fileName)
                        && x.getRecver().equals("all")) {
                    // send file content
                    fout.writeObject(x);
                    fout.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean recvFile(Socket client, String src) throws IOException {
        file newFile;
        boolean isValid = false;
        this.fin = new ObjectInputStream(client.getInputStream());

        FileWriter writer = null;
        try {

            // this.fout = new ObjectOutputStream(client.getOutputStream());
            newFile = (file) fin.readObject();
            if (newFile != null) {
                newFile.setDestinationDirectory("./src/database/");
                newFile.setCommunication(this.getUsername(), "all");
                newFile.createFile();
                // save to json
                try ( FileReader reader = new FileReader("./src/database/fileList.json")) {
                   
                    // Read JSON file
                    JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                    if (obj == null) {
                        obj = new JsonArray();
                    }
                    JsonObject temp = new JsonObject();

                    temp.addProperty("name", newFile.getFilename());
                    temp.addProperty("type", newFile.getFileType());
                    temp.addProperty("des", newFile.getDestinationDirectory());
                    temp.addProperty("size", newFile.getFileSize());
                    temp.addProperty("size", newFile.getFileSize());
                    temp.addProperty("date", gson.toJson(newFile.getDate()));
                    temp.addProperty("sender", newFile.getSender());
                    temp.addProperty("receiver", newFile.getRecver());

                    obj.add(temp);

                    writer = new FileWriter("./src/database/fileList.json", false);
    
                    gson.toJson(obj, writer);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
                // send confirmation
                newFile.setStatus("Success");
                isValid = true;
                fileList.add(newFile);
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void sendToRoom(String message) throws IOException {
        // message= "room_id: msg"
        if (!checkValidRoomMessage(message)) {
            return;
        }

        int indexRoomID = message.indexOf(": ");

        Integer ID_ROOM = Integer.parseInt(message.substring(0, indexRoomID));

        String msg = this.getUsername() + ": ";

        RoomChat room = rooms.get(ID_ROOM);
        if (room != null) {

            msg += message.substring(indexRoomID + 2);

            if (room.getID().equals(ID_ROOM)) {

                if (msg.contains("/showuser")) {
                    for (ClientHandle participant : room.getParticipants()) {
                        this.out.writeUTF(". " + participant.getUsername());
                    }
                } else {
                    for (ClientHandle participant : room.getParticipants()) {
                        if (participant != this) {
                            participant.out.writeUTF(ID_ROOM + "-" + msg);
                        }
                    }
                }
            }
        }
    }

    void sendToAll(String msg) throws IOException {
        if (msg.equals("null") || msg == null || msg.isEmpty()) {
            System.out.println("!! Clienthandle: message in sendToAll is null.");
            return;
        }
        for (ClientHandle clientHandle : clients) {
            if (clientHandle != this) // clientHandle.sender.println(msg);
            {
                clientHandle.out.writeUTF(msg);
            }
        }
    }

    void showOnlineUsers() throws IOException {

        String onlineLists = "";
        for (ClientHandle clientHandle : clients) {

            onlineLists += clientHandle.account.getUserName() + "\n";
        }
        this.out.writeUTF("showonline " + onlineLists);
    }

    String getUsername() {
        return account.getUserName();
    }

    private boolean checkValidRoomMessage(String message) throws IOException {
        // check if id room is numeric
        if (!isNumeric(message.substring(0, message.indexOf(": ")))) {
            this.out.writeUTF("ID ROOM is invalid! Please try again");
            return false;
        }
        return true;
    }

    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
