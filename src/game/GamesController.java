package game;

import fileio.GameInput;
import fileio.Input;
import utils.GameConstants;


public class GamesController {
    private static GamesController instance;
    private int numberGames;
    private int PlayerOneScore;
    private int PlayerTwoScore;

    public int getPlayerTwoScore() {
        return PlayerTwoScore;
    }

    public int getPlayerOneScore() {
        return PlayerOneScore;
    }

    public int getNumberGames() {
        return numberGames;
    }
    public void incrementPlayerOneScore() {
        PlayerOneScore++;
    }
    public void incrementPlayerTwoScore() {
        PlayerTwoScore++;
    }
    public void startGames(Input input) {
        numberGames = 0;
        PlayerOneScore = 0;
        PlayerTwoScore = 0;
        for(GameInput game : input.getGames()) {
            GameTable.getInstance().resetTable();
            numberGames++;
            Game g = new Game(game,input.getPlayerOneDecks(),input.getPlayerTwoDecks());
        }
    }
    private GamesController() {
    }
    public static GamesController getInstance() {
        if(instance == null) {
            instance = new GamesController();
        }
        return instance;
    }
}
