package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(Supervisor supervisor) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении", supervisor);
    }

    @Override
    public void execute(String args) {
        this.supervisor.getDatabase().show();
    }
}
