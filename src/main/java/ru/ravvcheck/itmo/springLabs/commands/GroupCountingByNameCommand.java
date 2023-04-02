package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class GroupCountingByNameCommand extends AbstractCommand{
    public GroupCountingByNameCommand(LinkedListCollection database) {
        super("group_counting_by_name", "Cгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе", database);
    }

    @Override
    public void execute() {

    }
}
