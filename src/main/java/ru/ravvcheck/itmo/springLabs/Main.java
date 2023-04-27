package ru.ravvcheck.itmo.springLabs;


import ru.ravvcheck.itmo.springLabs.reader.FileReader;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        var reader = new FileReader(scanner.nextLine());
        var supervisor = new Supervisor(reader);
        supervisor.run();
    }
}