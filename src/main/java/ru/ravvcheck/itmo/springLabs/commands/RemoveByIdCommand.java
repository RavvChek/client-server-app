package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(Supervisor supervisor) {
        super("remove", "Удалить элемент из коллекции по его id", supervisor);
    }

    @Override
    public void execute(String args) {
        int id = Integer.parseInt(args);
        supervisor.getDatabase().removeByIdItem(id);
    }
}
