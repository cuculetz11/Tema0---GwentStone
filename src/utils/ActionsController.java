package utils;

import action.ActivePLayer;
import action.CardUseAbility;
import action.CardUsesAttack;
import action.CommandAction;
import action.GetFrozenCards;
import action.GetPlayerAtPosition;
import action.GetPlayerHero;
import action.GetPlayerMana;
import action.GetPlayerOneWins;
import action.GetPlayerTwoWins;
import action.GetTotalGamesPlayed;
import action.PlaceCard;
import action.ShowCardsTable;
import action.ShowPlayerDeck;
import action.ShowPlayerHand;
import action.UseAttackHero;
import action.UseHeroAbility;
import fileio.ActionsInput;
import game.Game;

import java.util.HashMap;

public class ActionsController {
    private final HashMap<String, CommandAction> commands;


    public ActionsController() {
        commands = new HashMap<>();

        commands.put(GameConstants.PLACE_CARD, new PlaceCard());
        commands.put(GameConstants.CARD_USES_ATTACK, new CardUsesAttack());
        commands.put(GameConstants.CARD_USES_ABILITY, new CardUseAbility());
        commands.put(GameConstants.USE_HERO_ABILITY, new UseHeroAbility());
        commands.put(GameConstants.USE_ATTACK_HERO, new UseAttackHero());

        commands.put(GameConstants.GET_CARDS_INHAND, new ShowPlayerHand());
        commands.put(GameConstants.GET_CARDS_ON_TABLE, new ShowCardsTable());
        commands.put(GameConstants.GET_PLAYER_HERO, new GetPlayerHero());
        commands.put(GameConstants.GET_PLAYER_MANA, new GetPlayerMana());
        commands.put(GameConstants.GET_PLAYER_DECK, new ShowPlayerDeck());
        commands.put(GameConstants.GET_PLAYER_TURN, new ActivePLayer());
        commands.put(GameConstants.GET_CARD_AT_POSITION, new GetPlayerAtPosition());
        commands.put(GameConstants.GET_FROZEN_CARDS_ON_TABLE, new GetFrozenCards());
        commands.put(GameConstants.GET_TOTAL_GAMES_PLAYED, new GetTotalGamesPlayed());
        commands.put(GameConstants.GET_PLAYER_ONE_WINS, new GetPlayerOneWins());
        commands.put(GameConstants.GET_PLAYER_TWO_WINS, new GetPlayerTwoWins());
    }
    /**
     * Efectueaza actiunea pe baza inputului furnizat
     * @param action actiunea de intrare care trebuie efectuata
     * @param game instanta curenta a jocului
     * @return true daca actiunea a fost efectuata cu succes, false daca tura s-a incheiat
     */
    public boolean performAction(final ActionsInput action, final Game game) {
        if (action.getCommand().equals(GameConstants.END_PLAYER_TURN)) {
            return false;
        }
        CommandAction commandAction = commands.get(action.getCommand());
        if (commandAction != null) {
            commandAction.execute(game, action);
            return true;
        } else {
            throw new IllegalArgumentException("Unknown command: " + action.getCommand());
        }
    }
}
