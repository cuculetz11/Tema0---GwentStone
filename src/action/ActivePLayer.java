package action;

import debug.DebugActivePlayer;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

public class ActivePLayer implements  CommandAction {
    /**
     * Afiseaza jucatorul activ
     *
     * @param game instanta jocului
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        DebugActivePlayer stats = new DebugActivePlayer(GameConstants.GET_PLAYER_TURN,
                (game.getPlayerIdxTurn() + 1));
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
