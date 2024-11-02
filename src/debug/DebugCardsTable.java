package debug;

import cards.Card;
import cards.Minion;
import dto.MinionDTO;


import java.util.ArrayList;

public class DebugCardsTable {
    private String command;
    private ArrayList<MinionDTO>[] output;
    public DebugCardsTable(String command, ArrayList<Minion>[] output) {
        this.command = command;
        this.output = new ArrayList[4];
        for (int i = 0; i < output.length; i++) {
            this.output[i] = new ArrayList<>();
            for(Minion m : output[i]) {
                this.output[i].add(new MinionDTO(m));
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<MinionDTO>[] getOutput() {
        return output;
    }

    public void setOutput(ArrayList<MinionDTO>[] output) {
        this.output = output;
    }
}
