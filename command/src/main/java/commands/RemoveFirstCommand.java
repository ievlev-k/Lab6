package commands;

import core.CollectionManager;
import core.ResponseOutput;

public class RemoveFirstCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        if (collectionManager.size() == 0) {
            ResponseOutput.appendln("Коллукция пуста");
        } else {
            collectionManager.listCity.removeFirst();
            ResponseOutput.appendln("Первый элемент удален");
        }
        return true;
    }
}