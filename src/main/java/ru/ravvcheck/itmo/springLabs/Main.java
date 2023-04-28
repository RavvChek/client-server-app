package ru.ravvcheck.itmo.springLabs;


import ru.ravvcheck.itmo.springLabs.reader.FileReader;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length <= 0){
            System.out.println("Передайте единственное значение аргументов - название файла");
            System.exit(0);
        }
        var reader = new FileReader(args[0]);
        var supervisor = new Supervisor(reader);
        supervisor.run();
    }
}