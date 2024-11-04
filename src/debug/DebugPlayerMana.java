package debug;

public class DebugPlayerMana {
    private String command;
    private int playerIdx;
    private int output;

    public DebugPlayerMana(final String command, final int playerIdx, final int output) {
        this.command = command;
        this.playerIdx = playerIdx;
        this.output = output;
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
     * Obtine valoarea curenta a manei
     *
     * @return valoarea manei
     */
    public int getOutput() {
        return output;
    }

    /**
     * Seteaza valoarea curenta a manei
     *
     * @param output valoarea manei
     */
    public void setOutput(final int output) {
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
