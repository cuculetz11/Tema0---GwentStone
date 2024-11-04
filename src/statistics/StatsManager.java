package statistics;

import game.GamesController;
import utils.GameConstants;
import utils.JsonOutManager;

public class StatsManager {
    /**
     * Obtine numarul total de jocuri jucate si il adauga la iesirea JSON
     */
    public void getTotalGamesPlayed() {
        StatsOut stats = new StatsOut(GameConstants.GETTOTALGAMESPLAYED,
                GamesController.getInstance().getNumberGames());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    /**
     * Obtine numarul de victorii pentru jucatorul 1 si il adauga la iesirea JSON
     */
    public void getPlayerOneWins() {
        StatsOut stats = new StatsOut(GameConstants.GETPLAYERONEWINS,
                GamesController.getInstance().getPlayerOneScore());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    /**
     * Obtine numarul de victorii pentru jucatorul 2 si il adauga la iesirea JSON
     */
    public void getPlayerTwoWins() {
        StatsOut stats = new StatsOut(GameConstants.GETPLAYERTWOWINS,
                GamesController.getInstance().getPlayerTwoScore());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
