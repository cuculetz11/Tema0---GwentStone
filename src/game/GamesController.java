package game;

import fileio.GameInput;
import fileio.Input;

public class GamesController {
    private int numberGames;
    private int PlayerOneScore;
    private int PlayerTwoScore;


    public void startGames(Input input) {
        numberGames = 0;
        for(GameInput game: input.getGames()) {
            Game g = new Game(game,input.getPlayerOneDecks(),input.getPlayerTwoDecks());
            numberGames++;
        }
    }
}
