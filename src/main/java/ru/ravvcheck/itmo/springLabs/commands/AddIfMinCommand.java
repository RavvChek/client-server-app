package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineBuild;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class AddIfMinCommand extends AbstractCommand {
    public AddIfMinCommand(Supervisor supervisor) {
        super("add_if_min", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", supervisor);
    }

    @Override
    public void execute(String args) throws WrongValuesException {
        SpaceMarineBuild spaceMarineBuild = new SpaceMarineBuild();
        SpaceMarine sp = spaceMarineBuild.build();
        if (supervisor.getCollection().getFirst().compareTo(sp) > 0) {
            supervisor.getDatabase().addFirstItem(sp);
            System.out.println("Объект создан");
        }
        else{
            System.out.println("Значение объекта не меньше значения наименьшего элемента - объект не добавлен");

        }
    }
}
