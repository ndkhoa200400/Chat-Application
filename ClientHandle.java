import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * ClientHandle Used to send one client's msg to other clients
 */
public class ClientHandle implements Runnable {
    private Socket client;
    private BufferedReader receiver; // Receive msg from server (sent by other clients)
    private PrintWriter sender; // Send this client's msg to server
    private ArrayList<ClientHandle> clients; // Keep trace the other clients
    private Account account;
    // Private room chat
    private static TreeSet<RoomChat> rooms = new TreeSet<RoomChat>(new Comparator<RoomChat>() {
        @Override
        public int compare(RoomChat o1, RoomChat o2) {
            if (o1.getID() > o2.getID())
                return 1;
            if (o1.getID() < o2.getID())
                return -1;
            return 0;
        }

    });

    ClientHandle(Socket clientSocker, ArrayList<ClientHandle> clients) throws IOException {
        this.clients = clients;
        this.client = clientSocker;
        this.receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.sender = new PrintWriter(client.getOutputStream(), true);
    }

    boolean checkSignUp(String username, String password) {
        if (Account.isExisted(username)) {

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

    void inviteToRoom(String[] messages) {
        if(!checkValidRoomMessage(messages))
        {
            return;
        }
        Integer ID_ROOM = Integer.parseInt(messages[1]);
        String newUsername = messages[2];
        for (RoomChat room : rooms) {
            // Check if id room exists
            if (room.getID()==(ID_ROOM)) {
                // Check if this client is the host of the room
                if (room.getHost() == this) {
                    // Check if user is online
                    for (ClientHandle clientHandle : clients) {
                        if (clientHandle.getUsername().equals(newUsername)) {
                            room.add(clientHandle);
                            return;
                        }
                    }
                    System.out.println("User " + newUsername + " is currently offline");
                    return;
                }
                System.out.println("You are not allowed to invite");
                return;
            }

        }
        System.out.println("Room " + ID_ROOM + " is not existed...");
    }

    @Override
    public void run() {

        // Method to send client's msg to others parallel
        try {
            boolean isAccountValid = false;
            // Check account from client
            do {
                String mode = receiver.readLine();
                String username = receiver.readLine();
                String password = receiver.readLine();
                // System.out.println(mode + ", " + username + ", " + password);
                if (mode.equals("0")) {
                    isAccountValid = checkSignUp(username, password);

                } else {
                    isAccountValid = checkSignIn(username, password);
                }
                if (isAccountValid) {
                    this.sender.println("true");
                    account = new Account(username, password);
                } else {
                    this.sender.println("false");
                }
            } while (!isAccountValid);

            while (true) {
                String request = receiver.readLine();
                if (request.equals("null")) {
                    {
                        this.sender.println("Out");
                       
                        break;
                    }
                } else if (request.startsWith("/")) {
                    request = request.substring(1);
                    String[] messages = request.split(" ");
                    switch (messages[0]) {
                        case "showonline":
                            showOnlineUsers();
                            break;
                        case "creategroup":
                            RoomChat room = new RoomChat(this);
                            rooms.add(room);
                            this.sender.println("Room has been created! ID: " + room.getID());
                            break;
                        // Syntax: /invite room_chat username
                        case "invite":
                            inviteToRoom(messages);
                            break;
                        // Syntax: /room ID_room msg
                        case "room":
                            sendToRoom(messages);
                            break;
                        default:
                            this.sender.println("Command is invalid");
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
            sender.close();
            try {
                receiver.close();
            } catch (Exception e) {
                System.err.println("Exception in closing");
                System.err.println(e.getStackTrace());

            }
            clients.remove(this);
            sendToAll(this.account.getUserName() + " has left!");
            try {
                this.client.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    void sendToRoom(String[] message) {
        if (!checkValidRoomMessage(message))
        {
           return;
        }
        String msg = "";
        for (int i = 2; i < message.length; i++) {
            msg += message[i] + " ";
        }
        Integer ID_ROOM = Integer.parseInt(message[1]);
        for (RoomChat room : rooms) {
            if (room.getID() == ID_ROOM)
            {
                for(ClientHandle participant: room.getParticipants()){
                    participant.sender.println(msg);
                }
                break;
            }
        }
    }

    void sendToAll(String msg) {
        if (msg.equals("null"))
            return;
        for (ClientHandle clientHandle : clients) {
            if (clientHandle != this)
                clientHandle.sender.println(msg);
        }
    }

    void showOnlineUsers() {
        this.sender.println("Number of online users: " + clients.size());
        for (ClientHandle clientHandle : clients) {
            this.sender.println(". " + clientHandle.account.getUserName());
        }
    }

    String getUsername() {
        return account.getUserName();
    }

    public boolean checkValidRoomMessage(String []message)
    {
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
    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}