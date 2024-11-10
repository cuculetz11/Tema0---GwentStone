package action;

import cards.Hero;
import cards.Minion;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;

public class UseAttackHero implements CommandAction {
    /**
     * Prin aceasta metoda cartea selectata ataca eroul inamicului
     */
    public void execute(final Game game, final ActionsInput action) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),
                action.getCardAttacker().getY());
        int enemyIdx = (game.getPlayerIdxTurn() + 1) % 2;
        if (CommandAction.errorManager.handleAttackHeroError(attacker, action, enemyIdx)) {
            return;
        }
        attacker.setWasUsed(true);
        Hero enemyHero = game.getPlayer()[(game.getPlayerIdxTurn() + 1) % 2].getHero();
        enemyHero.setHealth(enemyHero.getHealth() - attacker.getAttackDamage());

    }
}

