package action;

import cards.Minion;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;

public class CardUseAbility implements CommandAction {
    /**
     * Prin aceasta metoda se executa comada in care cartea isi executa abilitatea
     * @param game reprezinta instanta jocului
     * @param action actiune data ca input
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        Minion attacker = GameTable.getInstance().getCardTable(action.getCardAttacker().getX(),
                action.getCardAttacker().getY());
        if (CommandAction.errorManager.handleCardAbilityError(attacker, action)) {
            return;
        }
        attacker.useAbility(game, action, CommandAction.errorManager);
    }
}
