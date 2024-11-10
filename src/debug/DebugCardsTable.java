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
        this.output = new ArrayList[GameConstants.MAX_ROW_SIZE];
        for (int i = 0; i < output.length; i++) {
            this.output[i] = new ArrayList<>();
            for (Minion m : output[i]) {
                this.output[i].add(new MinionDTO(m));
            }
        }
    }

    /**
     * Obtine numele comenzii
     * @return numele comenzii
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza numele comenzii
     * @param command este numele coemzii
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine lista de vectori de cartii ce se afla pe masa
     * @return setul de minioni de pe masa
     */
    public ArrayList<MinionDTO>[] getOutput() {
        return output;
    }

    /**
     * Seteaza lista de vectori de carti de pe masa
     * @param output reprezinta minionii de pe masa
     */
    public void setOutput(final ArrayList<MinionDTO>[] output) {
        this.output = output;
    }
}
