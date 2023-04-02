package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class AddCommand extends AbstractCommand {
    public AddCommand(LinkedListCollection database) {
        super("add", "Добавить новый элемент в коллекцию", database);
    }

    @Override
    public void execute() {
        System.out.println("");
    }
}
