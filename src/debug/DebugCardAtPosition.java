package debug;

import cards.Minion;
import dto.MinionDTO;


public class DebugCardAtPosition {
    private String command;
    private int x;
    private int y;
    private MinionDTO output;

    public DebugCardAtPosition(final String command, final int x, final int y,
                               final Minion output) {
        this.command = command;
        this.x = x;
        this.y = y;
        this.output = new MinionDTO(output);
    }

    /**
     * Obtine comanda
     *
     * @return comanda ca un string
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
     * Obtine cartea de la pozitia data
     *
     * @return iesirea ca un obiect MinionDTO
     */
    public MinionDTO getOutput() {
        return output;
    }

    /**
     * Seteaza cartea
     *
     * @param output iesirea de setat
     */
    public void setOutput(final MinionDTO output) {
        this.output = output;
    }

    /**
     * Obtine coordonata y a pozitiei
     *
     * @return coordonata y ca un int
     */
    public int getY() {
        return y;
    }

    /**
     * Seteaza coordonata y a pozitiei
     *
     * @param y coordonata y de setat
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Obtine coordonata x a pozitiei
     *
     * @return coordonata x ca un int
     */
    public int getX() {
        return x;
    }

    /**
     * Seteaza coordonata x a pozitiei
     *
     * @param x coordonata x de setat
     */
    public void setX(final int x) {
        this.x = x;
    }
}
