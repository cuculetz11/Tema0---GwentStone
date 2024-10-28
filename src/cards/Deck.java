package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;
import utils.CardManager;

import java.util.ArrayList;

@Getter
@Setter
public class Deck {
    private ArrayList<Minion> cards;

    public Deck(ArrayList<CardInput> cardsInput) {
        this.cards = new ArrayList<>();
        for(CardInput card : cardsInput) {
            Minion playerCard = CardManager.getMinion(card);
            cards.add(playerCard);
        }
    }
}
