package players;

import cards.Deck;
import cards.Hero;
import cards.Minion;

import java.util.ArrayList;

public class Player {
    private Hero hero;
    private int mana;
    private Deck deck;
    private ArrayList<Minion> hand;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


    public ArrayList<Minion> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Minion> hand) {
        this.hand = hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Player(Hero hero, Deck deck) {
        this.hero = hero;
        this.deck = deck;
        this.mana = 0;
        this.hand = new ArrayList<>();
    }
    public void drawCard() {
        if(!this.deck.getCards().isEmpty()) {
            Minion cardDrawn = deck.getCards().get(0);
            hand.add(cardDrawn);
            deck.getCards().remove(0);
        }
    }

    public void incrementMana(int mana) {
        if(mana > 10) {
            this.mana = this.mana + 10 ;
        } else {
            this.mana = mana + this.mana ;
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "hero=" + hero +
                ", mana=" + mana +
                ", deck=" + deck +
                ", hand=" + hand +
                '}';
    }
}
