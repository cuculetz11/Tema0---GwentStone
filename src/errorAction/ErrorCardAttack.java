package errorAction;

import fileio.Coordinates;

public class ErrorCardAttack extends Error{
    private Coordinates cardAttacker;
    private Coordinates cardAttacked;

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    public Coordinates getCardAttacked() {
        return cardAttacked;
    }

    public void setCardAttacked(Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }
    public ErrorCardAttack(String command, String error, Coordinates cardAttacker, Coordinates cardAttacked) {
        super(error, command);
        this.cardAttacker = cardAttacker;
        this.cardAttacked = cardAttacked;
    }
}
