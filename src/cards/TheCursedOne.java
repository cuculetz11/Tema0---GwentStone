package cards;

import errorAction.ErrorAttackHero;
import errorAction.ErrorCardAttack;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import lombok.Getter;
import lombok.Setter;
import utils.ActionsManager;
import utils.CardManager;
import utils.GameConstants;
import utils.JsonOutManager;

public class TheCursedOne extends Minion{
    public boolean isTank() {
        return false;
    }
    public TheCursedOne(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    @Override
    public void useAbility(Game game, ActionsInput action) {
        if(!ActionsManager.isEnemyCard(game.getPlayerIdxTurn(),action.getCardAttacked().getX())) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESABILITY,GameConstants.NOTBELONGTOENEMY,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        Minion attacked = GameTable.getInstance().getCardTable(action.getCardAttacked().getX(),action.getCardAttacked().getY());
        if(!attacked.isTank() && GameTable.getInstance().isThereATank((game.getPlayerIdxTurn() + 1) % 2 )) {
            ErrorCardAttack err = new ErrorCardAttack(GameConstants.CARDUSESABILITY,GameConstants.NOTTANK,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
       int temp = attacked.getHealth();
       attacked.setHealth(attacked.getAttackDamage());
       attacked.setAttackDamage(temp);
       this.setWasUsed(true);
       if(attacked.getHealth() <= 0 ) {
           GameTable.getInstance().getRowFromTable(game.getPlayerIdxTurn(), action.getCardAttacked().getX()).remove(action.getCardAttacked().getY());
       }
    }
    @Override
    public boolean isFront() {
        return false;
    }
}
