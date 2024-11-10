package error;


import cards.Hero;
import cards.Minion;
import fileio.ActionsInput;
import game.GameTable;
import players.Player;
import utils.GameConstants;
import utils.JsonOutManager;


public class ErrorManger {
    /**
     * Verifica daca cardul atacat este un card inamic in functie de indexul jucatorului si
     * indexul randului atacat
     *
     * @param playerIdx indexul jucatorului (0 pentru jucatorul 1, 1 pentru jucatorul 2)
     * @param attackedRowIdx indexul randului atacat
     * @return true daca cardul atacat este un card inamic, false altfel
     */
    public boolean isEnemyCard(final int playerIdx, final int attackedRowIdx) {
        return (playerIdx == 0 && (attackedRowIdx == 0 || attackedRowIdx == 1))
                || (playerIdx == 1 && (attackedRowIdx == 2 || attackedRowIdx
                == GameConstants.LAST_ROW));
    }
    /**
     * Gestioneaza erorile legate de abilitatea unui card (Minion) atacator
     *
     * @param attacker cardul (Minion) atacator
     * @param action actiunea care contine detalii despre atac
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleCardAbilityError(final Minion attacker, final ActionsInput action) {
        if (attacker.isFrozen()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ABILITY,
                    GameConstants.FROZEN, action.getCardAttacker(), action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        if (attacker.isWasUsed()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ABILITY,
                    GameConstants.ALREADY_ATTACKED, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de abilitatea unui erou
     *
     * @param hero eroul care foloseste abilitatea
     * @param mana mana disponibila pentru a folosi abilitatea
     * @param action actiunea care contine detalii despre utilizarea abilitatii
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleHeroAbilityError(final Hero hero, final int mana,
                                          final ActionsInput action) {
        if (hero.getMana() > mana) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.NOT_ENOUGH_MANA_HERO,
                    GameConstants.USE_HERO_ABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        if (hero.isWasUsed()) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ALREADY_ATTACKED_HERO,
                    GameConstants.USE_HERO_ABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de atacul unui erou
     *
     * @param attacker cardul (Minion) atacator
     * @param action actiunea care contine detalii despre atac
     * @param enemyIdx indexul inamicului
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleAttackHeroError(final Minion attacker, final ActionsInput action,
                                         final int enemyIdx) {
        if (attacker.isFrozen()) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.FROZEN,
                    GameConstants.USE_ATTACK_HERO, action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        if (attacker.isWasUsed()) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.ALREADY_ATTACKED,
                    GameConstants.USE_ATTACK_HERO, action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }

        if (GameTable.getInstance().isThereATank(enemyIdx)) {
            ErrorAttackHero err = new ErrorAttackHero(GameConstants.NOT_TANK,
                    GameConstants.USE_ATTACK_HERO, action.getCardAttacker());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de atacul unui card asupra unui alt card
     * Vede da seataca pe el insusi
     *
     * @param playerIdx indexul jucatorului
     * @param attackedRowIdx indexul randului atacat
     * @param action actiunea care contine detalii despre atac
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleSelfCardAttack(final int playerIdx, final int attackedRowIdx,
                                        final ActionsInput action) {
        if (!isEnemyCard(playerIdx, attackedRowIdx)) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ATTACK,
                    GameConstants.NOT_BELONG_TO_ENEMY, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de atacul unui card (Minion) asupra altui card (Minion)
     *
     * @param attacker cardul (Minion) atacator
     * @param attacked cardul (Minion) atacat
     * @param action actiunea care contine detalii despre atac
     * @param areThereTanks indica daca exista carduri de tip tank in joc
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleCardAttackError(final Minion attacker, final Minion attacked,
                                         final ActionsInput action, final boolean areThereTanks) {
        if (attacker.isWasUsed()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ATTACK,
                    GameConstants.ALREADY_ATTACKED, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        if (attacker.isFrozen()) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ATTACK,
                    GameConstants.FROZEN, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }

        if (!attacked.isTank() && areThereTanks) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ATTACK,
                    GameConstants.NOT_TANK, action.getCardAttacker(), action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de plasarea unui card pe tabla
     *
     * @param p jucatorul care plaseaza cardul
     * @param m cardul (Minion) care este plasat
     * @param handIdx indexul cardului in mana
     * @param playerIdx indexul jucatorului care plaseaza cardul
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handlePlaceCardError(final Player p, final Minion m, final int handIdx,
                                        final int playerIdx) {
        if (p.getMana() < m.getMana()) {
            ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACE_CARD, handIdx,
                    GameConstants.NOT_ENOUGH_MANA_TABLE);
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        if (m.isFront()) {
            if (GameTable.getInstance().getPlayerFrontRow()[playerIdx].size()
                    >= GameConstants.MAX_COLUMN_SIZE) {
                ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACE_CARD, handIdx,
                        GameConstants.FULL_TABLE);
                JsonOutManager.getInstance().addToOutput(stats);
                return true;
            }
        } else {
            if (GameTable.getInstance().getPlayerBackRow()[playerIdx].size()
                    >= GameConstants.MAX_COLUMN_SIZE) {
                ErrorCardTable stats = new ErrorCardTable(GameConstants.PLACE_CARD, handIdx,
                        GameConstants.FULL_TABLE);
                JsonOutManager.getInstance().addToOutput(stats);
                return true;
            }
        }
        return false;
    }
    /**
     * Gestioneaza erorile legate de abilitatea unui card (Minion) asupra unui alt card (Minion)
     * de tip tank
     * Vede daca cartea ataca dusmanul si daca acesta are cumva un tank, iar cartea aleasa de pe
     * randurile dusmanului nu e tank
     * @param action actiunea care contine detalii despre utilizarea abilitatii
     * @param playerIdx indexul jucatorului
     * @param attacked cardul (Minion) atacat
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleCardAbilityTankSelf(final ActionsInput action, final int playerIdx,
                                             final Minion attacked) {
        if (!isEnemyCard(playerIdx, action.getCardAttacked().getX())) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ABILITY,
                    GameConstants.NOT_BELONG_TO_ENEMY, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        if (!attacked.isTank() && GameTable.getInstance().isThereATank((playerIdx + 1) % 2)) {
            ErrorCardAttack err = new ErrorCardAttack(GameConstants.CARD_USES_ABILITY,
                    GameConstants.NOT_TANK, action.getCardAttacker(), action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        return false;
    }
    /**
     * Vede daca foloseste abilitatea pe o carte proprie
     *
     * @param playerIdx indexul jucatorului
     * @param action actiunea care contine detalii despre utilizarea abilitatii
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleCardAbilityEnemyCheck(final int playerIdx, final ActionsInput action) {
        if (isEnemyCard(playerIdx, action.getCardAttacked().getX())) {
            ErrorCardAttack stats = new ErrorCardAttack(GameConstants.CARD_USES_ABILITY,
                    GameConstants.NOT_BELONG_TO_CURRENT, action.getCardAttacker(),
                    action.getCardAttacked());
            JsonOutManager.getInstance().addToOutput(stats);
            return true;
        }
        return false;
    }
    /**
     * Vede daca foloseste abilitatea pe o carte propie
     *
     * @param action actiunea care contine detalii despre utilizarea abilitatii
     * @param playerIdx indexul jucatorului
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleSelfAbilityHero(final ActionsInput action, final int playerIdx) {
        if (!isEnemyCard(playerIdx, action.getAffectedRow())) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ROW_NOT_BELONG_TO_ENEMY,
                    GameConstants.USE_HERO_ABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        return false;
    }
    /**
     * Vede daca ataca o carte inamica deoarece acesta trebuie sa actioneze asupra carudilor sale
     *
     * @param action actiunea care contine detalii despre utilizarea abilitatii
     * @param playerIdx indexul jucatorului
     * @return true daca s-a detectat o eroare, false altfel
     */
    public boolean handleAbilityHeroEnemyCheck(final ActionsInput action, final int playerIdx) {
        if (isEnemyCard(playerIdx, action.getAffectedRow())) {
            ErrorHeroAbility err = new ErrorHeroAbility(GameConstants.ROW_NOT_BELONG_TO_CURRENT,
                    GameConstants.USE_HERO_ABILITY, action.getAffectedRow());
            JsonOutManager.getInstance().addToOutput(err);
            return true;
        }
        return false;
    }
}
