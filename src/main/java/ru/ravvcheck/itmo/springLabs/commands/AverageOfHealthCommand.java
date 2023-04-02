package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class AverageOfHealthCommand extends AbstractCommand {
    public AverageOfHealthCommand(LinkedListCollection database) {
        super("average_of_health", "Вывести среднее значение поля heartCount для всех элементов коллекции", database);
    }

    @Override
    public void execute() {

    }
}
