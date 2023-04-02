package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class ShowCommand extends AbstractCommand{
    public ShowCommand(LinkedListCollection database) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении", database);
    }

    @Override
    public void execute() {

    }
}
