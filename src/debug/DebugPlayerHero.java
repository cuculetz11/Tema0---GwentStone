package debug;

import cards.Card;
import dto.CardDTO;

public class DebugPlayerHero {
    private String command;
    private int playerIdx;
    private CardDTO output;

    public DebugPlayerHero(final String command, final int playerIdx, final Card output) {
        this.command = command;
        this.playerIdx = playerIdx;
        this.output = new CardDTO(output);
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
     * Obtine cartea reprezentand eroul jucatorului
     *
     * @return cartea eroului
     */
    public CardDTO getOutput() {
        return output;
    }

    /**
     * Seteaza cartea reprezentand eroul jucatorului
     *
     * @param output cartea eroului
     */
    public void setOutput(final CardDTO output) {
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
