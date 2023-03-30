package ru.ravvcheck.itmo.springLabs.commands;

public class AddCommand extends AbstractCommand {
    public AddCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("");
    }
}
