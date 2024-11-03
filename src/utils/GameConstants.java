package utils;

public class GameConstants {
    private GameConstants() {}
    //constantele pentru numele cartilor
    public static final String DISCIPLE = "Disciple";
    public static final String GOLIATH = "Goliath";
    public static final String MIRAJ = "Miraj";
    public static final String WARDEN = "Warden";
    public static final String THECURSEDONE = "The Cursed One";
    public static final String THERIPPER = "The Ripper";
    public static final String LORDROYCE = "Lord Royce";
    public static final String EMPRESSTHORINA = "Empress Thorina";
    public static final String KINGMUDFACE = "King Mudface";
    public static final String GENERALKOCIORAW = "General Kocioraw";
    public static final String BERSERKER = "Berserker";
    public static final String SENTINEL = "Sentinel";
    //
    //actiuni pentru playeri
    public static final String ENDPLAYERTURN = "endPlayerTurn";
    public static final String PLACECARD = "placeCard";
    public static final String CARDUSESATTACK = "cardUsesAttack";
    public static final String CARDUSESABILITY = "cardUsesAbility";
    public static final String USEATTACKHERO = "useAttackHero";
    public static final String USEHEROABILITY = "useHeroAbility";
    //

    //comenzi debug
    public static final String GETCARDSINHAND= "getCardsInHand";
    public static final String GETPLAYERDECK = "getPlayerDeck";
    public static final String GETCARDSONTABLE = "getCardsOnTable";
    public static final String GETPLAYERTURN = "getPlayerTurn";
    public static final String GETPLAYERHERO = "getPlayerHero";
    public static final String GETCARDATPOSITION = "getCardAtPosition";
    public static final String GETPLAYERMANA = "getPlayerMana";
    public static final String GETFROZENCARDSONTABLE = "getFrozenCardsOnTable";
    //
    //comenzi statistici
    public static final String GETTOTALGAMESPLAYED = "getTotalGamesPlayed";
    public static final String GETPLAYERONEWINS = "getPlayerOneWins";
    public static final String GETPLAYERTWOWINS = "getPlayerTwoWins";
    //
    // String pentru erori
    public static final String NOTENOUGHMANATABLE = "Not enough mana to place card on table.";
    public static final String NOTENOUGHMANAHERO = "Not enough mana to use hero's ability.";
    public static final String FULLTABLE = "Cannot place card on table since row is full.";
    public static final String NOTBELONGTOENEMY = "Attacked card does not belong to the enemy.";
    public static final String ROWNOTBELONGTOENEMY = "Selected row does not belong to the enemy.";
    public static final String ROWNOTBELONGTOCURRENT = "Selected row does not belong to the current player.";
    public static final String NOTBELONGTOCURRENT = "Attacked card does not belong to the current player.";
    public static final String ALREADYATTACKED = "Attacker card has already attacked this turn.";
    public static final String ALREADYATTACKEDHERO = "Hero has already attacked this turn.";
    public static final String FROZEN = "Attacker card is frozen.";
    public static final String NOTTANK = "Attacked card is not of type 'Tank'.";
    public static final String NOCARDATPOS = "No card available at that position.";
    //
    // pt win

    public static final String[] PLAYERWINS = {"Player one killed the enemy hero.", "Player two killed the enemy hero."};
    //


}
