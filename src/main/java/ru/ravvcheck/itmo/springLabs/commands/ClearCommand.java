package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(LinkedListCollection database) {
        super("clear", "Очистить коллекцию", database);
    }

    @Override
    public void execute() {

    }
}
