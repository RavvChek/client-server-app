package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.util.List;
import java.util.Scanner;

public abstract class AbstractParser {
    public abstract SpaceMarine reading(String line, Scanner scanner, List<String> keys);
}
