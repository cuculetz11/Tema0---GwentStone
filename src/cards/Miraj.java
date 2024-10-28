package cards;

import fileio.CardInput;
import utils.CardManager;

public class Miraj extends Minion{
    public boolean isTank() {
        return false;
    }
    public Miraj(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public void useAbility() {

    }
}
