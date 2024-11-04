package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import players.Player;
import utils.CardManager;
import utils.GameConstants;

import java.util.ArrayList;

public class KingMudface extends Hero {
    /**
     * Constructor pentu acest tip de rege
     * @param input cartea input ce e exxact acest rege
     */
    public KingMudface(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setHealth(GameConstants.MAXHEALTHHERO);
    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
       if (error.handleAbilityHeroEnemyCheck(action, game.getPlayerIdxTurn())) {
           return;
       }
        Player currPlayer = game.getPlayer()[game.getPlayerIdxTurn()];
        currPlayer.setMana(currPlayer.getMana() - this.getMana());
        this.setWasUsed(true);
        ArrayList<Minion> affectedRow = GameTable.getInstance().getRowFromTable(
                action.getAffectedRow(), game.getPlayerIdxTurn());
        for (Minion m : affectedRow) {
            m.setHealth(m.getHealth() + 1);
        }

    }
}
