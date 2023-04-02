package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class InfoCommand extends AbstractCommand{
    public InfoCommand(LinkedListCollection database) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", database);
    }

    @Override
    public void execute() {

    }
}
