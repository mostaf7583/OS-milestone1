import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner ;
// hi 
public class Interpter {
    static Mutex m1 ;
    public Interpter() 
    {
        m1 = new Mutex();
    }
    // read data from file
    public static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                program_syntax(line);   //running the program sys
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
            if(m1.getOutput()==1){
                m1.setOutput(0);//sem wait
                for(int i = 1; i < arr.length; i++)
                    System.out.print(arr[i] + " ");
                System.out.println();
                m1.setOutput(1);
             }
              break;

            
            case "assign":
             if (m1.getAccess() == 1) {
                
                var[0] = arr[1];
            }
                break;
            
            case "writeFile":
            m1.setAccess(0);    
                writeFile(arr[1], arr[2]);

                break;
            
            case "read":
                readFile(arr[1]);
                break;
            case "printFromTo":
            // convert from String to int
                int from = Integer.parseInt(arr[1]);
                int to = Integer.parseInt(arr[2]);
                for(int i=from; i <= to; i++) {
                    System.out.println(i);
                }
                break;
            case "semWait":
                System.out.println("semwait");
                break;
            case "semSignal":
                System.out.println("semsignal");
                break;
        }
    }
 
}
