package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.util.LinkedList;

public abstract class DataReader {
    public abstract LinkedList<SpaceMarine> getData();
}
