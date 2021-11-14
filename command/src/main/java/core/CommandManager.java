package core;
import commands.*;

public class CommandManager {

    private final Command helpCommand;
    private final Command addCommand;
    private final Command infoCommand;
    private final Command saveCommand;
    private final Command showCommand;

    private final Command removeFirstCommand;
    private final Command updateIdCommand;
    private final Command removeByIdCommand;
    private final Command clearCommand;
    private final Command exitCommand;
    private final Command removeGreaterCommand;
    private final Command removeLowerCommand;
    private final Command filterByStandardOfLivingCommand;
    private final Command filterGreaterThanGovernmentCommand;
    private final Command printAscendingCommand;
    private final Command executeScript;
    public CommandManager(Command helpCommand, Command saveCommand,
                          Command removeFirstCommand, Command removeLowerCommand,
                          Command removeGreaterCommand, Command filterByStandardOfLivingCommand, Command addCommand,
                          Command infoCommand, Command filterGreaterThanGovernmentCommand, Command showCommand, Command updateIdCommand,
                          Command removeByIdCommand, Command clearCommand, Command exitCommand, Command printAscendingCommand, Command executeScript) {
        this.helpCommand = helpCommand;
        this.saveCommand = saveCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.addCommand = addCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.filterByStandardOfLivingCommand = filterByStandardOfLivingCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.updateIdCommand = updateIdCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.exitCommand = exitCommand;
        this.filterGreaterThanGovernmentCommand = filterGreaterThanGovernmentCommand;
        this.printAscendingCommand = printAscendingCommand;
        this.executeScript = executeScript;
    }

    public boolean help() {
        return helpCommand.execute();
    }

    public boolean execute_script(String sArgument, Object oArgument){return executeScript.execute(sArgument, oArgument);}

    public boolean add(String sArgument, Object oArgument) {
        return addCommand.execute(sArgument, oArgument);
    }

    public boolean info() {
        return infoCommand.execute();
    }

    public boolean show() {
        return showCommand.execute();
    }



    public boolean remove_first(){
        return removeFirstCommand.execute();
    }

    public boolean update_id(String sArgument, Object oArgument) {
        return updateIdCommand.execute(sArgument, oArgument);
    }

    public boolean remove_by_id(String commandStringArgument,Object commandObjectArgument) {
        return removeByIdCommand.execute(commandStringArgument, commandObjectArgument);
    }

    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    public boolean clear() {
        return clearCommand.execute();
    }

    public boolean exit() {
        return exitCommand.execute();
    }

    public boolean remove_greater(String commandStringArgument,Object commandObjectArgument) {
        return removeGreaterCommand.execute(commandStringArgument, commandObjectArgument);
    }

    public boolean remove_lower(String commandStringArgument,Object commandObjectArgument) {
        return removeLowerCommand.execute(commandStringArgument, commandObjectArgument);
    }

    public boolean filter_by_standard_of_living(String commandStringArgument,Object commandObjectArgument) {
        return filterByStandardOfLivingCommand.execute(commandStringArgument, commandObjectArgument);
    }

    public boolean filter_greater_than_government(String commandStringArgument,Object commandObjectArgument) {
        return filterGreaterThanGovernmentCommand.execute(commandStringArgument, commandObjectArgument);
    }

    public boolean print_ascending(){
        return printAscendingCommand.execute();
    }
}

