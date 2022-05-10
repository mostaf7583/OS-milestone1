public class Mutex {
 private int   file=1; 
 private int   userInput=1;
 private int   userOutput=1;
 private int ownerid ;
 


public int getOwnerid() {
    return ownerid;
}
public void setOwnerid(int ownerid) {
    this.ownerid = ownerid;
}
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
