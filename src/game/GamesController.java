package game;

import fileio.GameInput;
import fileio.Input;


public class GamesController {
    private int numberGames;
    private static int PlayerOneScore;
    private static int PlayerTwoScore;

    public static void incrementPlayerOneScore() {
        PlayerOneScore++;
    }
    public static void incrementPlayerTwoScore() {
        PlayerTwoScore++;
    }

    public void startGames(Input input) {
        numberGames = 0;
        GamesController.PlayerOneScore = 0;
        GamesController.PlayerTwoScore = 0;
        for(GameInput game : input.getGames()) {
            GameTable.getInstance().resetTable();
            Game g = new Game(game,input.getPlayerOneDecks(),input.getPlayerTwoDecks());
            numberGames++;
        }
    }
}
