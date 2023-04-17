package ru.ravvcheck.itmo.springLabs;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.util.Date;
import java.util.LinkedList;

public class LinkedListCollection {
    private final DataReader dataReader;
    private final String type;
    private final Date date;
    private LinkedList<SpaceMarine> data;
    private int count;

    public LinkedListCollection(DataReader dataReader) throws Exception {
        this.dataReader = dataReader;
        data = dataReader.getData();
        type = SpaceMarine.class.getName();
        date = new Date();
    }


    public LinkedList<SpaceMarine> getData() {
        return data;
    }

    public void setData(LinkedList<SpaceMarine> data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public int getCount() {
        count = data.size();
        return count;
    }

    public String getType() {
        return type;
    }

    public void clearData() {
        data.clear();
    }

    public void saveData() throws Exception {
        dataReader.saveData(data);
    }

    public void show() {
        for (SpaceMarine sp : data) {
            System.out.println(sp.toString());
        }
    }

    public void infoData() {
        System.out.println("Тип: " + this.getType());
        System.out.println("Дата инициализации: " + this.getDate().toString());
        System.out.println("Количество элементов: " + this.getCount());
    }

    public void remoteItem() {

    }

    public void addItem() {

    }

    public void updateItem() {

    }

    public void groupCountingByName() {


    }

    public void averageOfHealth() {
        try {
            int result = 0;
            for (SpaceMarine sp : data) {
                result += sp.getHealth();
            }
            result /= data.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void minById() {
        for (SpaceMarine sp : data) {

        }
    }

}

