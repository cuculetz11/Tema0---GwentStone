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
     *
     * @return
     */
    @Override
    public boolean isTank() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFront() {
        return false;
    }
}
