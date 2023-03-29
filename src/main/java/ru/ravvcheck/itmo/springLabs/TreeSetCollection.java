package ru.ravvcheck.itmo.springLabs;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.util.Date;
import java.util.TreeSet;

public class TreeSetCollection {
    private final DataReader dataReader;
    private final TreeSet<SpaceMarine> data;
    private final String type;
    private final Date date;
    private int count;

    public TreeSetCollection(DataReader dataReader) {
        this.dataReader = dataReader;
        data = dataReader.getData();
        type = SpaceMarine.class.getName();
        date = new Date();
    }

    public TreeSet<SpaceMarine> getCollection(){
        return data;


    }
}
