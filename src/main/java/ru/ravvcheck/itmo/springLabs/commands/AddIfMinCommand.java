package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AddIfMinCommand extends AbstractCommand{
    public AddIfMinCommand(Supervisor supervisor) {
        super("add_if_min", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", supervisor);
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length > 2) {
                System.out.println("Вы неправильно ввели команду");
            } else {
                LinkedListCollection.AddIfMinCommand(args[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Недостаточно аргументов, обратитесь к команде help");
        }
    }
}
