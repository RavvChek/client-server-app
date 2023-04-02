package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(LinkedListCollection database) {
        super("exit", "Завершить программу (без сохранения в файл)", database);
    }

    @Override
    public void execute() {

    }
}
