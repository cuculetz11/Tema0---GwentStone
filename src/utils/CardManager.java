package utils;

import cards.*;
import fileio.CardInput;

/**
 * e un fel de design factory static
 */
public class CardManager {
    public static Minion getMinion(CardInput card) {
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

    public static Hero getHero(CardInput card) {
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

    public static void fromInputToObject(Card playerCard, CardInput input) {
        playerCard.setColors(input.getColors());
        playerCard.setName(input.getName());
        playerCard.setDescription(input.getDescription());
        playerCard.setMana(input.getMana());
        playerCard.setHealth(input.getHealth());
        playerCard.setWasUsed(false);
        playerCard.setFrozen(false);

    }

}
