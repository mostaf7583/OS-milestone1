import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemCallHandler {
	private Scanner sc = new Scanner(System.in);

	public void handle(String[] instruction, process executingProcess) {
		switch (instruction[0]) {
		case "print":
			print(instruction[1]);
			break;

		case "assign": // assign a b
			if (instruction[2]=="input") {
				System.out.println("please enter a value");
				instruction[2] = sc.nextLine();
			}else {
				assign(instruction[1],instruction[2], executingProcess);
			}
			break;

		case "writeFile":
			writeFile(instruction[1], instruction[2]);
			break;

		case "read":
			instruction[1] = readFile(instruction[1]);
			break;
		case "printFromTo":

			int from = Integer.parseInt(instruction[1]);
			int to = Integer.parseInt(instruction[2]);
			
			printFromTo(from, to);
			break;
		}
	}

	
	
	
	
	public void print(String text) {
		System.out.println(text);
	}

	public void assign(String key, String value, process executingProcess) {
		executingProcess.addToVariables(key, value);
	}

	public void writeFile(String fileName, String data) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(data);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFile(String fileName) {
		String text = "";
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((bufferedReader.readLine()) != null) {
				text += bufferedReader.readLine();
			}

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public void printFromTo(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}
	}
}
