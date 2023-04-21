package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(Supervisor supervisor) {
        super("execute_script", "Считать и исполнить скрипт из указанного файла.", supervisor);
    }

    @Override
    public void execute(String args) {
        supervisor.executeScript(args);
    }
}
