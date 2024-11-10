package cards;

import fileio.CardInput;
import utils.CardManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    private ArrayList<Minion> cards;
    private CardManager cardManager;

    public Deck(final ArrayList<CardInput> cardsInput) {
        this.cardManager = new CardManager();
        this.cards = new ArrayList<>();
        for (CardInput card : cardsInput) {
            Minion playerCard = cardManager.getMinion(card);
            cards.add(playerCard);
        }
    }

    /**
     * Aceasta metoda amesteca deck-ul
     * @param shuffleSeed - reprezinta seed-ul dat in input ce ma ajuta sa fac o amestecare
     *                   controlata
     */
    public void shuffle(final int shuffleSeed) {
        Random rand = new Random(shuffleSeed);
        Collections.shuffle(this.cards, rand);
    }

    /**
     * Obtinem cartile din deck
     * @return cartile din deck
     */
    public ArrayList<Minion> getCards() {
        return cards;
    }
}
