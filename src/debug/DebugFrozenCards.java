package debug;

import cards.Minion;
import dto.MinionDTO;

import java.util.ArrayList;

public class DebugFrozenCards {
    private String command;
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

    public DebugFrozenCards(String command, ArrayList<Minion> output) {
        this.command = command;
        this.output = new ArrayList<>();
        for (Minion minion : output) {
            this.output.add(new MinionDTO(minion));
        }
    }
}
