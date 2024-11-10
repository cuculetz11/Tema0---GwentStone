package action;

import error.ErrorManger;
import fileio.ActionsInput;
import game.Game;

public interface CommandAction {
    ErrorManger errorManager = new ErrorManger();

    /**
     * Aceasta metoda este suprascrisa de fiecare actiune in parte
     */
    void execute(Game game, ActionsInput actions);
}
