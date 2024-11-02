package errorAction;

public class ErrorCardTable extends Error {
    private int handIdx;

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public ErrorCardTable(String command, int handIdx, String error) {
        super(error, command);
        this.handIdx = handIdx;

    }
}
