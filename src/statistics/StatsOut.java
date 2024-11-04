package statistics;

public class StatsOut {
    private String command;
    private int output;

    public StatsOut(final String command, final int output) {
        this.command = command;
        this.output = output;
    }

    /**
     * Obtine comanda asociata cu iesirea de statistici
     * @return comanda ca un String
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza comanda pentru iesirea de statistici
     * @param command comanda de setat
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine valoarea iesirii de statistici
     * @return iesirea ca un intreg
     */
    public int getOutput() {
        return output;
    }

    /**
     * Seteaza valoarea iesirii de statistici
     * @param output valoarea iesirii de setat
     */
    public void setOutput(final int output) {
        this.output = output;
    }

}
