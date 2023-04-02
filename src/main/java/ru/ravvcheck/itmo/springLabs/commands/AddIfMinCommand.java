package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class AddIfMinCommand extends AbstractCommand{
    public AddIfMinCommand(LinkedListCollection database) {
        super("add_if_min", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", database);
    }

    @Override
    public void execute() {

    }
}
