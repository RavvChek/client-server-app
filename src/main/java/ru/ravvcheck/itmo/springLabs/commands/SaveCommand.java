package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(LinkedListCollection database) {
        super("save", "Сохранить коллекцию в файл", database);
    }

    @Override
    public void execute() {

    }
}
