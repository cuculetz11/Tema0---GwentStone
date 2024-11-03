package cards;

import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import utils.CardManager;

public class Berserker extends Minion {
    public Berserker(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public void useAbility(Game game, ActionsInput action) {

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
