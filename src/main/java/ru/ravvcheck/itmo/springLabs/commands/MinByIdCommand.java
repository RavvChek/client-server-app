package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class MinByIdCommand extends AbstractCommand{
    public MinByIdCommand(Supervisor supervisor) {
        super("min_by_id", "Вывести любой объект из коллекции, значение поля id которого является минимальным", supervisor);
    }

    @Override
    public void execute() {

    }
}
