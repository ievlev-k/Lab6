package interaction;

import java.io.Serializable;

public class Request implements Serializable {
    private String commandName;
    private String commandStringArgument;
    private Object commandObjectArgument;


    public Request(String commandName, String commandStringArgument,Object commandObjectArgument){
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
        this.commandObjectArgument = commandObjectArgument;

    }
    public Request(String commandName, String commandStringArgument){
        this(commandName,commandStringArgument, null);


    }
    public Request() {
        this("", "");
    }

    public Object getCommandObjectArgument() {
        return commandObjectArgument;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getCommandStringArgument() {
        return commandStringArgument;
    }
    public boolean isEmpty() {
        return commandName.isEmpty() && commandStringArgument.isEmpty() && commandObjectArgument == null;
    }
}
