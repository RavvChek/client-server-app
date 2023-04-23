package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;

public interface Command {
    public void execute(String args) throws WrongValuesException;
}
