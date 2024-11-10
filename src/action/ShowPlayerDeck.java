package action;

import debug.DebugShowDeck;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

public class ShowPlayerDeck implements CommandAction {
    /**
     * Afiseaza pachetul de carti al jucatorului specificat
     *
     * @param game instanta jocului
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        int playerIdx = action.getPlayerIdx();
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GET_PLAYER_DECK, playerIdx,
                game.getPlayer()[playerIdx - 1].getDeck().getCards());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
