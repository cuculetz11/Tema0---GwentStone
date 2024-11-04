package debug;

public class DebugCardAtPositionErr {
    private String command;
    private int x;
    private int y;
    private String output;

    public DebugCardAtPositionErr(final String command, final int x, final int y,
                                  final String output) {
        this.command = command;
        this.x = x;
        this.y = y;
        this.output = output;
    }

    /**
     * Obtine comanda asociata
     *
     * @return comanda
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza comanda asociata debug-ului
     *
     * @param command noua comanda
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * Obtine mesajul de debug
     *
     * @return mesajul de debug
     */
    public String getOutput() {
        return output;
    }

    /**
     * Seteaza mesajul de debug
     *
     * @param output noul mesaj de debug
     */
    public void setOutput(final String output) {
        this.output = output;
    }

    /**
     * Obtine coordonata y a pozitiei cardului
     *
     * @return coordonata y
     */
    public int getY() {
        return y;
    }

    /**
     * Seteaza coordonata y a pozitiei cardului
     *
     * @param y noua coordonata y
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Obtine coordonata x a pozitiei cardului
     *
     * @return coordonata x
     */
    public int getX() {
        return x;
    }

    /**
     * Seteaza coordonata x a pozitiei cardului
     *
     * @param x noua coordonata x
     */
    public void setX(final int x) {
        this.x = x;
    }
}
