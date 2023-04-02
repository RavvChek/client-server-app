package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class AddIfMaxCommand extends AbstractCommand{
    public AddIfMaxCommand(LinkedListCollection database) {
        super("add_if_max", "Добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции", database);
    }

    @Override
    public void execute() {

    }
}
