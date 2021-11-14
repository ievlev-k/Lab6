package core;

import interaction.Request;
import interaction.Response;
import interaction.ResponseCode;

import java.util.HashMap;

public class ServerHandler {
    private CommandManager commandManager;
    private final HashMap<String, Boolean> inStack = new HashMap<>();
    private final String outputFile = "oFile";
    public ServerHandler(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public Response handle(Request request){
        ResponseCode responseCode = executeCommand(request.getCommandName(), request.getCommandStringArgument(), request.getCommandObjectArgument());

        return new Response(responseCode, ResponseOutput.getAndClear());
    }

    private ResponseCode executeCommand(String command, String commandStringArgument, Object commandObjectArgument){

            switch (command) {
                case "help":
                    if (!commandManager.help()) {
                        return ResponseCode.ERROR;
                    }
                    break;

                case "execute_script":
                    if (!commandManager.execute_script(commandStringArgument, commandObjectArgument)){
                        return ResponseCode.ERROR;
                    }
                    break;
                case "info":

                    if (!commandManager.info()) {
                        return ResponseCode.ERROR;
                    }
                    break;

                case "show":

                    if (!commandManager.show()) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "add":
                    if (!commandManager.add(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "clear":
                    if (!commandManager.clear()) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "update":

                    if (!commandManager.update_id(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "remove_by_id":

                    if (!commandManager.remove_by_id(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;


                case "exit":
                    if (!commandManager.exit()) {
                        return ResponseCode.ERROR;
                    }

                   return ResponseCode.SERVER_EXIT;
                case "remove_first":

                    if (!commandManager.remove_first()) {
                        return ResponseCode.ERROR;
                    }
                    break;

                case "remove_greater":

                    if (!commandManager.remove_greater(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "remove_lower":
                    if (!commandManager.remove_lower(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;
                case "filter_by_standard_of_living":

                    if(!commandManager.filter_by_standard_of_living(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;

                case "filter_greater_than_government":

                    if (!commandManager.filter_greater_than_government(commandStringArgument, commandObjectArgument)) {
                        return ResponseCode.ERROR;
                    }
                    break;

                case "print_ascending":
                    if (!commandManager.print_ascending()) {
                        return ResponseCode.ERROR;
                    }
                    break;

                default:
                    System.out.println("Такой команды нет!");
                    return ResponseCode.ERROR;
    }
    return ResponseCode.OK;


}

}
