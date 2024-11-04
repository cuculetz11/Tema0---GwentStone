package error;

public class ErrorCardTable extends Error {
    private int handIdx;

    public ErrorCardTable(final String command, final int handIdx, final String error) {
        super(error, command);
        this.handIdx = handIdx;

    }

    /**
     * Obtine indexul cartii din mana
     * @return
     */
    public int getHandIdx() {
        return handIdx;
    }

    /**
     * Seteaza indexul cartii din mana
     * @param handIdx
     */
    public void setHandIdx(final int handIdx) {
        this.handIdx = handIdx;
    }
}
