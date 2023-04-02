package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class HelpCommand extends AbstractCommand{
    public HelpCommand(LinkedListCollection database) {
        super("help", "Вывести справку по доступным командам", database);
    }

    @Override
    public void execute() {

    }
}
