package errorAction;

public abstract class Error {
    private String error;
    private String command;
    public Error(String error, String command) {
        this.error = error;
        this.command = command;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
