package cards;

import fileio.CardInput;

import utils.CardManager;

public class GeneralKocioraw extends Hero {
    public GeneralKocioraw(CardInput input) {
        CardManager.fromInputToObject(this,input);
        this.setHealth(30);
    }
    @Override
    public void useAbility() {

    }
}
