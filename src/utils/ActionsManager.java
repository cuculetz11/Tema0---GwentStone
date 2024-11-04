package utils;

import statistics.StatsManager;
import cards.Hero;
import cards.Minion;
import debug.DebugManager;
import error.ErrorManger;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;
import players.Player;

import java.util.ArrayList;

public class ActionsManager {
    private ErrorManger errorManger;
    private DebugManager debugManager;
    private StatsManager statsManager;

    public ActionsManager() {
        errorManger = new ErrorManger();
        debugManager = new DebugManager();
        statsManager = new StatsManager();
    }
    /**
     * Efectueaza actiunea pe baza inputului furnizat
     * @param action actiunea de intrare care trebuie efectuata
     * @param game instanta curenta a jocului
     * @return true daca actiunea a fost efectuata cu succes, false daca tura s-a incheiat
     */
    public boolean performAction(final ActionsInput action, final Game game) {
        switch (action.getCommand()) {
            case GameConstants.ENDPLAYERTURN:
                return false;
            case GameConstants.GETCARDSINHAND:
                debugManager.showPlayerHand(game, action.getPlayerIdx());
                break;
            case GameConstants.GETPLAYERDECK:
                debugManager.showPlayerDeck(game, action.getPlayerIdx());
                break;
            case GameConstants.GETCARDSONTABLE:
                debugManager.showCardsTable();
                break;
            case GameConstants.GETPLAYERTURN:
                debugManager.activePlayer(game);
                break;
            case GameConstants.GETPLAYERHERO:
                debugManager.getPlayerHero(game, action.getPlayerIdx());
                break;
            case GameConstants.PLACECARD:
                placeCard(game, action.getHandIdx());
                break;
            case (GameConstants.GETPLAYERMANA):
                debugManager.getplayermana(game, action.getPlayerIdx());
                break;
            case GameConstants.CARDUSESATTACK:
                cardUsesAttack(game, action);
                break;
            case GameConstants.GETCARDATPOSITION:
                debugManager.getPlayerAtPosition(action);
                break;
            case GameConstants.CARDUSESABILITY:
                cardUseAbility(action, game);
                break;
            case GameConstants.USEATTACKHERO:
                useAttackHero(game, action);
                break;
            case GameConstants.USEHEROABILITY:
                useHeroAbility(game, action);
                break;
            case GameConstants.GETFROZENCARDSONTABLE:
                debugManager.getFrozenCards();
                break;
            case GameConstants.GETTOTALGAMESPLAYED:
                statsManager.getTotalGamesPlayed();
                break;
            case GameConstants.GETPLAYERONEWINS:
                statsManager.getPlayerOneWins();
                break;
            case GameConstants.GETPLAYERTWOWINS:
                statsManager.getPlayerTwoWins();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action.getCommand());
        }
        return true;
    }

    private void cardUseAbility(final ActionsInput action, final Game game) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),
                action.getCardAttacker().getY());
        if (errorManger.handleCardAbilityError(attacker, action)) {
            return;
        }
        attacker.useAbility(game, action, errorManger);
    }

    private void useHeroAbility(final Game game, final ActionsInput action) {
        Hero hero = game.getPlayer()[game.getPlayerIdxTurn()].getHero();
        int manaPlayer = game.getPlayer()[game.getPlayerIdxTurn()].getMana();
        if (errorManger.handleHeroAbilityError(hero, manaPlayer, action)) {
            return;
        }
        hero.useAbility(game, action, errorManger);

    }

    private void useAttackHero(final Game game, final ActionsInput action) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),
                action.getCardAttacker().getY());
        int enemyIdx = (game.getPlayerIdxTurn() + 1) % 2;
        if (errorManger.handleAttackHeroError(attacker, action, enemyIdx)) {
            return;
        }
        attacker.setWasUsed(true);
        Hero enemyHero = game.getPlayer()[(game.getPlayerIdxTurn() + 1) % 2].getHero();
        enemyHero.setHealth(enemyHero.getHealth() - attacker.getAttackDamage());

    }

    private void cardUsesAttack(final Game game, final ActionsInput action) {
        int playerIdx = game.getPlayerIdxTurn();
        int attackedRowIdx = action.getCardAttacked().getX();
        if (errorManger.handleSelfCardAttack(playerIdx, attackedRowIdx, action)) {
            return;
        }
        Minion attacker = GameTable.getInstance().getRowFromTable(action.getCardAttacker().getX(),
                playerIdx).get(action.getCardAttacker().getY());
        ArrayList<Minion> attackedRow = GameTable.getInstance().getRowFromTable(
                action.getCardAttacked().getX(), (playerIdx + 1) % 2);
        Minion attacked = attackedRow.get(action.getCardAttacked().getY());
        boolean tank = GameTable.getInstance().isThereATank(((game.getPlayerIdxTurn()) + 1) % 2);
        if (errorManger.handleCardAttackError(attacker, attacked, action, tank)) {
            return;
        }
        attacker.setWasUsed(true);
        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage());
        if (attacked.getHealth() <= 0) {
            attackedRow.remove(action.getCardAttacked().getY());
        }
    }

    private void placeCard(final Game game, final int handIdx) {
        Player p = game.getPlayer()[game.getPlayerIdxTurn()];
        Minion card = p.getHand().get(handIdx);
        if (errorManger.handlePlaceCardError(p, card, handIdx, game.getPlayerIdxTurn())) {
            return;
        }
        if (card.isFront()) {
            GameTable.getInstance().getPlayerFrontRow()[game.getPlayerIdxTurn()].add(card);
            p.getHand().remove(handIdx);
            p.setMana(p.getMana() - card.getMana());
        } else {
            GameTable.getInstance().getPlayerBackRow()[game.getPlayerIdxTurn()].add(card);
            p.getHand().remove(handIdx);
            p.setMana(p.getMana() - card.getMana());
        }
    }

}
