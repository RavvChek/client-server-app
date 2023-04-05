package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(Supervisor supervisor) {
        super("save", "Сохранить коллекцию в файл", supervisor);
    }

    @Override
    public void execute() {
        this.supervisor.getDatabase().saveData();
    }
}
