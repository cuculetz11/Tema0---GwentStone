package cards;

import fileio.CardInput;
import utils.CardManager;

public class Warden extends Minion {
    public Warden() {

    }
    public boolean isTank() {
        return true;
    }
    public Warden(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
}
