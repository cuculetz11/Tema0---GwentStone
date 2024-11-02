package debug;

import lombok.Getter;
import lombok.Setter;


public class DebugActivePlayer {
    private String command;
    private int output;
    public DebugActivePlayer(String command, int output) {
        this.command = command;
        this.output = output;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
