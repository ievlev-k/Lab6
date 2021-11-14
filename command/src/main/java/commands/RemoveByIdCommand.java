package commands;

import core.CollectionManager;
import core.CommandAsker;
import core.InputChecker;
import core.ResponseOutput;

public class RemoveByIdCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;


    public RemoveByIdCommand(CollectionManager cm, InputChecker ic, CommandAsker ca) {
        this.collectionManager = cm;
        this.inputChecker = ic;
        this.commandAsker = ca;

    }

    @Override
    public boolean execute(String sArgument, Object oArgument) {

            long id = Long.parseLong(sArgument);
            if (!collectionManager.removeByID(id)) {
                ResponseOutput.appendln("Такого Id нет");
                return true;
            }
            ResponseOutput.appendln("City с Id = " + id + " успешно удален");
            return true;


    }


}
