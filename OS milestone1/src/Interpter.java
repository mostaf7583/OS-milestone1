import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Interpter {
    // read data from file
    public static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // take txt from user
    public static int takeTxt() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number- ");
            int a = sc.nextInt();
            return a;
        }
    }

    // write data to file
    public static void writeFile(String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void program_syntax(String expression) {
        String[] arr = expression.split(" ");
        String [] var = new String[3];
        switch (arr[0]) {
            case "print":
                System.out.println(arr[1]);
                break;
            // code block
            case "assign":
                var[0] = arr[1];
                break;
            // code block
            case "writefile":
                writeFile(arr[1], arr[2]);
                break;
            // code block
            case "read":
                readFile(arr[1]);
                break;
            case "printfromto":
            // convert from String to int
                int from = Integer.parseInt(arr[1]);
                int to = Integer.parseInt(arr[2]);
                for(int i=from; i <= to; i++) {
                    System.out.println(i);
                }
                break;
            case "semwait":
                System.out.println("semwait");
                break;
            case "semsignal":
                System.out.println("semsignal");
                break;
        }
    }

    public static void main(String[] args) throws Exception {
       String expression = "I am a student";
        String[] arr = expression.split(" ");
        //print array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        takeTxt();
        readFile("Program_1.txt");
    }
}
