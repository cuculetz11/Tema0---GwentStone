package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import utils.CardManager;

public class Warden extends Minion {
    public Warden() {

    }

    public Warden(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    /**
     * Ne arata daca cartea este de tipul 'Tank'
     *
     * @return true daca cartea e tank; false altfel
     */
    @Override
    public boolean isTank() {
        return true;
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {

    }
    /**
     * Ne spune daca cartea este pe randul din fata al playerului
     * @return true daca e; false altfel
     */
    @Override
    public boolean isFront() {
        return true;
    }
}
