package action;

import cards.Minion;
import debug.DebugCardsTable;
import debug.GetAllMinionRowsForDebug;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

import java.util.ArrayList;

public class ShowCardsTable implements  CommandAction {
    /**
     * Afiseaza cartile de pe masa
     */
    public void execute(final Game game, final ActionsInput action) {
        ArrayList<Minion>[] allTable = GetAllMinionRowsForDebug.getAllMinionRows();
        DebugCardsTable stats = new DebugCardsTable(GameConstants.GET_CARDS_ON_TABLE, allTable);
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
