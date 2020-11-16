import java.util.ArrayList;
import java.util.Random;

/**
 * RoomChat
 */
public class RoomChat {
    private String ID_ROOM;
    private ArrayList<ClientHandle> participants;
    private ClientHandle host;

    RoomChat(ClientHandle c){
        Random thuanmy = new Random();
        int trucvan = thuanmy.nextInt(999999);
        this.ID_ROOM = trucvan+"";
        this.host = c;
    }
        
    void add(ClientHandle client)
    {
        participants.add(client);
    }

    String getID()
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
}