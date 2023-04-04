package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class HelpCommand extends AbstractCommand{
    public HelpCommand(Supervisor supervisor) {
        super("help", "Вывести справку по доступным командам", supervisor);
    }

    @Override
    public void execute() {

    }
}
