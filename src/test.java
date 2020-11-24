import java.util.Comparator;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
       TreeSet<RoomChat> rooms = new TreeSet<RoomChat>(new Comparator<RoomChat>(){
           @Override
           public int compare(RoomChat o1, RoomChat o2) {
               if (o1.getID() > o2.getID()) return 1;
               if (o1.getID() < o2.getID()) return -1;
               return 0;
           }

       });
           
       
       rooms.add(new RoomChat(null));
       rooms.add(new RoomChat(null));
       for (RoomChat roomChat : rooms) {
           System.out.println(roomChat.getID());
       }
    }
}
