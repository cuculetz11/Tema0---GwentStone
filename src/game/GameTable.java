package game;

import cards.Minion;

import java.util.ArrayList;

public class GameTable {
    private static GameTable instance;

    private ArrayList<Minion> playerOneBackRow;
    private ArrayList<Minion> playerTwoBackRow;
    private ArrayList<Minion> playerOneFrontRow;
    private ArrayList<Minion> playerTwoFrontRow;

    private GameTable() {
        playerOneBackRow = new ArrayList<>();
        playerTwoBackRow = new ArrayList<>();
        playerOneFrontRow = new ArrayList<>();
        playerTwoFrontRow = new ArrayList<>();
    }
    public static GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }
    public void resetTable() {
        playerOneBackRow = new ArrayList<>();
        playerTwoBackRow = new ArrayList<>();
        playerOneFrontRow = new ArrayList<>();
        playerTwoFrontRow = new ArrayList<>();
    }
}
