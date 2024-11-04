package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import utils.CardManager;

public class TheCursedOne extends Minion {
    /**
     *
     * @param input
     */
    public TheCursedOne(final CardInput input) {
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
        int temp = attacked.getHealth();
        attacked.setHealth(attacked.getAttackDamage());
        attacked.setAttackDamage(temp);
        this.setWasUsed(true);
        if (attacked.getHealth() <= 0) {
            GameTable.getInstance().getRowFromTable(game.getPlayerIdxTurn(),
                    action.getCardAttacked().getX()).remove(action.getCardAttacked().getY());
        }
    }

    @Override
    public boolean isFront() {
        return false;
    }
}
