package error;

public abstract class Error {
    private String error;
    private String command;

    public Error(final String error, final String command) {
        this.error = error;
        this.command = command;
    }

    /**
     * Obtine numele erorii
     * @return numele erorii
     */
    public String getError() {
        return error;
    }

    /**
     * Seteaza numele erorii
     * @param error numele erorii
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * Obtine numele comenzii unde s-a pertecut eroarea
     * @return numele comenzii unde a avut loc eroarea
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza numele comenzii
     * @param command numele coemnzii unde a avut loc eroarea
     */
    public void setCommand(final String command) {
        this.command = command;
    }
}
