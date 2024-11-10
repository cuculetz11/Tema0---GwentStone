package action;

import debug.DebugPlayerMana;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

public class GetPlayerMana implements  CommandAction {
    /**
     * Afiseaza mana playerului selectat
     * @param game instanta jocului
     * @param action actiunea data
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        int playerIdx = action.getPlayerIdx();
        DebugPlayerMana stats = new DebugPlayerMana(GameConstants.GET_PLAYER_MANA, playerIdx,
                game.getPlayer()[playerIdx - 1].getMana());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
