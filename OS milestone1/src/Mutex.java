public class Mutex {
 private int   file=1;//allowing to take
 private int   userInput=1;
 private int   userOutput=1;
 
public int getUserInput() {
    return userInput;
}
public int getFile() {
    return file;
}
public int getUserOutput() {
    return userOutput;
}
public void setFile(int file) {
    this.file = file;
}
public void setUserInput(int userInput) {
    this.userInput = userInput;
}
public void setUserOutput(int userOutput) {
    this.userOutput = userOutput;
}

    }
