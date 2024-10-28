package cards;

import fileio.CardInput;
import utils.CardManager;

public class KingMudface extends Hero{
    public KingMudface(CardInput input) {
        CardManager.tranferFromInput(this, input);
        this.setHealth(30);
    }
    @Override
    public void useAbility() {

    }
}
