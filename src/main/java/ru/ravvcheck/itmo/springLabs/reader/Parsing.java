package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.util.Scanner;

public interface Parsing {
    public SpaceMarine reading(String line, Scanner scanner, String[] keys) throws Exception;
}
