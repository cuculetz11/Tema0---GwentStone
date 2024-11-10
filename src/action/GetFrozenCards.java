package action;

import cards.Minion;
import debug.DebugFrozenCards;
import debug.GetAllMinionRowsForDebug;
import fileio.ActionsInput;
import game.Game;
import utils.GameConstants;
import utils.JsonOutManager;

import java.util.ArrayList;

public class GetFrozenCards implements CommandAction {
    /**
     * Afiseaza cartile ce sunt inghetate
     */
    @Override
    public void execute(final Game game, final ActionsInput action) {
        ArrayList<Minion> frozenMinions = new ArrayList<>();
        ArrayList<Minion>[] allTable = GetAllMinionRowsForDebug.getAllMinionRows();
        for (int i = 0; i <= GameConstants.LAST_ROW; i++) {
            for (Minion minion : allTable[i]) {
                if (minion.isFrozen()) {
                    frozenMinions.add(minion);
                }
            }
        }
        DebugFrozenCards stats = new DebugFrozenCards(GameConstants.GET_FROZEN_CARDS_ON_TABLE,
                frozenMinions);
        JsonOutManager.getInstance().addToOutput(stats);
    }
}
