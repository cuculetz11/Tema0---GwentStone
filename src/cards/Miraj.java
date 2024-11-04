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
     * Aceasta metoda este suprascrisa de fiecare carte in parte
     * acest polimorfism ma ajuta sa nu rescriu pentru ficare carte un cod asemanator
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
     * Ne arata daca cartea este de tipul 'Tank'
     *
     * @return true daca cartea e tank; false altfel
     */
    @Override
    public boolean isTank() {
        return false;
    }

    /**
     * Ne spune daca cartea este pe randul din fata al playerului
     * @return true daca e; false altfel
     */
    @Override
    public boolean isFront() {
        return true;
    }
}

