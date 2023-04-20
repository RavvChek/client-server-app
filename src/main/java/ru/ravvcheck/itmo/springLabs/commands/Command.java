package ru.ravvcheck.itmo.springLabs.commands;

public interface Command {
    public void execute(String args) throws Exception;
}
