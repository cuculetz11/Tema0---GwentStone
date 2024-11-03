package cards;

import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
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
    public void useAbility(Game game, ActionsInput action){

    }
    @Override
    public boolean isFront() {
        return true;
    }
}
