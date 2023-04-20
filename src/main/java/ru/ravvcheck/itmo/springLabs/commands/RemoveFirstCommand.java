package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class RemoveFirstCommand extends AbstractCommand{
    public RemoveFirstCommand(Supervisor supervisor) {
        super("remove_first", "Удалить первый элемент из коллекции", supervisor);
    }

    @Override
    public void execute(String args) {
        supervisor.getDatabase().removeFirstItem();
    }
}
