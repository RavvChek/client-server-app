package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class UpdateCommand extends AbstractCommand{
    public UpdateCommand(LinkedListCollection database) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному", database);
    }

    @Override
    public void execute() {

    }
}
