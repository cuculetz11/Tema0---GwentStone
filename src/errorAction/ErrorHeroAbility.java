package errorAction;

public class ErrorHeroAbility extends Error{
    private int affectedRow;

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }

    public ErrorHeroAbility(String error, String command, int affectedRow) {
        super(error, command);
        this.affectedRow = affectedRow;
    }
}
