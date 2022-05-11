import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Interpter {
	private Scanner sc = new Scanner(System.in);
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	private int timeSlice =2;
	private int processCount = 0;
	private int clock = 0;
	private Mutex userInput, userOutput, file;
	private Queue<process> readyQueue = new LinkedList<>();
	private Queue<process> blockedQueue = new LinkedList<>();
	private Queue<process> pendingQueue = new LinkedList<>();

	private process executingProcess;
	private SystemCallHandler systemCallHandler = new SystemCallHandler();
	// Queue<String> q = new Queue<String>();

	public Interpter() {
		
	}

	public static void main(String[] args) {
		String path;
		for (int i = 0; i < 3; i++) {
			System.out.println("please enter the file path of the process and its time of arrival");

		}
	}

	// read data from file
	public void createProcess(String path, int timeOfArrival) {
		try {
			processCount++;
			process tempProcess = new process(processCount, timeOfArrival);
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				tempProcess.getInstructions().add(line.split(" "));
			}
			if (timeOfArrival == 0) {
				readyQueue.add(tempProcess);
			} else {
				pendingQueue.add(tempProcess);
			}

			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	// take txt from user
//	public int takeTxt() {
//
//		System.out.print("Enter first number- ");
//		int a = sc.nextInt();
//		return a;
//
//	}
//
//	// write data to file
//	public void writeFile(String fileName, String data) {
//		try {
//			FileWriter fileWriter = new FileWriter(fileName);
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			bufferedWriter.write(data);
//			bufferedWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// take input from user
//	public String takeInput() {
//		try (Scanner sc = new Scanner(System.in)) {
//			System.out.print("Enter first number- ");
//			String a = sc.nextLine();
//			return a;
//		}
//	}

	void semWaitB(Mutex m) {
		if (m.getValue() == true) {
			m.setOwnerID(executingProcess.getPid());
			m.setValue(false);
		} else {
			/* place this process in m.queue */
			m.addToWaiting(executingProcess);
			/* block this process */
			blockedQueue.add(executingProcess);
			executingProcess = null;
		}
	}

	void semSignalB(Mutex m) {
		/* check if this process is the owner */
		if (m.getOwnerID() == executingProcess.getPid()) {
			if (m.getWaiting().isEmpty()) {
				m.setValue(true);
			} else {
				/* update ownerID to be equal to Process P’s ID */
				m.setOwnerID(m.getWaiting().peek().getPid());
				/* remove a process P from m.queue */
				/* place process P on ready list */
				blockedQueue.remove(m.getWaiting().peek());
				readyQueue.add(m.removeFromWaiting());
				
			}
		}
	}

	public void executeInstruction(String[] instruction) {
		switch (instruction[0]) {
		case "semWait":
			switch (instruction[1]) {
			case "userInput":
				semWaitB(userInput);
				break;
			case "userOutput":
				semWaitB(userOutput);
				break;
			case "file":
				semWaitB(file);
				break;

			}
			break;
		case "semSignal":
			switch (instruction[1]) {
			case "userInput":
				semSignalB(userInput);
				break;
			case "userOutput":
				semSignalB(userOutput);
				break;
			case "file":
				semSignalB(file);
				break;

			}
			break;
		default:
			systemCallHandler.handle(instruction, executingProcess);

		}
	}

}
