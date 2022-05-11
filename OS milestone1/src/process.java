import java.util.ArrayList;
import java.util.HashMap;

public class process {
	private int pid;
	private int timeOfArrival;
	private ArrayList<String[]> instructions = new ArrayList<>();
	private int PC = 0;
	private HashMap<String, String> variables = new HashMap<String, String>();

	
	
	public process(int pid,int timeOfArrival) {
		this.pid = pid;
		this.timeOfArrival = timeOfArrival;
	}

	public HashMap<String, String> getVariables() {
		return variables;
	}

	public void setVariables(HashMap<String, String> variables) {
		this.variables = variables;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPC() {
		return PC;
	}

	public ArrayList<String[]> getInstructions() {
		return instructions;
	}

	public void setInstructions(ArrayList<String[]> instructions) {
		this.instructions = instructions;
	}

	public int getTimeOfArrival() {
		return timeOfArrival;
	}

	public void setTimeOfArrival(int timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	
	
	public void addToVariables(String key,String value) {
		this.variables.put(key, value);
	}

}
