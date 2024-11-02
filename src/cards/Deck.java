package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;
import utils.CardManager;

import java.util.ArrayList;


public class Deck {
    private ArrayList<Minion> cards;

    public ArrayList<Minion> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Minion> cards) {
        this.cards = cards;
    }

    public Deck(ArrayList<CardInput> cardsInput) {
        this.cards = new ArrayList<>();
        for(CardInput card : cardsInput) {
            Minion playerCard = CardManager.getMinion(card);
            cards.add(playerCard);
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
