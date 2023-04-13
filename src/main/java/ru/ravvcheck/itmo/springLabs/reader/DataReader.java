package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class DataReader {
    protected Parser parser;
    protected File file;
    protected Scanner scanner;
    protected String filePath;

    public abstract LinkedList<SpaceMarine> getData() throws Exception;
    public abstract void saveData(LinkedList<SpaceMarine> values) throws Exception;
}
