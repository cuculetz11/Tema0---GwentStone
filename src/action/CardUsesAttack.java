package action;


import cards.Minion;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;

import java.util.ArrayList;

public class CardUsesAttack implements  CommandAction {
    /**
     * Prin aceasta metoda se executa comanda in care o carte isi foloseste atacul
     * @param game instanta jocului actual
     * @param action avtiunea data ca input
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        int playerIdx = game.getPlayerIdxTurn();
        int attackedRowIdx = action.getCardAttacked().getX();
        if (CommandAction.errorManager.handleSelfCardAttack(playerIdx, attackedRowIdx, action)) {
            return;
        }
        Minion attacker = GameTable.getInstance().getRowFromTable(action.getCardAttacker().getX(),
                playerIdx).get(action.getCardAttacker().getY());
        ArrayList<Minion> attackedRow = GameTable.getInstance().getRowFromTable(
                action.getCardAttacked().getX(), (playerIdx + 1) % 2);
        Minion attacked = attackedRow.get(action.getCardAttacked().getY());
        boolean tank = GameTable.getInstance().isThereATank(((game.getPlayerIdxTurn()) + 1) % 2);
        if (CommandAction.errorManager.handleCardAttackError(attacker, attacked, action, tank)) {
            return;
        }
        attacker.setWasUsed(true);
        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage());
        if (attacked.getHealth() <= 0) {
            attackedRow.remove(action.getCardAttacked().getY());
        }
    }
}
