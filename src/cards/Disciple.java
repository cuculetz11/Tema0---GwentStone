package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import utils.CardManager;


public class Disciple extends Minion {
    public Disciple(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
        if (error.handleCardAbilityEnemyCheck(game.getPlayerIdxTurn(), action)) {
            return;
        }
        Minion attacked = GameTable.getInstance().getCardTable(action.getCardAttacked().getX(),
                action.getCardAttacked().getY());
        attacked.setHealth(attacked.getHealth() + 2);
        this.setWasUsed(true);
    }

    @Override
    public boolean isTank() {
        return false;
    }

    @Override
    public boolean isFront() {
        return false;
    }
}
