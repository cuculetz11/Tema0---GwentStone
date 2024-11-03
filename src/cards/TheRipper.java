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

public class TheRipper extends Minion{
    public boolean isTank() {
        return false;
    }
    public TheRipper(CardInput input) {
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
       attacked.setAttackDamage(attacked.getAttackDamage() - 2);
       if(attacked.getAttackDamage() < 0 ) {
           attacked.setAttackDamage(0);
       }
        this.setWasUsed(true);
    }
    @Override
    public boolean isFront() {
        return true;
    }
}
