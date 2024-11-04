package error;

public class ErrorHeroAbility extends Error {
    private int affectedRow;

    public ErrorHeroAbility(final String error, final String command, final int affectedRow) {
        super(error, command);
        this.affectedRow = affectedRow;
    }

    /**
     * Obtine indexul randului afectat
     * @return indexul randului afectat
     */
    public int getAffectedRow() {
        return affectedRow;
    }

    /**
     * Seteaza indexul randului afectat
     * @param affectedRow indexul randului afectat
     */
    public void setAffectedRow(final int affectedRow) {
        this.affectedRow = affectedRow;
    }
}
