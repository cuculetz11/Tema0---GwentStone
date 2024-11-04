package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import utils.CardManager;

public class TheRipper extends Minion {
    /**
     *
     * @param input
     */
    public TheRipper(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public boolean isTank() {
        return false;
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
        Minion attacked = GameTable.getInstance().getCardTable(action.getCardAttacked().getX(),
                action.getCardAttacked().getY());
        if (error.handleCardAbilityTankSelf(action, game.getPlayerIdxTurn(), attacked)) {
            return;
        }
        attacked.setAttackDamage(attacked.getAttackDamage() - 2);
        if (attacked.getAttackDamage() < 0) {
            attacked.setAttackDamage(0);
        }
        this.setWasUsed(true);
    }

    @Override
    public boolean isFront() {
        return true;
    }
}
