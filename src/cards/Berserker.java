package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import utils.CardManager;

public class Berserker extends Minion {
    public Berserker(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
    }

    @Override
    public boolean isTank() {
        return false;
    }

    @Override
    public boolean isFront() {
        return false;
    }
}
