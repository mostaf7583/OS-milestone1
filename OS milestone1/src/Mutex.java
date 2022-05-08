public class Mutex {
 private int   taking_input=1;//allowing to take
 private int   Access=1;
 private int   output=1;
 public int getAccess() {
     return Access;
 }
 public int getOutput() {
     return output;
 }
 public int getTaking_input() {
     return taking_input;
 }
 public void setAccess(int access) {
     Access = access;
 }
 public void setOutput(int output) {
     this.output = output;
 }
 public void setTaking_input(int taking_input) {
     this.taking_input = taking_input;
 }
 
    }
