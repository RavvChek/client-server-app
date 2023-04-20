package ru.ravvcheck.itmo.springLabs.supervisor;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.commands.*;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Supervisor implements Supervising {
    private static Scanner scanner;
    private final LinkedListCollection database;
    private final HashMap<String, Command> commandMap;
    private boolean active;
    private Scanner fileScanner;

    public Supervisor(DataReader reader) throws Exception {
        this.database = new LinkedListCollection(reader);
        scanner = new Scanner(System.in);
        this.commandMap = new HashMap<>();
        commandMap.put("add", new AddCommand(this));
        commandMap.put("add_if_max", new AddIfMaxCommand(this));
        commandMap.put("add_if_min", new AddIfMinCommand(this));
        commandMap.put("average_of_health", new AverageOfHealthCommand(this));
        commandMap.put("clear", new ClearCommand(this));
        commandMap.put("execute_script", new ExecuteScriptCommand(this));
        commandMap.put("exit", new ExitCommand(this));
        commandMap.put("group_count_by_name", new GroupCountingByNameCommand(this));
        commandMap.put("help", new HelpCommand(this));
        commandMap.put("info", new InfoCommand(this));
        commandMap.put("min_by_id", new MinByIdCommand(this));
        commandMap.put("remove_by_id", new RemoveByIdCommand(this));
        commandMap.put("remove_first", new RemoveFirstCommand(this));
        commandMap.put("save", new SaveCommand(this));
        commandMap.put("show", new ShowCommand(this));
        commandMap.put("update", new UpdateCommand(this));
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public LinkedList<SpaceMarine> getCollection() {
        return database.getData();
    }

    public LinkedListCollection getDatabase() {
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
        System.out.print(">>> ");
        try {
            if (!scanner.hasNext()) throw new MustExit();
            String userCommand = scanner.nextLine().trim();
            this.start(userCommand.split(" ", 2));
        } catch (NoSuchElementException e) {
            console.printError("Пользовательский ввод не обнаружен.");
        } catch (IllegalArgument e) {
            console.printError("Введены неправильные аргументы команды.");
        } catch (NoCommand e) {
            console.printError("Такой команды не существует.");
        } catch (CommandRuntime e) {
            console.printError("Ошибка при исполнении команды.");
        } catch (MustExit e) {
            console.printError("Выход из программы. Bye!");
            return;
        }
    }

    public void start(String[] userCommand) throws IllegalArgument, NoCommand, CommandRuntime, MustExit {
        if (userCommand[0].equals("")) return;
        Command command = commandMap.get(userCommand[0]);
        if (userCommand.length < 2)
            command.execute("");
        else
            command.execute(userCommand[1]);
    }
}
