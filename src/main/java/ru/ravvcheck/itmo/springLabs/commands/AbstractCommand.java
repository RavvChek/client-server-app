package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public abstract class AbstractCommand implements Command {

    protected final Supervisor supervisor;
    protected final String name;
    protected final String description;

    AbstractCommand(String name, String description, Supervisor supervisor) {
        this.supervisor = supervisor;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public abstract void execute();
}
