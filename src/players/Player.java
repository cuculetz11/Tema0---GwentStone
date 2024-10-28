package players;

import cards.Deck;
import cards.Hero;
import cards.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Player {
    private Hero hero;
    private int mana;
    private Deck deck;
    private ArrayList<Minion> hand;
    private boolean isTurn;

    public Player(Hero hero, Deck deck) {
        this.hero = hero;
        this.deck = deck;
        this.mana = 0;
        this.hand = new ArrayList<>();
    }
    public void drawCard() {
        Minion cardDrawn = deck.getCards().getFirst();
        hand.add(cardDrawn);
        deck.getCards().removeFirst();
    }
    public void incrementMana(int mana) {
        this.mana = this.mana + mana;
        if(this.mana > 10) {
            this.mana = 10;
        }

    }
}
