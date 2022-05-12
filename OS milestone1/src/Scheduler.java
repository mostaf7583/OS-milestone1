import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    public process schedule(Interpreter interpreter, int timeSlice, Queue<process> readyQueue, Queue<process> blockedQueue, ArrayList<process> pendingList ,process executingProcess) {
    	
    	for (int i = 0; i < pendingList.size(); i++) {
			if (pendingList.get(i).getTimeOfArrival() == interpreter.getClock()) {
				readyQueue.add(pendingList.remove(i));
			}
		}
    	
    	
    	
    	if (executingProcess == null) {
    		if (!readyQueue.isEmpty()) {
    			executingProcess = readyQueue.remove();
    			executingProcess.setTimeToLive(timeSlice);
    		}
		}
    	else if(executingProcess.getPc() == executingProcess.getInstructions().size()) {
    		//print the queues as the process is finished
    		if (!readyQueue.isEmpty()) {
    			executingProcess = readyQueue.remove();
    			executingProcess.setTimeToLive(timeSlice);
			}else {
				executingProcess = null;
			}
    	}else if (executingProcess.getTimeToLive() == 0) {
			//reset the time to live before before putting it back in the ready queue and assigning the first process in the queue as the new executing process
    		readyQueue.add(executingProcess);
    		executingProcess = readyQueue.remove();
    		executingProcess.setTimeToLive(timeSlice);
    		//also handle the time to live in semwait and semsignal(you can reset it whenever you move something from the ready queue to be the executing process
		}
    	
    	
    	return executingProcess;
    }
}
