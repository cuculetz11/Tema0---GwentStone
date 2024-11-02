package cards;

import fileio.CardInput;

import utils.CardManager;

public class EmpressThorina extends Hero {
    public EmpressThorina(CardInput input) {
        CardManager.fromInputToObject(this,input);
        this.setHealth(30);
    }
    @Override
    public void useAbility() {

    }
}
