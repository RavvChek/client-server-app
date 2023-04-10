package ru.ravvcheck.itmo.springLabs;

import ch.ninecode.model.Person;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListCollection {
    private final DataReader dataReader;
    private final LinkedList<SpaceMarine> data;
    private final String type;
    private final Date date;
    private int count;

    public LinkedListCollection(DataReader dataReader) throws Exception {
        this.dataReader = dataReader;
        data = dataReader.getData();
        type = SpaceMarine.class.getName();
        date = new Date();
    }

    public static void AddIfMaxCommand(String arg) {
    }

    public static void AddIfMinCommand(String arg) {
    }

    public LinkedList<SpaceMarine> getData() {
        return data;
    }

    public Date getDate() {
        return date;
    }

    public int getCount() {
        count = data.size();
        return count;
    }

        public String getType () {
            return type;
        }

        public void clearData () {
            data.clear();
        }

        public void saveData () {
            dataReader.saveData();
        }
        public void show () {
            for (SpaceMarine sp : data) {
                System.out.println(sp.toString());
            }
        }
    }
}
