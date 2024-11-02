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
       ArrayList<CardInput> deck = decksInput.getDecks().get(deckNumber);
       return new Deck(deck);
   }
   public static void cardShuffle(Deck deck,int shuffleSeed) {
        Random rand = new Random(shuffleSeed);
        Collections.shuffle(deck.getCards(), rand);
   }

}
