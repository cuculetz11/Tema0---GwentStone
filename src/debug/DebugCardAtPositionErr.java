package debug;

import cards.Minion;

public class DebugCardAtPositionErr {
    private String command;
    private int x;
    private int y;
    private String output;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
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

    public DebugCardAtPositionErr(String command, int x, int y, String output) {
        this.command = command;
        this.x = x;
        this.y = y;
        this.output = output;
    }
}
