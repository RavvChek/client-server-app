package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.LinkedList;


public class AddIfMaxCommand extends AbstractCommand {
    public AddIfMaxCommand(Supervisor supervisor) {
        super("add_if_max", "Добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции", supervisor);
    }

    @Override
    public void execute() {
        LinkedList<SpaceMarine> list = supervisor.getCollection();
    }
}
