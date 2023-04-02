package ru.ravvcheck.itmo.springLabs.supervisor;

import ru.ravvcheck.itmo.springLabs.commands.Command;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.util.ArrayList;
import java.util.Scanner;

public class Supervisor {
    private ArrayList<Command> commandList;
    private Scanner scanner;
    Supervisor(DataReader reader){
        this.scanner = new Scanner(System.in);

    }
}
