package debug;

import cards.Minion;
import game.GameTable;
import utils.GameConstants;

import java.util.ArrayList;

public final  class GetAllMinionRowsForDebug {
    /**
     * Obtinem toate randurile de pe masa
     * @return randurile de pe masa
     */
    public static ArrayList<Minion>[] getAllMinionRows() {
        ArrayList<Minion>[] playerBackRow = GameTable.getInstance().getPlayerBackRow();
        ArrayList<Minion>[] playerFrontRow = GameTable.getInstance().getPlayerFrontRow();

        ArrayList<Minion>[] allTable = new ArrayList[GameConstants.MAX_ROW_SIZE];
        allTable[0] = playerBackRow[1];
        allTable[1] = playerFrontRow[1];
        allTable[2] = playerFrontRow[0];
        allTable[GameConstants.LAST_ROW] = playerBackRow[0];

        return allTable;
    }
    private GetAllMinionRowsForDebug() {
    }
}
