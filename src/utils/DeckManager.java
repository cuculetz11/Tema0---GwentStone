package utils;

import cards.Deck;
import fileio.CardInput;
import fileio.DecksInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Aceasta clasa vreau sa mi ia de la input deckurile
 * apoi cu seed ul dat sa le amestece si sa i dea fiecarui
 * player deck ul specific
 */
public class DeckManager {
   public static Deck getPlayerDeck(int deckNumber, DecksInput decksInput,int seed) {
       ArrayList<Integer> indexes = new ArrayList<>();
       for(int i = 0; i < decksInput.getNrDecks(); i++) {
           indexes.add(i);
       }
       Random rand = new Random(seed);
       rand.setSeed(seed);
       Collections.shuffle(indexes, rand);
       ArrayList<CardInput> deck = decksInput.getDecks().get(indexes.get(deckNumber));
       return new Deck(deck);



   }

}
