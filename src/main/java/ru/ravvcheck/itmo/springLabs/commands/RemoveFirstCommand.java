package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class RemoveFirstCommand extends AbstractCommand{
    public RemoveFirstCommand(LinkedListCollection database) {
        super("remove_first", "Удалить первый элемент из коллекции", database);
    }

    @Override
    public void execute() {

    }
}
