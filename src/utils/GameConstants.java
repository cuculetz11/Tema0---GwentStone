package utils;

public final class GameConstants {
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
    public static final String END_PLAYER_TURN = "endPlayerTurn";
    public static final String PLACE_CARD = "placeCard";
    public static final String CARD_USES_ATTACK = "cardUsesAttack";
    public static final String CARD_USES_ABILITY = "cardUsesAbility";
    public static final String USE_ATTACK_HERO = "useAttackHero";
    public static final String USE_HERO_ABILITY = "useHeroAbility";
    //comenzi debug
    public static final String GET_CARDS_INHAND = "getCardsInHand";
    //
    public static final String GET_PLAYER_DECK = "getPlayerDeck";
    public static final String GET_CARDS_ON_TABLE = "getCardsOnTable";
    public static final String GET_PLAYER_TURN = "getPlayerTurn";
    public static final String GET_PLAYER_HERO = "getPlayerHero";
    public static final String GET_CARD_AT_POSITION = "getCardAtPosition";
    public static final String GET_PLAYER_MANA = "getPlayerMana";
    public static final String GET_FROZEN_CARDS_ON_TABLE = "getFrozenCardsOnTable";
    //
    //comenzi statistici
    public static final String GET_TOTAL_GAMES_PLAYED = "getTotalGamesPlayed";
    public static final String GET_PLAYER_ONE_WINS = "getPlayerOneWins";
    public static final String GET_PLAYER_TWO_WINS = "getPlayerTwoWins";
    //
    // String pentru erori
    public static final String NOT_ENOUGH_MANA_TABLE = "Not enough mana to place card on table.";
    public static final String NOT_ENOUGH_MANA_HERO = "Not enough mana to use hero's ability.";
    public static final String FULL_TABLE = "Cannot place card on table since row is full.";
    public static final String NOT_BELONG_TO_ENEMY = "Attacked card does not belong to the enemy.";
    public static final String ROW_NOT_BELONG_TO_ENEMY = "Selected row does not belong to the enemy.";
    public static final String ROW_NOT_BELONG_TO_CURRENT
            = "Selected row does not belong to the current player.";
    public static final String NOT_BELONG_TO_CURRENT
            = "Attacked card does not belong to the current player.";
    public static final String ALREADY_ATTACKED = "Attacker card has already attacked this turn.";
    public static final String ALREADY_ATTACKED_HERO = "Hero has already attacked this turn.";
    public static final String FROZEN = "Attacker card is frozen.";
    public static final String NOT_TANK = "Attacked card is not of type 'Tank'.";
    public static final String NO_CARD_AT_POS = "No card available at that position.";
    public static final String[] PLAYER_WINS
            = {"Player one killed the enemy hero.", "Player two killed the enemy hero."};
    //
    //
    public static final int MAX_HEALTH_HERO = 30;
    public static final int MAX_MANA = 10;
    public static final int LAST_ROW = 3;
    public static final int MAX_COLUMN_SIZE = 5;
    public static final int MAX_ROW_SIZE = 4;
    private GameConstants() {
    }
    //


}
