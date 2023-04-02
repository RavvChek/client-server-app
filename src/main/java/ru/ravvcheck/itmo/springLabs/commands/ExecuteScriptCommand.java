package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(LinkedListCollection database) {
        super("execute_script", "Считать и исполнить скрипт из указанного файла.", database);
    }

    @Override
    public void execute() {

    }
}
