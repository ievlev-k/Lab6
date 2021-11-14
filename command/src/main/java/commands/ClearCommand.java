package commands;

import core.CollectionManager;
import core.ResponseOutput;

public class ClearCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        collectionManager.clear();
        ResponseOutput.appendln("Коллекция отчистилась");
        return true;
    }
}
