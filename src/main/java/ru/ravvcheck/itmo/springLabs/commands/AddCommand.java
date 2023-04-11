package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AddCommand extends AbstractCommand {
    public AddCommand(Supervisor supervisor) {
        super("add", "Добавить новый элемент в коллекцию", supervisor);
    }

    @Override
    public void execute() {
        System.out.println("");
    }
}
