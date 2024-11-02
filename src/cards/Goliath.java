package cards;

import fileio.ActionsInput;
import fileio.CardInput;
import utils.CardManager;

public class Goliath extends Minion {

    public Goliath(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public void useAbility(int playerIdx, ActionsInput action) {

    }
    @Override
    public boolean isTank() {
        return true;
    }
    @Override
    public boolean isFront() {
        return true;
    }

}
