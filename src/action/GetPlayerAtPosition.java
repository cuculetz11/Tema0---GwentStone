package action;

import cards.Minion;
import debug.DebugCardAtPosition;
import debug.DebugCardAtPositionErr;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;
import utils.GameConstants;
import utils.JsonOutManager;

public class GetPlayerAtPosition implements CommandAction {
    /**
     * Afiseaza cartea la o pozitie specificata
     *
     * @param action actiunea care contine coordonatele cartii
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        int x = action.getX();
        int y = action.getY();
        Minion card = GameTable.getInstance().getCardTable(x, y);
        if (card == null) {
            DebugCardAtPositionErr stats = new DebugCardAtPositionErr(
                    GameConstants.GET_CARD_AT_POSITION, x, y, GameConstants.NO_CARD_AT_POS);
            JsonOutManager.getInstance().addToOutput(stats);
        } else {
            DebugCardAtPosition stats = new DebugCardAtPosition(
                    GameConstants.GET_CARD_AT_POSITION, x, y, card);
            JsonOutManager.getInstance().addToOutput(stats);
        }
    }
}
