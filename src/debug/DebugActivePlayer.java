package debug;

public class DebugActivePlayer {
    private String command;
    private int output;

    public DebugActivePlayer(final String command, final int output) {
        this.command = command;
        this.output = output;
    }

    /**
     * Obtine comanda
     *
     * @return comanda ca un string.
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza comanda
     *
     * @param command comanda de setat
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine playerul ce inca e in tura lui
     *
     * @return iesirea ca un int
     */
    public int getOutput() {
        return output;
    }

    /**
     * Seteaza iesirea asociata cu comanda
     *
     * @param output iesirea de setat
     *
     */
    public void setOutput(final int output) {
        this.output = output;
    }
}
