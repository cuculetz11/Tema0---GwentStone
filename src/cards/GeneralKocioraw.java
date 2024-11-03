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

public class GeneralKocioraw extends Hero {
    public GeneralKocioraw(CardInput input) {
        CardManager.fromInputToObject(this,input);
        this.setHealth(30);
    }
    @Override
    public void useAbility(Game game, ActionsInput action) {
        if(ActionsManager.isEnemyCard(game.getPlayerIdxTurn(),action.getAffectedRow())) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ROWNOTBELONGTOCURRENT,GameConstants.USEHEROABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        Player currPlayer = game.getPlayer()[game.getPlayerIdxTurn()];
        currPlayer.setMana(currPlayer.getMana() - this.getMana());
        this.setWasUsed(true);
        ArrayList<Minion> affectedRow = GameTable.getInstance().getRowFromTable(action.getAffectedRow(), game.getPlayerIdxTurn());
        for(Minion m : affectedRow) {
            m.setAttackDamage(m.getAttackDamage() + 1);
        }

    }
}
