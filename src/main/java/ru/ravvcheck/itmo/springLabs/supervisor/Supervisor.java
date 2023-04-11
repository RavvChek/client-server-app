package ru.ravvcheck.itmo.springLabs.supervisor;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.commands.*;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Supervisor implements Supervising {
    private final LinkedListCollection database;
    private static Scanner scanner;
    private List<Command> commandList;
    private boolean active;

    public Supervisor(DataReader reader) throws Exception {
        this.database = new LinkedListCollection(reader);
        scanner = new Scanner(System.in);
        this.commandList = new ArrayList<>();
        commandList.add(new AddCommand(this));
        commandList.add(new AddIfMaxCommand(this));
        commandList.add(new AddIfMinCommand(this));
        commandList.add(new AverageOfHealthCommand(this));
        commandList.add(new ClearCommand(this));
        commandList.add(new ExecuteScriptCommand(this));
        commandList.add(new ExitCommand(this));
        commandList.add(new GroupCountingByNameCommand(this));
        commandList.add(new HelpCommand(this));
        commandList.add(new InfoCommand(this));
        commandList.add(new MinByIdCommand(this));
        commandList.add(new RemoveByIdCommand(this));
        commandList.add(new RemoveFirstCommand(this));
        commandList.add(new SaveCommand(this));
        commandList.add(new ShowCommand(this));
        commandList.add(new UpdateCommand(this));
    }

    public static Scanner getScanner() {
        return scanner;
    }
    public LinkedList<SpaceMarine> getCollection() {
        return database.getData();
    }
    public LinkedListCollection getDatabase(){
        return database;
    }


    @Override
    public void run() {
        this.active = true;
        while (active) {
            waitCommand();
        }
    }

    @Override
    public void stop() {
        this.active = false;
    }

    @Override
    public void waitCommand() {
        System.out.print(">>>");
        AbstractCommand command = null;
        String commandName;

    }
}
