package ru.ravvcheck.itmo.springLabs;

import ru.ravvcheck.itmo.springLabs.reader.DataReader;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervising;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class Main {
    public static void main(String[] args) {
        var reader = new DataReader();
        var supervisor = new Supervisor(reader);
    }
}