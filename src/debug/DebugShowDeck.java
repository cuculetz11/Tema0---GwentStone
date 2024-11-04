package debug;

import cards.Minion;
import dto.MinionDTO;

import java.util.ArrayList;


public class DebugShowDeck {
    private String command;
    private int playerIdx;
    private ArrayList<MinionDTO> output;

    public DebugShowDeck(final String command, final int playerIdx,
                         final ArrayList<Minion> output) {
        this.command = command;
        this.playerIdx = playerIdx;
        this.output = new ArrayList<>();
        for (Minion minion : output) {
            if (minion != null) {
                this.output.add(new MinionDTO(minion));
            }
        }
    }
    /**
     * Obtine comanda
     *
     * @return comanda
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza comanda
     *
     * @param command comanda
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine lista de MinionDTO
     *
     * @return lista de MinionDTO
     */
    public ArrayList<MinionDTO> getOutput() {
        return output;
    }

    /**
     * Seteaza lista de MinionDTO
     *
     * @param output lista de MinionDTO
     */
    public void setOutput(final ArrayList<MinionDTO> output) {
        this.output = output;
    }

    /**
     * Obtine indexul jucatorului
     *
     * @return indexul jucatorului
     */
    public int getPlayerIdx() {
        return playerIdx;
    }

    /**
     * Seteaza indexul jucatorului
     *
     * @param playerIdx indexul jucatorului
     */
    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }
}
