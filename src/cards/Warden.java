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
    @Override
    public boolean isTank() {
        return true;
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {

    }

    @Override
    public boolean isFront() {
        return true;
    }
}
