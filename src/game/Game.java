package game;

import cards.Deck;
import cards.Hero;
import fileio.*;
import players.Player;
import utils.ActionsManager;
import utils.CardManager;
import utils.DeckManager;

import java.util.ArrayList;


public class Game {
    private Player[] player = new Player[2];
    private int roundNumber;
    private boolean gameOver;
    private int firstPlayerIdx;
    private int playerIdxTurn;
    private ArrayList<ActionsInput> actionsInputs;

    public Player[] getPlayer() {
        return player;
    }

    public ArrayList<ActionsInput> getActionsInputs() {
        return actionsInputs;
    }

    public int getFirstPlayerIdx() {
        return firstPlayerIdx;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getPlayerIdxTurn() {
        return playerIdxTurn;
    }

    public void setPlayerIdxTurn(int playerIdxTurn) {
        this.playerIdxTurn = playerIdxTurn;
    }

    public Player initalizePlayer(int idxDeck, DecksInput decks, int shuffleSeed, CardInput heroInput) {
        Deck deckPlayer = DeckManager.getPlayerDeck(idxDeck,decks,shuffleSeed);
        DeckManager.cardShuffle(deckPlayer, shuffleSeed);
//        System.out.println(deckPlayer.toString());
        Hero heroCard = CardManager.getHero(heroInput);
        return new Player(heroCard,deckPlayer);
    }
    public Game(GameInput gameInput, DecksInput decksPlayerOne, DecksInput decksPlayerTwo) {
        StartGameInput startGameInput = gameInput.getStartGame();
        this.player[0] = initalizePlayer(startGameInput.getPlayerOneDeckIdx(),decksPlayerOne,startGameInput.getShuffleSeed(),startGameInput.getPlayerOneHero());
        this.player[1] = initalizePlayer(startGameInput.getPlayerTwoDeckIdx(), decksPlayerTwo,startGameInput.getShuffleSeed(),startGameInput.getPlayerTwoHero());
        this.roundNumber = 1;
        this.gameOver = false;
        this.firstPlayerIdx = startGameInput.getStartingPlayer() - 1;
        this.actionsInputs = new ArrayList<>(gameInput.getActions());
        playing();

    }
    public void playing() {
        while(!gameOver) {
            playRound();

            checkGameOver();
        }
    }
    public void playTurn(Player player,int playerIdxTurn) {
        this.playerIdxTurn = playerIdxTurn;
        while(!gameOver) {
            ActionsInput actionsInput = actionsInputs.get(0);
            if(!ActionsManager.performAction(actionsInput,this)) {
                GameTable.getInstance().resetUsedCards();
                actionsInputs.remove(0);
                break;
            }
            actionsInputs.remove(0);
            checkGameOver();

        }

    }
    public void playRound() {
        player[0].incrementMana(roundNumber);
        player[1].incrementMana(roundNumber);
        player[0].drawCard();
        player[1].drawCard();
        playTurn(player[this.firstPlayerIdx],firstPlayerIdx);
        playTurn(player[(this.firstPlayerIdx + 1) % 2],(firstPlayerIdx+1) % 2);
        this.roundNumber++;

    }
    public void checkGameOver() {
        if(actionsInputs.isEmpty()) {
            gameOver = true;
        }
        if(player[0].getHero().getHealth() == 0) {
            GamesController.incrementPlayerTwoScore();
            gameOver = true;
        }
        if(player[1].getHero().getHealth() == 0) {
            GamesController.incrementPlayerOneScore();
            gameOver = true;
        }
    }
}
