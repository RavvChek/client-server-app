package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class InfoCommand extends AbstractCommand{
    public InfoCommand(Supervisor supervisor) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", supervisor);
    }

    @Override
    public void execute(String args) {
        this.supervisor.getDatabase().infoData();
    }
}
