package action;

import fileio.ActionsInput;
import game.Game;
import game.GamesController;
import statistics.StatsOut;
import utils.GameConstants;
import utils.JsonOutManager;

public class GetPlayerTwoWins implements CommandAction {
    /**
     * Obtine numarul de victorii pentru jucatorul 2 si il adauga la iesirea JSON
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        StatsOut stats = new StatsOut(GameConstants.GET_PLAYER_TWO_WINS,
                GamesController.getInstance().getPlayerTwoScore());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
