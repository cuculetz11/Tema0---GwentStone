package game;

import cards.Deck;
import cards.Hero;
import fileio.*;
import players.Player;
import utils.CardManager;
import utils.DeckManager;

import java.util.ArrayList;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private GameTable gameTable;
    private int roundNumber;
    private boolean gameOver;
    private int firstPlayerIdx;
    private ArrayList<ActionsInput> actionsInputs;

    public Player initalizePlayer(int idxDeck, DecksInput decks, int shuffleSeed, CardInput heroInput) {
        Deck deckPlayer = DeckManager.getPlayerDeck(idxDeck,decks,shuffleSeed);
        Hero heroCard = CardManager.getHero(heroInput);
        Player p = new Player(heroCard,deckPlayer);
        return p;
    }
    public Game(GameInput gameInput, DecksInput decksPlayerOne, DecksInput decksPlayerTwo) {
        StartGameInput startGameInput = new StartGameInput();
        this.playerOne = initalizePlayer(startGameInput.getPlayerOneDeckIdx(),decksPlayerOne,startGameInput.getShuffleSeed(),startGameInput.getPlayerOneHero());
        this.playerTwo = initalizePlayer(startGameInput.getPlayerTwoDeckIdx(), decksPlayerTwo,startGameInput.getShuffleSeed(),startGameInput.getPlayerTwoHero());
        this.roundNumber = 0;
        this.gameTable = GameTable.getInstance();
        this.gameOver = false;
        this.firstPlayerIdx = startGameInput.getShuffleSeed();
        this.actionsInputs = new ArrayList<>(gameInput.getActions());
    }
    public void playRound() {
        playerOne.drawCard();
        playerTwo.drawCard();
        this.roundNumber++;

    }
    public void checkGameOver() {
        if(actionsInputs.size() == 0) {
            gameOver = true;
        }
        if(playerOne.getHero().getHealth() == 0) {
            gameOver = true;
        }
        if(playerTwo.getHero().getHealth() == 0) {
            gameOver = true;
        }
    }
}
