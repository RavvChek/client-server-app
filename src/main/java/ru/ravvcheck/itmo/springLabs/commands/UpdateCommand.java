package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class UpdateCommand extends AbstractCommand{
    public UpdateCommand(Supervisor supervisor) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному", supervisor);
    }

    @Override
    public void execute(String args) {

    }
}
