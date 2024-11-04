package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import fileio.CardInput;
import game.Game;
import game.GameTable;
import utils.CardManager;
public class Miraj extends Minion {
    /**
     *
     * @param input
     */
    public Miraj(final CardInput input) {
        CardManager.fromInputToObject(this, input);
        this.setAttackDamage(input.getAttackDamage());
    }

    /**
     *
     * @param game reprezinta jocul in sine deoarce am nevoie de anumite atribute din acel obiect
     * @param action in special pentru input si pentru datele de afisare
     * @param error aici ma ocup de erorile ce pot aparea si le pun in out
     */
    @Override
    public void useAbility(final Game game, final ActionsInput action, final ErrorManger error) {
        Minion attacked = GameTable.getInstance().getCardTable(action.getCardAttacked().getX(),
                action.getCardAttacked().getY());
        if (error.handleCardAbilityTankSelf(action, game.getPlayerIdxTurn(), attacked)) {
            return;
        }
        this.setWasUsed(true);
        int temp = this.getHealth();
        this.setHealth(attacked.getHealth());
        attacked.setHealth(temp);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isTank() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFront() {
        return true;
    }
}

