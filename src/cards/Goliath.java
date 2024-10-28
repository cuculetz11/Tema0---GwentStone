package cards;

import fileio.CardInput;
import utils.CardManager;

public class Goliath extends Minion {
    public boolean isTank() {
        return true;
    }
    public Goliath(CardInput input) {
        CardManager.tranferFromInput(this, input);
    }
    @Override
    public void useAbility() {

    }

}
