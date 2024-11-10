package debug;

import cards.Minion;
import dto.MinionDTO;

import java.util.ArrayList;

public class DebugFrozenCards {
    private String command;
    private ArrayList<MinionDTO> output;

    public DebugFrozenCards(final String command, final ArrayList<Minion> output) {
        this.command = command;
        this.output = new ArrayList<>();
        for (Minion minion : output) {
            this.output.add(new MinionDTO(minion));
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
     * @param command numele comenzii
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine lista de carti inghetate
     * @return cartile inghetate
     */
    public ArrayList<MinionDTO> getOutput() {
        return output;
    }

    /**
     * Seteaza lista de carti inghetate
     * @param output reprezinta cartile inghetate
     */
    public void setOutput(final ArrayList<MinionDTO> output) {
        this.output = output;
    }
}
