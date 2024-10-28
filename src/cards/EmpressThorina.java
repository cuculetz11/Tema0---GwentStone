package cards;

import fileio.CardInput;
import utils.CardManager;

public class EmpressThorina extends Hero {
    public EmpressThorina(CardInput input) {
        CardManager.tranferFromInput(this,input);
    }
    @Override
    public void useAbility() {

    }
}
