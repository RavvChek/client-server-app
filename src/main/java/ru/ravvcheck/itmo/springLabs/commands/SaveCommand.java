package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(Supervisor supervisor) {
        super("save", "Сохранить коллекцию в файл", supervisor);
    }

    @Override
    public void execute(String args) {
        try{
            this.supervisor.getDatabase().saveData();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
