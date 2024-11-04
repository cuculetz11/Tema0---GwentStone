package debug;

import cards.Minion;
import dto.MinionDTO;
import utils.GameConstants;

import java.util.ArrayList;

public class DebugCardsTable {
    private String command;
    private ArrayList<MinionDTO>[] output;

    public DebugCardsTable(final String command, final ArrayList<Minion>[] output) {
        this.command = command;
        this.output = new ArrayList[GameConstants.MAXROWSIZE];
        for (int i = 0; i < output.length; i++) {
            this.output[i] = new ArrayList<>();
            for (Minion m : output[i]) {
                this.output[i].add(new MinionDTO(m));
            }
        }
    }

    /**
     * Obtine numele comenzii
     * @return
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza numele comenzii
     * @param command
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine lista de vectori de cartii ce se afla pe masa
     * @return
     */
    public ArrayList<MinionDTO>[] getOutput() {
        return output;
    }

    /**
     * Seteaza lista de vectori de carti de pe masa
     * @param output
     */
    public void setOutput(final ArrayList<MinionDTO>[] output) {
        this.output = output;
    }
}
