package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class MinByIdCommand extends AbstractCommand{
    public MinByIdCommand(LinkedListCollection database) {
        super("min_by_id", "Вывести любой объект из коллекции, значение поля id которого является минимальным", database);
    }

    @Override
    public void execute() {

    }
}
