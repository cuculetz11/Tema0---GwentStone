package error;

import fileio.Coordinates;

public class ErrorAttackHero extends Error {
    private Coordinates cardAttacker;

    public ErrorAttackHero(final String error, final String command,
                           final Coordinates cardAttacker) {
        super(error, command);
        this.cardAttacker = cardAttacker;
    }

    /**
     * Obtine coordonatele atacatorului
     * @return
     */
    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    /**
     * Seteaza coordonatele atacatorului
     * @param cardAttacker
     */
    public void setCardAttacker(final Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }
}
