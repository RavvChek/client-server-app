package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AverageOfHealthCommand extends AbstractCommand {
    public AverageOfHealthCommand(Supervisor supervisor) {
        super("average_of_health", "Вывести среднее значение поля heartCount для всех элементов коллекции", supervisor);
    }

    @Override
    public void execute() {

    }
}
