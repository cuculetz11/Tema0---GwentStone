package utils;

import cards.Berserker;
import cards.Card;
import cards.Disciple;
import cards.EmpressThorina;
import cards.GeneralKocioraw;
import cards.Goliath;
import cards.Hero;
import cards.KingMudface;
import cards.LordRoyce;
import cards.Minion;
import cards.Miraj;
import cards.Sentinel;
import cards.TheCursedOne;
import cards.TheRipper;
import cards.Warden;
import fileio.CardInput;

/**
 * E un fel de design factory static
 */
public class CardManager {
    /**
     * Aceasta metoda preia cartea data ca input si o transforma in minionul aferent ei
     * @param card cartea data ca input
     * @return minionul ce reprezinta acea carte
     */
    public Minion getMinion(final CardInput card) {
        switch (card.getName()) {
            case GameConstants.DISCIPLE:
                return new Disciple(card);
            case GameConstants.GOLIATH:
                return new Goliath(card);
            case GameConstants.MIRAJ:
                return new Miraj(card);
            case GameConstants.WARDEN:
                return new Warden(card);
            case GameConstants.THECURSEDONE:
                return new TheCursedOne(card);
            case GameConstants.THERIPPER:
                return new TheRipper(card);
            case GameConstants.BERSERKER:
                return new Berserker(card);
            case GameConstants.SENTINEL:
                return new Sentinel(card);
            default:
                return null;
        }
    }

    /**
     * Preia cartea de la input si ne intoarce regele aferent ei
     * @param card cartea data ca input
     * @return regele aferent ei
     */
    public Hero getHero(final CardInput card) {
        switch (card.getName()) {
            case GameConstants.LORDROYCE:
                return new LordRoyce(card);
            case GameConstants.EMPRESSTHORINA:
                return new EmpressThorina(card);
            case GameConstants.KINGMUDFACE:
                return new KingMudface(card);
            case GameConstants.GENERALKOCIORAW:
                return new GeneralKocioraw(card);
            default:
                return null;
        }
    }

    /**
     * Transforma datele din input intr-un obiect de tip Card
     * @param playerCard cartea ce va fi setata
     * @param input datele de input ce vor fi folosite
     */
    public static void fromInputToObject(final Card playerCard, final CardInput input) {
        playerCard.setColors(input.getColors());
        playerCard.setName(input.getName());
        playerCard.setDescription(input.getDescription());
        playerCard.setMana(input.getMana());
        playerCard.setHealth(input.getHealth());
        playerCard.setWasUsed(false);
        playerCard.setFrozen(false);

    }

}
