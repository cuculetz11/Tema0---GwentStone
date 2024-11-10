package action;

import fileio.ActionsInput;
import game.Game;
import game.GamesController;
import statistics.StatsOut;
import utils.GameConstants;
import utils.JsonOutManager;

public class GetTotalGamesPlayed implements CommandAction {
    /**
     * Obtine numarul total de jocuri jucate si il adauga la iesirea JSON
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        StatsOut stats = new StatsOut(GameConstants.GET_TOTAL_GAMES_PLAYED,
                GamesController.getInstance().getNumberGames());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
