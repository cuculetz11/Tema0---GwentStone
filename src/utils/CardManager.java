package utils;

import cards.*;
import fileio.CardInput;

/**
 * e un fel de design factory static
 */
public class CardManager {
    public static Minion getMinion(CardInput card) {
        return switch (card.getName()) {
            case GameConstants.DISCIPLE -> new Disciple(card);
            case GameConstants.GOLIATH -> new Goliath(card);
            case GameConstants.MIRAJ -> new Miraj(card);
            case GameConstants.WARDEN -> new Warden(card);
            case GameConstants.THECURSEDONE -> new TheCursedOne(card);
            case GameConstants.THERIPPER -> new TheRipper(card);
            default -> null;
        };
    }

    public static Hero getHero(CardInput card) {
        return switch (card.getName()) {
            case GameConstants.LORDROYCE -> new LordRoyce(card);
            case GameConstants.EMPRESSTHORINA -> new EmpressThorina(card);
            case GameConstants.KINGMUDFACE -> new KingMudface(card);
            case GameConstants.GENERALKOCIORAW -> new GeneralKocioraw(card);
            default -> null;
        };
    }
    public static void tranferFromInput(Card playerCard, CardInput input) {
        playerCard.setColors(input.getColors());
        playerCard.setName(input.getName());
        playerCard.setDescription(input.getDescription());
        playerCard.setMana(input.getMana());
        playerCard.setHealth(input.getHealth());

    }

}
