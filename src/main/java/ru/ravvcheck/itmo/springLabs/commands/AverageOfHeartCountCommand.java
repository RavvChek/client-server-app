package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AverageOfHeartCountCommand extends AbstractCommand {
    public AverageOfHeartCountCommand(Supervisor supervisor) {
        super("average_of_heart_count", "Вывести среднее значение поля heartCount для всех элементов коллекции", supervisor);
    }

    @Override
    public void execute(String args) {
        this.supervisor.getDatabase().averageOfHeartCount();
    }
}
