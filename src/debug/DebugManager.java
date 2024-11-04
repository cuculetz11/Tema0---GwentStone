package debug;

import cards.Minion;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;
import utils.GameConstants;
import utils.JsonOutManager;

import java.util.ArrayList;

public class DebugManager {
    private ArrayList<Minion>[] getAllMinionRows() {
        ArrayList<Minion>[] playerBackRow = GameTable.getInstance().getPlayerBackRow();
        ArrayList<Minion>[] playerFrontRow = GameTable.getInstance().getPlayerFrontRow();

        ArrayList<Minion>[] allTable = new ArrayList[GameConstants.MAXROWSIZE];
        allTable[0] = playerBackRow[1];
        allTable[1] = playerFrontRow[1];
        allTable[2] = playerFrontRow[0];
        allTable[GameConstants.LASTROW] = playerBackRow[0];

        return allTable;
    }
    /**
     * Afiseaza cartea la o pozitie specificata
     *
     * @param action actiunea care contine coordonatele cartii
     */
    public void getPlayerAtPosition(final ActionsInput action) {
        int x = action.getX();
        int y = action.getY();
        Minion card = GameTable.getInstance().getCardTable(x, y);
        if (card == null) {
            DebugCardAtPositionErr stats = new DebugCardAtPositionErr(
                    GameConstants.GETCARDATPOSITION, x, y, GameConstants.NOCARDATPOS);
            JsonOutManager.getInstance().addToOutput(stats);
        } else {
            DebugCardAtPosition stats = new DebugCardAtPosition(
                    GameConstants.GETCARDATPOSITION, x, y, card);
            JsonOutManager.getInstance().addToOutput(stats);
        }
    }

    /**
     * Afiseaza cartile de pe masa
     */
    public void showCardsTable() {
        ArrayList<Minion>[] allTable = getAllMinionRows();
        DebugCardsTable stats = new DebugCardsTable(GameConstants.GETCARDSONTABLE, allTable);
        JsonOutManager.getInstance().addToOutput(stats);
    }

    /**
     * Afiseaza cartile ce sunt inghetate
     */
    public void getFrozenCards() {
        ArrayList<Minion> frozenMinions = new ArrayList<>();
        ArrayList<Minion>[] allTable = getAllMinionRows();
        for (int i = 0; i <= GameConstants.LASTROW; i++) {
            for (Minion minion : allTable[i]) {
                if (minion.isFrozen()) {
                    frozenMinions.add(minion);
                }
            }
        }
        DebugFrozenCards stats = new DebugFrozenCards(GameConstants.GETFROZENCARDSONTABLE,
                frozenMinions);
        JsonOutManager.getInstance().addToOutput(stats);
    }

    /**
     * Afiseaza mana playerului selectat
     * @param game instanta jocului
     * @param playerIdx indexul jucatorului
     */
    public void getplayermana(final Game game, final int playerIdx) {
        DebugPlayerMana stats = new DebugPlayerMana(GameConstants.GETPLAYERMANA, playerIdx,
                game.getPlayer()[playerIdx - 1].getMana());
        JsonOutManager.getInstance().addToOutput(stats);
    }

    /**
     * Afiseaza cartile din mana jucatorului specificat
     *
     * @param game instanta jocului
     * @param playerIdx indexul jucatorului
     */
    public void showPlayerHand(final Game game, final int playerIdx) {
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GETCARDSINHAND, playerIdx,
                game.getPlayer()[playerIdx - 1].getHand());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    /**
     * Afiseaza pachetul de carti al jucatorului specificat
     *
     * @param game instanta jocului
     * @param playerIdx indexul jucatorului
     */
    public void showPlayerDeck(final Game game, final int playerIdx) {
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GETPLAYERDECK, playerIdx,
                game.getPlayer()[playerIdx - 1].getDeck().getCards());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    /**
     * Afiseaza jucatorul activ
     *
     * @param game instanta jocului
     */
    public void activePlayer(final Game game) {
        DebugActivePlayer stats = new DebugActivePlayer(GameConstants.GETPLAYERTURN,
                (game.getPlayerIdxTurn() + 1));
        JsonOutManager.getInstance().addToOutput(stats);
    }
    /**
     * Afiseaza eroul jucatorului specificat
     *
     * @param game instanta jocului
     * @param playerIdx indexul jucatorului
     */
    public void getPlayerHero(final Game game, final int playerIdx) {
        DebugPlayerHero stats = new DebugPlayerHero(GameConstants.GETPLAYERHERO,
                playerIdx, game.getPlayer()[playerIdx - 1].getHero());
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
