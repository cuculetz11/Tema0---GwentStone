package action;

import debug.DebugShowDeck;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

public class ShowPlayerHand implements CommandAction {
    /**
     * Afiseaza cartile din mana jucatorului specificat
     *
     * @param game instanta jocului
     * @param action actiunea data
     */
    public void execute(final Game game, final ActionsInput action) {
        int playerIdx = action.getPlayerIdx();
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GET_CARDS_INHAND, playerIdx,
                game.getPlayer()[playerIdx - 1].getHand());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
