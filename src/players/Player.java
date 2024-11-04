package players;

import cards.Deck;
import cards.Hero;
import cards.Minion;
import utils.GameConstants;
import utils.GameEnded;
import utils.JsonOutManager;

import java.util.ArrayList;

public class Player {
    private Hero hero;
    private int mana;
    private Deck deck;
    private ArrayList<Minion> hand;

    public Player(final Hero hero, final Deck deck) {
        this.hero = hero;
        this.deck = deck;
        this.mana = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Obtine eroul jucatorului
     * @return eroul jucatorului
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * Seteaza eroul jucatorului
     * @param hero noul erou al jucatorului
     */
    public void setHero(final Hero hero) {
        this.hero = hero;
    }

    /**
     * Obtine mana curenta a jucatorului
     * @return mana curenta a jucatorului
     */
    public ArrayList<Minion> getHand() {
        return hand;
    }

    /**
     * Obtine pachetul de carti al jucatorului
     * @return pachetul de carti al jucatorului
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Obtine mana curenta a jucatorului
     * @return mana curenta a jucatorului
     */
    public int getMana() {
        return mana;
    }

    /**
     * Seteaza mana jucatorului
     * @param mana noua mana a jucatorului
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     * Jucatorul trage o carte din pachet si o adauga in mana
     */
    public void drawCard() {
        if (!this.deck.getCards().isEmpty()) {
            Minion cardDrawn = deck.getCards().get(0);
            hand.add(cardDrawn);
            deck.getCards().remove(0);
        }
    }

    /**
     * Creste mana jucatorului cu o anumita valoare
     * @param mana valoarea cu care se va creste mana
     */
    public void incrementMana(final int mana) {
        if (mana > GameConstants.MAXMANA) {
            this.mana = this.mana + GameConstants.MAXMANA;
        } else {
            this.mana = mana + this.mana;
        }
    }

    /**
     * Marcheaza jucatorul ca fiind castigator
     * @param playerIdx indexul jucatorului care a castigat
     */
    public void wins(final int playerIdx) {
        GameEnded gameEnded = new GameEnded(GameConstants.PLAYERWINS[playerIdx]);
        JsonOutManager.getInstance().addToOutput(gameEnded);
    }
}
