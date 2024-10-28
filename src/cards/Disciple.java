package cards;

import fileio.CardInput;
import utils.CardManager;

public class Disciple extends Minion{
    public boolean isTank() {
        return false;
    }
    public Disciple(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
}
