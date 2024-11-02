package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;
import utils.CardManager;

public class TheCursedOne extends Minion{
    public boolean isTank() {
        return false;
    }
    public TheCursedOne(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility() {

    }
    @Override
    public boolean isFront() {
        return false;
    }
}
