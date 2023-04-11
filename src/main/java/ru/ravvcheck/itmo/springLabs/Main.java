package ru.ravvcheck.itmo.springLabs;


import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineStringForm;
import ru.ravvcheck.itmo.springLabs.model.Coordinates;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.FileReader;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new FileReader("fffff.csv");
        var supervisor = new Supervisor(reader);
    }
}