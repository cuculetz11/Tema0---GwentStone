package cards;

import errorAction.ErrorAttackHero;
import errorAction.ErrorCardAttack;
import errorAction.ErrorHeroAbility;
import fileio.ActionsInput;
import fileio.CardInput;

import game.Game;
import game.GameTable;
import utils.ActionsManager;
import utils.CardManager;
import utils.GameConstants;
import utils.JsonOutManager;

public class Miraj extends Minion{
    public Miraj(CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }
    @Override
    public void useAbility(Game game, ActionsInput action) {
        if(!ActionsManager.isEnemyCard(game.getPlayerIdxTurn(), action.getCardAttacked().getX())) {
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
        this.setWasUsed(true);
        int temp = this.getHealth();
        this.setHealth(attacked.getHealth());
        attacked.setHealth(temp);
    }
    @Override
    public boolean isTank() {
        return false;
    }

    @Override
    public boolean isFront() {
        return true;
    }
}
