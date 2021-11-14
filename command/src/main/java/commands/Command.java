package commands;

public interface Command {
    boolean execute(String argument);
    boolean execute();
    boolean execute(String argument, Object oArgument);
}
