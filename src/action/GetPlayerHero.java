package action;

import debug.DebugPlayerHero;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

public class GetPlayerHero implements  CommandAction {
    /**
     * Afiseaza eroul jucatorului specificat
     *
     * @param game instanta jocului
     * @param action actiunea data
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        int playerIdx = action.getPlayerIdx();
        DebugPlayerHero stats = new DebugPlayerHero(GameConstants.GET_PLAYER_HERO,
                playerIdx, game.getPlayer()[playerIdx - 1].getHero());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
