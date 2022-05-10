import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Interpter {
    static Mutex m1;
    static process p = new process();

    // Queue<String> q = new Queue<String>();
    public Interpter(process p) {
        this.p = p;
        m1 = new Mutex();
    }

    // read data from file
    public static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                program_syntax(line, fileName); // running the program sys
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

    // take input from user
    public static String takeInput() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number- ");
            String a = sc.nextLine();
            return a;
        }
    }

    public static void program_syntax(String expression, String fileName) {
        String[] arr = expression.split(" ");
        String[] var = new String[3];

        switch (arr[0]) {
            case "print":
                if (m1.getUserOutput() == 0) {
                    break;
                } else {

                        m1.setUserOutput(0);
                        System.out.println(p.getVariables().get(arr[1]));
                        System.out.println();
                        m1.setUserOutput(1);
                    

                    break;
                }

            case "assign": // assign a b
                if (m1.getFile() == 1) {
                    if (arr[2] == "input") {
                        System.out.println("Please enter a value");
                        p.getVariables().put(arr[1], takeInput()); // put a input in hashmap

                    } else {
                        p.getVariables().put(arr[1], arr[2]); // put a b in hashmap
                    }

                }
                break;

            case "writeFile":
                m1.setFile(0);
                writeFile(arr[1], p.getVariables().get(arr[2]));
                break;

            case "read":
                readFile(arr[1]);
                break;
            case "printFromTo":
            

                int from = Integer.parseInt(p.getVariables().get(arr[1]));
                int to = Integer.parseInt(p.getVariables().get(arr[2]));
                for (int i = from; i <= to; i++) {
                    System.out.println(i);
                }
                break;
            case "semWait":
                if (var[1] == "userInput") {
                    if (m1.getUserInput() == 1) {
                        m1.setOwnerid(p.getPid());
                        m1.setUserInput(0);
                    } else {
                        /* place this process in m.queue */
                        /* block this process */
                        break;
                    }
                }

                else if (var[1] == "userOutput") {
                    if (m1.getUserInput() == 1) {
                        m1.setOwnerid(p.getPid());
                        m1.setUserOutput(0);
                    } else {
                        /* place this process in m.queue */
                        /* block this process */
                        break;
                    }
                } else if (var[1] == "file") {
                    if (m1.getUserInput() == 1) {
                        m1.setOwnerid(p.getPid());
                        m1.setFile(0);
                    } else {
                        /* place this process in m.queue */
                        /* block this process */
                        break;
                    }
                }
                System.out.println("semwait");
                break;
            case "semSignal":
                if (var[1] == "userInput") {
                    if (m1.getOwnerid() == p.getPid()) {
                        /*
                         * if (m.queue.isEmpty())
                         * m.value = one;
                         * else {
                         * /* remove a process P from m.queue
                         */
                        /* place process P on ready list */
                        /* update ownerID to be equal to Process P’s ID */
                    }
                } else if (var[1] == "userOutput") {

                } else if (var[1] == "file") {

                }
                System.out.println("semsignal");
                break;
        }
    }

}
