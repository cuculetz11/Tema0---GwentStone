package game;

import cards.Deck;
import cards.Hero;
import fileio.ActionsInput;
import fileio.StartGameInput;
import fileio.CardInput;
import fileio.DecksInput;
import fileio.GameInput;
import players.Player;
import utils.ActionsController;
import utils.CardManager;


import java.util.ArrayList;

/**
 * Aceasta clasa are rolul de a initaliza un joc si de a-l desfasura
 */
public class Game {
    private Player[] player = new Player[2];
    private int roundNumber;
    private boolean gameOver;
    private int firstPlayerIdx;
    private int playerIdxTurn;
    private ArrayList<ActionsInput> actionsInputs;
    private CardManager cardManager;
    private ActionsController actionsManager;

    public Game(final GameInput gameInput, final DecksInput decksPlayerOne, final DecksInput
            decksPlayerTwo) {
        initializeGame(gameInput, decksPlayerOne, decksPlayerTwo);
        playing();

    }

    /**
     * Prin aceasta metoda se initializeaza un joc
     * @param gameInput inputul acestui joc
     * @param decksPlayerOne toate deck-urile date la start pentru jucatorul 1
     * @param decksPlayerTwo toate deck-urile date la start pentru jucatorul 2
     */
    public void initializeGame(final GameInput gameInput, final DecksInput decksPlayerOne, final
    DecksInput decksPlayerTwo) {
        StartGameInput startGameInput = gameInput.getStartGame();
        this.actionsManager = new ActionsController();
        this.cardManager = new CardManager();
        this.player[0] = initalizePlayer(startGameInput.getPlayerOneDeckIdx(), decksPlayerOne,
                startGameInput.getShuffleSeed(), startGameInput.getPlayerOneHero());
        this.player[1] = initalizePlayer(startGameInput.getPlayerTwoDeckIdx(), decksPlayerTwo,
                startGameInput.getShuffleSeed(), startGameInput.getPlayerTwoHero());
        this.roundNumber = 1;
        this.gameOver = false;
        this.firstPlayerIdx = startGameInput.getStartingPlayer() - 1;
        this.actionsInputs = new ArrayList<>(gameInput.getActions());
    }

    /**
     * Obtine playerii jocului
     * @return playerii acestui joc
     */
    public Player[] getPlayer() {
        return player;
    }

    /**
     * Obtine indexul jucatorului care este la tura de joc
     * @return indexul jucatorului curent (0 pentru jucatorul 1, 1 pentru jucatorul 2)
     */
    public int getPlayerIdxTurn() {
        return playerIdxTurn;
    }

    /**
     * Initializeaza un jucator pe baza indexului deck-ului, deck-urilor din input, seed-ului si
     * eroului dat la input
     *
     * @param idxDeck indexul deck-ului
     * @param decks deck-urile disponibile
     * @param shuffleSeed seed-ul pentru amestecarea deck-ului
     * @param heroInput input-ul eroului
     * @return un nou obiect Player
     */
    public Player initalizePlayer(final int idxDeck, final DecksInput decks, final int shuffleSeed,
                                  final CardInput heroInput) {
        Deck deckPlayer = new Deck(decks.getDecks().get(idxDeck));
        deckPlayer.shuffle(shuffleSeed);
        Hero heroCard = cardManager.getHero(heroInput);
        return new Player(heroCard, deckPlayer);
    }
    /**
     * Metoda principala de rulare a jocului
     */
    public void playing() {
        while (!gameOver) {
            playRound();
        }
        while (!actionsInputs.isEmpty()) {
            ActionsInput actionsInput = actionsInputs.get(0);
            actionsManager.performAction(actionsInput, this);
            actionsInputs.remove(0);
        }
    }
    /**
     * Runda curenta de joc, in care fiecare jucator are tura sa
     *
     * @param playerIndxTurn indexul jucatorului care joaca tura
     */
    public void playTurn(final int playerIndxTurn) {
        this.playerIdxTurn = playerIndxTurn;
        while (!gameOver) {
            ActionsInput actionsInput = actionsInputs.get(0);
            if (!actionsManager.performAction(actionsInput, this)) {
                GameTable.getInstance().resetUsedCards(this.getPlayer()[0].getHero(),
                        this.getPlayer()[1].getHero());
                actionsInputs.remove(0);
                break;
            }
            actionsInputs.remove(0);
            checkGameOver();

        }

    }
    /**
     * Metoda care gestioneaza o runda completa de joc
     */
    public void playRound() {
        player[0].incrementMana(roundNumber);
        player[1].incrementMana(roundNumber);
        player[0].drawCard();
        player[1].drawCard();
        GameTable.getInstance().unFreezeRows((firstPlayerIdx + 1) % 2);
        playTurn(firstPlayerIdx);
        if (gameOver) {
            return;
        }
        GameTable.getInstance().unFreezeRows(firstPlayerIdx);
        playTurn((firstPlayerIdx + 1) % 2);
        if (gameOver) {
            return;
        }
        this.roundNumber++;

    }
    /**
     * Verifica daca jocul s-a incheiat.
     */
    public void checkGameOver() {
        if (actionsInputs.isEmpty()) {
            gameOver = true;
        }
        if (player[0].getHero().getHealth() <= 0) {
            GamesController.getInstance().incrementPlayerTwoScore();
            player[1].wins(1);
            gameOver = true;
        }
        if (player[1].getHero().getHealth() <= 0) {
            GamesController.getInstance().incrementPlayerOneScore();
            player[0].wins(0);
            gameOver = true;
        }
    }
}
