package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class GroupCountingByNameCommand extends AbstractCommand{
    public GroupCountingByNameCommand(Supervisor supervisor) {
        super("group_counting_by_name", "Cгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе", supervisor);
    }

    @Override
    public void execute(String args) {
        supervisor.getDatabase().groupCountingByName();
    }
}
