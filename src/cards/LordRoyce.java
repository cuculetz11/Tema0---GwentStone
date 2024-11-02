package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;
import utils.CardManager;

public class LordRoyce extends Hero{
    public LordRoyce(CardInput input) {
        CardManager.fromInputToObject(this,input);
        this.setHealth(30);

    }
    @Override
    public void useAbility() {

    }
}
