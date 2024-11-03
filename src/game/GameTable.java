package game;

import cards.Hero;
import cards.Minion;
import fileio.Coordinates;

import java.util.ArrayList;


public class GameTable {
    private static GameTable instance;

    private ArrayList<Minion>[] playerBackRow  = new ArrayList[2];
    private ArrayList<Minion>[] playerFrontRow = new ArrayList[2];


    public ArrayList<Minion>[] getPlayerFrontRow() {
        return playerFrontRow;
    }

    public void setPlayerFrontRow(ArrayList<Minion>[] playerFrontRow) {
        this.playerFrontRow = playerFrontRow;
    }

    public ArrayList<Minion>[] getPlayerBackRow() {
        return playerBackRow;
    }

    public void setPlayerBackRow(ArrayList<Minion>[] playerBackRow) {
        this.playerBackRow = playerBackRow;
    }
    public void unFreezeRows(int playerIdx) {
        for(Minion m : playerFrontRow[playerIdx]) {
            m.setFrozen(false);
        }
        for(Minion m : playerBackRow[playerIdx]) {
            m.setFrozen(false);
        }
    }
    public void resetUsedCards(Hero p1, Hero p2) {
        for (int i = 0; i < playerBackRow.length; i++) {
            for(Minion m : playerBackRow[i]) {
                m.setWasUsed(false);
            }
            for(Minion m : playerFrontRow[i]) {
                m.setWasUsed(false);
            }
        }
        p1.setWasUsed(false);
        p2.setWasUsed(false);
    }
    public  Minion getCardTable(int X,int Y) {
        if(X == 0) {
            if(Y < playerBackRow[1].size()) {
                return playerBackRow[1].get(Y);
            } else {
                return null;
            }
        }
        if(X == 1) {
            if(Y < playerFrontRow[1].size()) {
                return playerFrontRow[1].get(Y);
            } else {
                return null;
            }
        }
        if(X == 2) {
            if(Y < playerFrontRow[0].size()) {
                return playerFrontRow[0].get(Y);
            } else {
                return null;
            }
        }
        if(X == 3) {
            if(Y < playerBackRow[0].size()) {
                return playerBackRow[0].get(Y);
            } else {
                return null;
            }
        }
        return null;
    }
    public ArrayList<Minion> getRowFromTable(int X,int playerIdx) {
        if(playerIdx == 0) {
            if(X== 3) {
                return playerBackRow[0];
            }
            if(X == 2) {
                return playerFrontRow[0];
            }
        }
        if(playerIdx == 1) {
            if(X == 1) {
                return playerFrontRow[1];
            }
            if(X == 0) {
                return playerBackRow[1];
            }
        }
        return null;
    }

    public boolean isThereATank(int playerIdx) {

       for(Minion m : playerFrontRow[playerIdx]) {
           if(m.isTank()) {
               return true;
           }
       }
        return false;
    }
    private GameTable() {
        playerBackRow[0] = new ArrayList<>();
        playerBackRow[1] = new ArrayList<>();
        playerFrontRow[0] = new ArrayList<>();
        playerFrontRow[1] = new ArrayList<>();
    }
    public static GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }
    public void resetTable() {
        playerBackRow[0] = new ArrayList<>();
        playerBackRow[1] = new ArrayList<>();
        playerFrontRow[0] = new ArrayList<>();
        playerFrontRow[1] = new ArrayList<>();
    }
}
