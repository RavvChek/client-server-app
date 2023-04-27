package ru.ravvcheck.itmo.springLabs.supervisor;

import ru.ravvcheck.itmo.springLabs.LinkedListCollection;
import ru.ravvcheck.itmo.springLabs.commands.*;
import ru.ravvcheck.itmo.springLabs.exceptions.RecursionScriptException;
import ru.ravvcheck.itmo.springLabs.exceptions.WrongCommandException;
import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.io.File;
import java.io.FileNotFoundException;
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
        commandMap.put("average_of_heart_count", new AverageOfHeartCountCommand(this));
        commandMap.put("clear", new ClearCommand(this));
        commandMap.put("execute_script", new ExecuteScriptCommand(this));
        commandMap.put("exit", new ExitCommand(this));
        commandMap.put("group_counting_by_name", new GroupCountingByNameCommand(this));
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
    public void run() throws Exception {
        this.active = true;
        System.out.println("Добро пожаловать, Ярослав Кулинич!");
        while (active) {
            waitCommand();
        }
    }

    public HashMap<String, Command> getHashMapCommands() {
        return commandMap;
    }

    public Command getCommandByName(String name) {
        return commandMap.get(name);
    }

    @Override
    public void stop() {
        this.active = false;
    }

    @Override
    public void waitCommand() throws Exception {
        System.out.print(">>> ");
        try {
            //if (!scanner.hasNext()) throw new MustExit();
            String userCommand = scanner.nextLine().trim();
            this.start(userCommand.split(" ", 2));
        } catch (WrongCommandException e) {
            System.out.println(e.getMessage());
        }
        /*} catch (IllegalArgument e) {
            console.printError("Введены неправильные аргументы команды.");
        } catch (NoCommand e) {
            console.printError("Такой команды не существует.");
        } catch (CommandRuntime e) {
            console.printError("Ошибка при исполнении команды.");
        } catch (MustExit e) {
            console.printError("Выход из программы. Bye!");
            return;*/
        //}
    }

    public void start(String[] argsCommand) throws WrongCommandException, WrongValuesException {
        if (argsCommand[0].equals("")) return;
        Command command = commandMap.get(argsCommand[0].toLowerCase());
        if (command == null) {
            throw new WrongCommandException("Нет такой команды, введите команду help, чтобы увидеть список команд");
        }
        if (argsCommand.length < 2)
            command.execute("");
        else
            command.execute(argsCommand[1]);
    }

    public void executeScript(String fileName) {
        try (Scanner scrScanner = new Scanner(new File(fileName))) {
            if (!scrScanner.hasNext()) throw new NoSuchElementException();
            do {
                String userCmd = scrScanner.nextLine().trim() + " ";
                while (scrScanner.hasNextLine() && userCmd.split(" ", 2)[0].isEmpty()) {
                    userCmd = scrScanner.nextLine().trim() + " ";
                }
                if (userCmd.split(" ", 2)[0].equals("execute_script")) {
                    if (userCmd.split(" ", 2)[1].equals("execute_script")) {
                        throw new RecursionScriptException("Нельзя вывести скрипт рекурсивно");
                    }
                }
                start(userCmd.split(" ", 2));
            } while (scrScanner.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println();
        } catch (WrongCommandException e) {
            System.out.println(e.getMessage());
        } catch (RecursionScriptException e) {
            System.out.println(e.getMessage());
        /*} catch (CommandRuntime e) {
            console.printError("Ошибка при исполнении.");
        } catch (MustExit e) {
            console.printError("Выход из программы. Bye!");
        }*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}