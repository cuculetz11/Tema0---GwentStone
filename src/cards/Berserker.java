package cards;

import fileio.CardInput;
import utils.CardManager;

public class Berserker extends Minion {
    public Berserker(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public void useAbility() {

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
