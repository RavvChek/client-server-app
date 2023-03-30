package ru.ravvcheck.itmo.springLabs.commands;

import java.util.TreeSet;

public abstract class AbstractCommand implements Command{
    private final String name;
    private final String description;
    AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

}
