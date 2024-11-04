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
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * Seteaza numele erorii
     * @param error
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * Obtine numele comenzii unde s-a pertecut eroarea
     * @return
     */
    public String getCommand() {
        return command;
    }

    /**
     * Seteaza numele comenzii
     * @param command
     */
    public void setCommand(final String command) {
        this.command = command;
    }
}
