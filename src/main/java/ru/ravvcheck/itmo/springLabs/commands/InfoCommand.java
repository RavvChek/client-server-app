package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class InfoCommand extends AbstractCommand{
    public InfoCommand(Supervisor supervisor) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", supervisor);
    }

    @Override
    public void execute() {
        System.out.println("Тип: " + this.supervisor.getDatabase().getType());
        System.out.println("Дата инициализации: " + this.supervisor.getDatabase().getDate().toString());
        System.out.println("Количество элементов: " + this.supervisor.getDatabase().getCount());
    }
}
