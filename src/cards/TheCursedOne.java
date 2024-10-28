package cards;

import fileio.CardInput;
import utils.CardManager;

public class TheCursedOne extends Minion{
    public boolean isTank() {
        return false;
    }
    public TheCursedOne(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
}
