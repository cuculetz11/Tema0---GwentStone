package utils;

import Statistics.StatsOut;
import cards.Hero;
import cards.Minion;
import debug.*;
import errorAction.ErrorAttackHero;
import errorAction.ErrorCardAttack;
import errorAction.ErrorCardTable;
import errorAction.ErrorHeroAbility;
import fileio.ActionsInput;
import fileio.Coordinates;
import game.Game;
import game.GameTable;
import game.GamesController;
import players.Player;

import java.util.ArrayList;

public class ActionsManager {
    public static boolean performAction(ActionsInput action, Game game) {
        if(action.getCommand().equals(GameConstants.ENDPLAYERTURN)) {
            return false;
        }
        if(action.getCommand().equals(GameConstants.GETCARDSINHAND)) {
            showPlayerHand(game, action.getPlayerIdx());
        } else if(action.getCommand().equals(GameConstants.GETPLAYERDECK)) {
            showPlayerDeck(game, action.getPlayerIdx());
        } else if(action.getCommand().equals(GameConstants.GETCARDSONTABLE)) {
            showCardsTable();
        } else if(action.getCommand().equals(GameConstants.GETPLAYERTURN)) {
            activePlayer(game);
        } else if(action.getCommand().equals(GameConstants.GETPLAYERHERO)) {
            getPlayerHero(game, action.getPlayerIdx());
        } else if(action.getCommand().equals(GameConstants.PLACECARD)) {
            placeCard(game,action.getHandIdx());
        } else if(action.getCommand().equals((GameConstants.GETPLAYERMANA))) {
            getplayermana(game,action.getPlayerIdx());
        } else if(action.getCommand().equals(GameConstants.CARDUSESATTACK)) {
            cardUsesAttack(game, action);
        } else if(action.getCommand().equals(GameConstants.GETCARDATPOSITION)) {
            getPlayerAtPosition(action);
        } else if(action.getCommand().equals(GameConstants.CARDUSESABILITY)) {
            cardUseAbility(action,game);
        } else if(action.getCommand().equals(GameConstants.USEATTACKHERO)) {
            useAttackHero(game,action);
        } else if(action.getCommand().equals(GameConstants.USEHEROABILITY)) {
            useHeroAbility(game,action);
        } else if(action.getCommand().equals(GameConstants.GETFROZENCARDSONTABLE)) {
            getFrozenCards();
        } else if(action.getCommand().equals(GameConstants.GETTOTALGAMESPLAYED)) {
            getTotalGamesPlayed();
        } else if(action.getCommand().equals(GameConstants.GETPLAYERONEWINS)) {
            getPlayerOneWins();
        } else if(action.getCommand().equals(GameConstants.GETPLAYERTWOWINS)) {
            getPlayerTwoWins();
        }
        //REFA OOP-

        return true;
    }

    public static boolean isEnemyCard(int playerIdx, int attackedRowIdx) {
        return  (playerIdx == 0 && (attackedRowIdx == 0 || attackedRowIdx == 1)) ||
                (playerIdx == 1 && (attackedRowIdx == 2 || attackedRowIdx == 3));
    }

