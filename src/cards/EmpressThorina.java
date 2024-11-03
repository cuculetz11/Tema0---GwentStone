package cards;

import errorAction.ErrorHeroAbility;
import fileio.ActionsInput;
import fileio.CardInput;

import game.Game;
import game.GameTable;
import players.Player;
import utils.ActionsManager;
import utils.CardManager;
import utils.GameConstants;
import utils.JsonOutManager;

import java.util.ArrayList;

public class EmpressThorina extends Hero {
    public EmpressThorina(CardInput input) {
        CardManager.fromInputToObject(this,input);
        this.setHealth(30);
    }
    @Override
    public void useAbility(Game game, ActionsInput action) {
        if(!ActionsManager.isEnemyCard(game.getPlayerIdxTurn(),action.getAffectedRow())) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ROWNOTBELONGTOENEMY,GameConstants.USEHEROABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        Player currPlayer = game.getPlayer()[game.getPlayerIdxTurn()];
        currPlayer.setMana(currPlayer.getMana() - this.getMana());
        this.setWasUsed(true);
        ArrayList<Minion> attackedRow = GameTable.getInstance().getRowFromTable(action.getAffectedRow(),(game.getPlayerIdxTurn() + 1) % 2);
        int maxHealth = 0;
        int Y = -1;
        for(int i = 0 ; i < attackedRow.size() ; i++) {
            Minion m = attackedRow.get(i);
            if(m.getHealth() > maxHealth) {
                maxHealth = m.getHealth();
                Y = i;
            }
        }
        attackedRow.remove(Y);


    }
}
