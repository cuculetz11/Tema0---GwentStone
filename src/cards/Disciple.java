package cards;

import errorAction.ErrorCardAttack;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import utils.ActionsManager;
import utils.CardManager;
import utils.GameConstants;
import utils.JsonOutManager;


public class Disciple extends Minion{
    public Disciple(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility(Game game, ActionsInput action) {
        if(ActionsManager.isEnemyCard(game.getPlayerIdxTurn(), action.getCardAttacked().getX())) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESABILITY,GameConstants.NOTBELONGTOCURRENT,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        Minion attacked = GameTable.getInstance().getCardTable(action.getCardAttacked().getX(),action.getCardAttacked().getY());
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
