package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;

public abstract class AbstractCommand implements Command{
    private final String name;
    private final String description;
    private LinkedListCollection database;
    AbstractCommand(String name, String description, LinkedListCollection database){
        this.name = name;
        this.description = description;
        this.database = database;
    }
}
