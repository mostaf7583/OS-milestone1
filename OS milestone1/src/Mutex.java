import java.util.LinkedList;
import java.util.Queue;

public class Mutex {
    private boolean value ;
    private Queue<process> waiting = new LinkedList<process>();
    private int ownerID;
    
    public int getOwnerID() {
        return ownerID;
    }
    public boolean getValue() {
        return value;
    }
    public Queue<process> getWaiting() {
        return waiting;
    }

}

    