

import java.util.ArrayList;
import java.util.Random;

/**
 * RoomChat
 */
public class RoomChat {
    private Integer ID_ROOM;
    private ArrayList<ClientHandle> participants;
    private ClientHandle host;
    String name; 
    
    RoomChat(ClientHandle c, String name){
        this.ID_ROOM = new Random().nextInt(9998) + 1;
        this.host = c;
        this.name = name;
        participants = new ArrayList<>();
        participants.add(c);
    }
        
    void add(ClientHandle client)
    {
        participants.add(client);
    }

    Integer getID()
    {
        return ID_ROOM;
    }

    
    ArrayList<ClientHandle> getParticipants(){
        return this.participants;
    }

    ClientHandle getHost()
    {
        return host;
    }

    String getName()
    {
        return this.name;
    }
    
    void remove(ClientHandle c)
    {
        this.participants.remove(c);
                
    }
    
    boolean isInRoom(String username)
    {
       // Check if a user has joined room 
        for (ClientHandle participant : participants) {
            if (participant.getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }
}