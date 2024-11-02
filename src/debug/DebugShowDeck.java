package debug;

import cards.Minion;
import dto.MinionDTO;

import java.util.ArrayList;


public class DebugShowDeck {
    private String command;
    private int playerIdx;
    private ArrayList<MinionDTO> output;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<MinionDTO> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<MinionDTO> output) {
        this.output = output;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public DebugShowDeck(String command, int playerIdx, ArrayList<Minion> output) {
        this.command = command;
        this.playerIdx = playerIdx;
        this.output = new ArrayList<>();
        for (Minion minion : output) {
            if(minion != null)
                this.output.add(new MinionDTO(minion));
        }
    }
}
