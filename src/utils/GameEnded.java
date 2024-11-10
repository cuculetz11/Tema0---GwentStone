package utils;

public class GameEnded {
    private String gameEnded;

    public GameEnded(final String gameEnded) {
        this.gameEnded = gameEnded;
    }

    /**
     * Obtine rezultatul jocului
     * @return returneza un string in care ne spune playerul ce a castigat
     */
    public String getGameEnded() {
        return gameEnded;
    }

    /**
     * Seteaza rezultatul jocului
     * @param gameEnded rezultatul jocului
     */
    public void setGameEnded(final String gameEnded) {
        this.gameEnded = gameEnded;
    }
}
