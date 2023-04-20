package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(Supervisor supervisor) {
        super("clear", "Очистить коллекцию", supervisor);
    }

    @Override
    public void execute(String args) {
        this.supervisor.getDatabase().clearData();
        System.out.println("Коллекция очищена");
    }
}
