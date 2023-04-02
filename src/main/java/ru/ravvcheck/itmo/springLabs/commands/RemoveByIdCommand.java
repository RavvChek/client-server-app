package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(LinkedListCollection database) {
        super("remove", "Удалить элемент из коллекции по его id", database);
    }

    @Override
    public void execute() {

    }
}
