package errorAction;

import fileio.Coordinates;

public class ErrorAttackHero extends Error{
    private Coordinates cardAttacker;

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    public ErrorAttackHero(String error, String command, Coordinates cardAttacker) {
        super(error, command);
        this.cardAttacker = cardAttacker;
    }
}
