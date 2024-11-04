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

public class LordRoyce extends Hero {
    public LordRoyce(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setHealth(GameConstants.MAXHEALTHHERO);

    }

    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
        if (error.handleSelfAbilityHero(action, game.getPlayerIdxTurn())) {
            return;
        }
        Player currPlayer = game.getPlayer()[game.getPlayerIdxTurn()];
        currPlayer.setMana(currPlayer.getMana() - this.getMana());
        this.setWasUsed(true);
        ArrayList<Minion> attackedRow = GameTable.getInstance().getRowFromTable(
                action.getAffectedRow(), (game.getPlayerIdxTurn() + 1) % 2);
        for (Minion m : attackedRow) {
            m.setFrozen(true);
        }
    }
}
