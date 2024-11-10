package game;

import cards.Hero;
import cards.Minion;
import utils.GameConstants;

import java.util.ArrayList;

/**
 * Clasa GameTable este un singleton ce reprezinta masa de joc pe tot parcursul aplicatiei
 * Am facut o singleton deoarece am vrut sa am acces la ea de oriunde si pe intreaga durata a
 * aplicatiei
 */
public final class GameTable {
    private static GameTable instance;

    private ArrayList<Minion>[] playerBackRow = new ArrayList[2];
    private ArrayList<Minion>[] playerFrontRow = new ArrayList[2];


    private GameTable() {
        playerBackRow[0] = new ArrayList<>();
        playerBackRow[1] = new ArrayList<>();
        playerFrontRow[0] = new ArrayList<>();
        playerFrontRow[1] = new ArrayList<>();
    }
    /**
     * Obtine instanta singleton a GameTable
     * @return instanta GameTable
     */
    public static GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }

    public ArrayList<Minion>[] getPlayerFrontRow() {
        return playerFrontRow;
    }

    public ArrayList<Minion>[] getPlayerBackRow() {
        return playerBackRow;
    }
    /**
     * Dezgheata toate cartile din randurile unui jucator
     * @param playerIdx indexul jucatorului
     */
    public void unFreezeRows(final int playerIdx) {
        for (Minion m : playerFrontRow[playerIdx]) {
            m.setFrozen(false);
        }
        for (Minion m : playerBackRow[playerIdx]) {
            m.setFrozen(false);
        }
    }
    /**
     * Reseteaza starea cartilor utilizate pentru ambii jucatori
     * @param p1 eroul jucatorului 1
     * @param p2 eroul jucatorului 2
     */
    public void resetUsedCards(final Hero p1, final Hero p2) {
        for (int i = 0; i < playerBackRow.length; i++) {
            for (Minion m : playerBackRow[i]) {
                m.setWasUsed(false);
            }
            for (Minion m : playerFrontRow[i]) {
                m.setWasUsed(false);
            }
        }
        p1.setWasUsed(false);
        p2.setWasUsed(false);
    }
    /**
     * Obtine cartea de la o anumita pozitie in tabela de joc
     * @param x coordonata x
     * @param y coordonata y
     * @return cartea de la pozitia specificata sau null daca pozitia nu exista
     */
    public Minion getCardTable(final int x, final int y) {
        if (x == 0) {
            if (y < playerBackRow[1].size()) {
                return playerBackRow[1].get(y);
            } else {
                return null;
            }
        }
        if (x == 1) {
            if (y < playerFrontRow[1].size()) {
                return playerFrontRow[1].get(y);
            } else {
                return null;
            }
        }
        if (x == 2) {
            if (y < playerFrontRow[0].size()) {
                return playerFrontRow[0].get(y);
            } else {
                return null;
            }
        }
        if (x == GameConstants.LAST_ROW) {
            if (y < playerBackRow[0].size()) {
                return playerBackRow[0].get(y);
            } else {
                return null;
            }
        }
        return null;
    }
    /**
     * Obtine randul de carti al unui jucator de la o pozitie specificata
     * @param x coordonata randului
     * @param playerIdx indexul jucatorului
     * @return lista de carti de pe randul specificat sau null daca nu exista
     */
    public ArrayList<Minion> getRowFromTable(final int x, final int playerIdx) {
        if (playerIdx == 0) {
            if (x == GameConstants.LAST_ROW) {
                return playerBackRow[0];
            }
            if (x == 2) {
                return playerFrontRow[0];
            }
        }
        if (playerIdx == 1) {
            if (x == 1) {
                return playerFrontRow[1];
            }
            if (x == 0) {
                return playerBackRow[1];
            }
        }
        return null;
    }
    /**
     * Verifica daca un jucator are un tank pe randul din fata
     * @param playerIdx indexul jucatorului
     * @return true daca exista un tank, false altfel
     */
    public boolean isThereATank(final int playerIdx) {

        for (Minion m : playerFrontRow[playerIdx]) {
            if (m.isTank()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Reseteaza tabela de joc, stergand toate cartile
     */
    public void resetTable() {
        playerBackRow[0] = new ArrayList<>();
        playerBackRow[1] = new ArrayList<>();
        playerFrontRow[0] = new ArrayList<>();
        playerFrontRow[1] = new ArrayList<>();
    }
}
