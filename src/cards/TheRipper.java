package cards;

import fileio.CardInput;
import utils.CardManager;

public class TheRipper extends Minion{
    public boolean isTank() {
        return false;
    }
    public TheRipper(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
}
