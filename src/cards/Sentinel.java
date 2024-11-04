package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import utils.CardManager;

public class Sentinel extends Minion {
    public Sentinel(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {

    }

    /**
     * Ne arata daca cartea este de tipul 'Tank'
     *
     * @return true daca cartea e tank; false altfel
     */
    @Override
    public boolean isTank() {
        return false;
    }

    /**
     * Ne spune daca cartea este pe randul din fata al playerului
     * @return true daca e; false altfel
     */
    @Override
    public boolean isFront() {
        return false;
    }
}
