public class proccess {
    private int pid;
    private state process_State;
    private int no_of_instructions;
    private int PC;
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getNo_of_instructions() {
        return no_of_instructions;
    }
    public void setNo_of_instructions(int no_of_instructions) {
        this.no_of_instructions = no_of_instructions;
    }
    public state getProcess_State() {
        return process_State;
    }
    public void setProcess_State(state process_State) {
        this.process_State = process_State;
    }
    public int getPC() {
        return PC;
    }

    
}