    private static void getTotalGamesPlayed() {
        StatsOut stats = new StatsOut(GameConstants.GETTOTALGAMESPLAYED, GamesController.getInstance().getNumberGames());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void getPlayerOneWins() {
        StatsOut stats = new StatsOut(GameConstants.GETPLAYERONEWINS, GamesController.getInstance().getPlayerOneScore());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void getPlayerTwoWins() {
        StatsOut stats = new StatsOut(GameConstants.GETPLAYERTWOWINS, GamesController.getInstance().getPlayerTwoScore());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void getPlayerAtPosition(ActionsInput action) {
        int X = action.getX();
        int Y = action.getY();
        Minion card = GameTable.getInstance().getCardTable(X,Y);
        if(card == null) {
            DebugCardAtPositionErr stats = new DebugCardAtPositionErr(GameConstants.GETCARDATPOSITION,X,Y,GameConstants.NOCARDATPOS);
            JsonOutManager.getInstance().addToOutput(stats);
        } else {
            DebugCardAtPosition stats = new DebugCardAtPosition(GameConstants.GETCARDATPOSITION,X,Y,card);
            JsonOutManager.getInstance().addToOutput(stats);
        }
    }
    private static void getFrozenCards() {
        ArrayList<Minion> frozenMinions = new ArrayList<>();
        ArrayList<Minion>[] playerBackRow = GameTable.getInstance().getPlayerBackRow();
        ArrayList<Minion>[] playerFrontRow = GameTable.getInstance().getPlayerFrontRow();
        ArrayList<Minion>[] allTable = new ArrayList[4];
        allTable[0] = playerBackRow[1];
        allTable[1] = playerFrontRow[1];
        allTable[2] = playerFrontRow[0];
        allTable[3] = playerBackRow[0];
        for(int i = 0 ; i < 4 ; i++) {
            for(Minion minion : allTable[i]) {
                if(minion.isFrozen()) {
                    frozenMinions.add(minion);
                }
            }
        }
        DebugFrozenCards stats = new DebugFrozenCards(GameConstants.GETFROZENCARDSONTABLE,frozenMinions);
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void getplayermana(Game game, int playerIdx) {
        DebugPlayerMana stats = new DebugPlayerMana(GameConstants.GETPLAYERMANA,playerIdx,game.getPlayer()[playerIdx - 1].getMana());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void showPlayerHand(Game game,int playerIdx) {
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GETCARDSINHAND,playerIdx, game.getPlayer()[playerIdx - 1].getHand());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void showPlayerDeck(Game game,int playerIdx) {
        DebugShowDeck stats = new DebugShowDeck(GameConstants.GETPLAYERDECK,playerIdx,game.getPlayer()[playerIdx - 1].getDeck().getCards());
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void showCardsTable() {
        ArrayList<Minion>[] playerBackRow = GameTable.getInstance().getPlayerBackRow();
        ArrayList<Minion>[] playerFrontRow = GameTable.getInstance().getPlayerFrontRow();
        ArrayList<Minion>[] allTable = new ArrayList[4];
        allTable[0] = playerBackRow[1];
        allTable[1] = playerFrontRow[1];
        allTable[2] = playerFrontRow[0];
        allTable[3] = playerBackRow[0];
        DebugCardsTable stats = new DebugCardsTable(GameConstants.GETCARDSONTABLE, allTable);
        JsonOutManager.getInstance().addToOutput(stats);
    }
    private static void activePlayer(Game game) {

        DebugActivePlayer stats = new DebugActivePlayer(GameConstants.GETPLAYERTURN, (game.getPlayerIdxTurn()+1));
        JsonOutManager.getInstance().addToOutput(stats);

    }
    private static void getPlayerHero(Game game, int playerIdx) {
        DebugPlayerHero stats = new DebugPlayerHero(GameConstants.GETPLAYERHERO,playerIdx,game.getPlayer()[playerIdx - 1].getHero());
        JsonOutManager.getInstance().addToOutput(stats);
    }

    private static void cardUseAbility(ActionsInput action,Game game) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),action.getCardAttacker().getY());
        if(attacker.isFrozen()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESABILITY,GameConstants.FROZEN,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        if(attacker.isWasUsed()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESABILITY,GameConstants.ALREADYATTACKED,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        attacker.useAbility(game, action);
    }

    private static void useHeroAbility(Game game, ActionsInput action) {
        Hero hero = game.getPlayer()[game.getPlayerIdxTurn()].getHero();
        if(hero.getMana() > game.getPlayer()[game.getPlayerIdxTurn()].getMana()) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.NOTENOUGHMANAHERO,GameConstants.USEHEROABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        if(hero.isWasUsed()) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ALREADYATTACKEDHERO,GameConstants.USEHEROABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        hero.useAbility(game, action);

    }
    private static void useAttackHero(Game game, ActionsInput action) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),action.getCardAttacker().getY());
        if(attacker.isFrozen()) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.FROZEN,GameConstants.USEATTACKHERO,action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        if(attacker.isWasUsed()) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.ALREADYATTACKED,GameConstants.USEATTACKHERO,action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }

        if(GameTable.getInstance().isThereATank(((game.getPlayerIdxTurn()) + 1) % 2)) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.NOTTANK,GameConstants.USEATTACKHERO,action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return;
        }
        attacker.setWasUsed(true);
        Hero enemyHero = game.getPlayer()[(game.getPlayerIdxTurn() + 1) % 2].getHero();
        enemyHero.setHealth(enemyHero.getHealth() - attacker.getAttackDamage());

    }
    private static void cardUsesAttack(Game game, ActionsInput action) {
        int playerIdx = game.getPlayerIdxTurn();
        int attackedRowIdx = action.getCardAttacked().getX();

        if(!isEnemyCard(playerIdx, attackedRowIdx)) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESATTACK,GameConstants.NOTBELONGTOENEMY,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }


        Minion attacker = GameTable.getInstance().getRowFromTable(action.getCardAttacker().getX(),playerIdx).get(action.getCardAttacker().getY());
        ArrayList<Minion> attackedRow = GameTable.getInstance().getRowFromTable(action.getCardAttacked().getX(),(playerIdx + 1) % 2);
        Minion attacked = attackedRow.get(action.getCardAttacked().getY());
        if(attacker.isWasUsed()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESATTACK,GameConstants.ALREADYATTACKED,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        if(attacker.isFrozen()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESATTACK,GameConstants.FROZEN,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }


        if(!attacked.isTank() && GameTable.getInstance().isThereATank(((game.getPlayerIdxTurn()) + 1) % 2)) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARDUSESATTACK,GameConstants.NOTTANK,action.getCardAttacker(),action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return;
        }
        attacker.setWasUsed(true);
        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage());
        if(attacked.getHealth() <= 0) {
            attackedRow.remove(action.getCardAttacked().getY());
        }
    }

    private static void placeCard(Game game, int handIdx) {
        Player p = game.getPlayer()[game.getPlayerIdxTurn()];
        Minion card = p.getHand().get(handIdx);
        if (p.getMana() < card.getMana()) {
            ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACECARD, handIdx, GameConstants.NOTENOUGHMANATABLE);
            JsonOutManager.getInstance().addToOutput(stats);
        } else {
            if (card.isFront()) {
                if (GameTable.getInstance().getPlayerFrontRow()[game.getPlayerIdxTurn()].size() >= 5) {
                    ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACECARD, handIdx, GameConstants.FULLTABLE);
                    JsonOutManager.getInstance().addToOutput(stats);
                } else {
                    GameTable.getInstance().getPlayerFrontRow()[game.getPlayerIdxTurn()].add(card);
                    p.getHand().remove(handIdx);
                    p.setMana(p.getMana() - card.getMana());
                }

            } else {
                if (GameTable.getInstance().getPlayerBackRow()[game.getPlayerIdxTurn()].size() >= 5) {
                    ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACECARD, handIdx, GameConstants.FULLTABLE);
                    JsonOutManager.getInstance().addToOutput(stats);
                } else {
                    GameTable.getInstance().getPlayerBackRow()[game.getPlayerIdxTurn()].add(card);
                    p.getHand().remove(handIdx);
                    p.setMana(p.getMana() - card.getMana());
                }
            }

        }
    }

}
