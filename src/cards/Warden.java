package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;
import utils.CardManager;

public class Warden extends Minion {
    public Warden() {

    }
    public boolean isTank() {
        return true;
    }
    public Warden(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
    @Override
    public boolean isFront() {
        return true;
    }
}
