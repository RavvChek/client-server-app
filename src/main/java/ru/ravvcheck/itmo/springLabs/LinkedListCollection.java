package ru.ravvcheck.itmo.springLabs;

import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineBuild;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.time.ZonedDateTime;
import java.util.*;

public class LinkedListCollection {
    private final DataReader dataReader;
    private final String type;
    private final Date date;
    private LinkedList<SpaceMarine> data;
    private int count;

    public LinkedListCollection(DataReader dataReader) throws Exception {
        this.dataReader = dataReader;
        data = dataReader.getData();
        sortData();
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

    public void removeFirstItem() {
        data.removeFirst();
    }

    public void removeByIdItem(int id) {
        for (SpaceMarine sp : data) {
            if (sp.getId() == id) {
                data.remove(sp);
            }
        }
    }

    public void addItem(SpaceMarine sp) throws Exception {
        data.add(sp);
    }
    public void addFirstItem(SpaceMarine sp){
        data.addFirst(sp);
    }

    public void updateItem(int id) throws Exception {
        SpaceMarineBuild spaceMarineBuild = new SpaceMarineBuild();
        for (SpaceMarine sp : data) {
            if (sp.getId() == id) {
                SpaceMarine newSp = spaceMarineBuild.build();
                sp.setId(newSp.getId());
                sp.setName(newSp.getName());
                sp.setCoordinatesX(newSp.getCoordinates().getX());
                sp.setCoordinatesY(newSp.getCoordinates().getY());
                sp.setCreationDate(ZonedDateTime.now());
                sp.setHealth(newSp.getHealth());
                sp.setHeartCount(newSp.getHeartCount());
                sp.setAchievements(newSp.getAchievements());
                sp.setCategory(sp.getCategory());
                sp.setChapterName(sp.getChapter().getName());
                sp.setChapterMarinesCount(newSp.getChapter().getMarinesCount());
            }
        }
    }

    public void groupCountingByName() {
        HashSet<String> setName = new HashSet<>();
        for (SpaceMarine sp : data) {
            setName.add(sp.getName());
        }
        HashMap<String, List> hashMap = new HashMap<>();
        for (String name : setName) {
            List<SpaceMarine> list = new ArrayList<>();
            for (SpaceMarine sp : data) {
                if (sp.getName().equals(name)) {
                    list.add(sp);
                }
            }
            hashMap.put(name, list);
        }
        for (String name : setName) {
            System.out.println(name + " " + hashMap.get(name).size());
        }
    }

    public void averageOfHealth() {
        try {
            int result = 0;
            for (SpaceMarine sp : data) {
                result += sp.getHealth();
            }
            result /= data.size();
            System.out.println("Среднее значение:" + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void minById() {
        int minId = 100000;
        for (SpaceMarine sp : data) {
            if (sp.getId() < minId) {
                minId = sp.getId();
            }
        }
        for (SpaceMarine sp : data) {
            if (sp.getId() == minId) {
                System.out.println(sp.toString());
            }
        }
    }

    public void sortData() {
        for (ListIterator<SpaceMarine> it = data.listIterator(); it.hasNext(); ) {
            SpaceMarine sp1 = it.next();
            int index = data.indexOf(sp1);
            for (ListIterator<SpaceMarine> iter = data.listIterator(index); iter.hasNext(); ) {
                SpaceMarine sp2 = iter.next();
                if (sp1.compareTo(sp2) > 0) {
                    Collections.swap(data, data.indexOf(sp1), data.indexOf(sp2));
                }
            }
        }
    }
}

