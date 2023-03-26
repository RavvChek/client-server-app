package ru.ravvcheck.itmo.springLabs.model;

public class Chapter {
    private String name; //Поле не может быть null, cтрока не может быть пустой
    private Integer marinesCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000


    public Chapter() {

    }

    public String getName() {
        return this.name;
    }

    public Integer getMarinesCount() {
        return this.marinesCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarinesCount(Integer marinesCount) {
        this.marinesCount = marinesCount;
    }
}