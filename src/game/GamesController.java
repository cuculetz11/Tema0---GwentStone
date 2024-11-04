package game;

import fileio.GameInput;
import fileio.Input;


public final class GamesController {
    private static GamesController instance;
    private int numberGames;
    private int playerOneScore;
    private int playerTwoScore;

    private GamesController() {
    }

    /**
     * Obtine instanta Singleton a GameController-ului
     * @return instanta GameController
     */
    public static GamesController getInstance() {
        if (instance == null) {
            instance = new GamesController();
        }
        return instance;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getNumberGames() {
        return numberGames;
    }

    /**
     * Incrementeaza scorul primului jucator
     */
    public void incrementPlayerOneScore() {
        playerOneScore++;
    }

    /**
     * Incrementeaza scorul celui de-al 2 lea jucator
     */
    public void incrementPlayerTwoScore() {
        playerTwoScore++;
    }

    /**
     * Da drumul la jocuri
     * @param input tot inputul programului
     */
    public void startGames(final Input input) {
        numberGames = 0;
        playerOneScore = 0;
        playerTwoScore = 0;
        for (GameInput game : input.getGames()) {
            GameTable.getInstance().resetTable();
            numberGames++;
            Game g = new Game(game, input.getPlayerOneDecks(), input.getPlayerTwoDecks());
        }
    }
}
