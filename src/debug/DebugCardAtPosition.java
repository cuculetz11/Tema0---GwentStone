package debug;

import cards.Minion;
import dto.MinionDTO;

public class DebugCardAtPosition {
    private String command;
    private int x;
    private int y;
    private MinionDTO output;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public MinionDTO getOutput() {
        return output;
    }

    public void setOutput(MinionDTO output) {
        this.output = output;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public DebugCardAtPosition(String command, int x, int y, Minion output) {
        this.command = command;
        this.x = x;
        this.y = y;
        this.output = new MinionDTO(output);
    }
}
