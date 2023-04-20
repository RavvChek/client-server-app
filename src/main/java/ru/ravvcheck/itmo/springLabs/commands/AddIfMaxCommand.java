package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineBuild;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;


public class AddIfMaxCommand extends AbstractCommand {
    public AddIfMaxCommand(Supervisor supervisor) {
        super("add_if_max", "Добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции", supervisor);
    }

    @Override
    public void execute(String args) throws Exception {
        SpaceMarineBuild spaceMarineBuild = new SpaceMarineBuild();
        SpaceMarine sp = spaceMarineBuild.build();
        if (supervisor.getCollection().getLast().compareTo(sp) < 0) {
            supervisor.getDatabase().addItem(sp);
        }
    }
}
