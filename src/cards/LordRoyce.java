package cards;

import fileio.CardInput;
import utils.CardManager;

public class LordRoyce extends Hero{
    public LordRoyce(CardInput input) {
        CardManager.tranferFromInput(this,input);
        this.setHealth(30);

    }
    @Override
    public void useAbility() {

    }
}
