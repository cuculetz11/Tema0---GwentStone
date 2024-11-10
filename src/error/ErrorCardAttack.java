package error;

import fileio.Coordinates;

public class ErrorCardAttack extends Error {
    private Coordinates cardAttacker;
    private Coordinates cardAttacked;

    public ErrorCardAttack(final String command, final String error,
                           final Coordinates cardAttacker, final Coordinates cardAttacked) {
        super(error, command);
        this.cardAttacker = cardAttacker;
        this.cardAttacked = cardAttacked;
    }

    /**
     * Obtine coordonatele atacatorului
     * @return coordonatele atacatorului
     */
    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    /**
     * Seteaza coordonatele atacatorului
     * @param cardAttacker seteaza coordonatele atacatorului
     */
    public void setCardAttacker(final Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    /**
     * Obtine coordonatele celui atacat
     * @return coordonatele celui atacat
     */
    public Coordinates getCardAttacked() {
        return cardAttacked;
    }

    /**
     * Seteaza coordonatele celui atacat
     * @param cardAttacked reprezinta coordonatele celui atacat
     */
    public void setCardAttacked(final Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }
}
