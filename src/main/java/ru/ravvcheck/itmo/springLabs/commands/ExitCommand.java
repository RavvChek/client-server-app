package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(Supervisor supervisor) {
        super("exit", "Завершить программу (без сохранения в файл)", supervisor);
    }

    @Override
    public void execute() {
        this.supervisor.stop();
    }
}
