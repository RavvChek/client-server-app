package ru.ravvcheck.itmo.springLabs.model;

import java.util.Objects;

public class Chapter {
    private String name; //Поле не может быть null, Cтрока не может быть пустой
    private Integer marinesCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarinesCount() {
        return this.marinesCount;
    }

    public void setMarinesCount(Integer marinesCount) {
        this.marinesCount = marinesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(name, chapter.name) && Objects.equals(marinesCount, chapter.marinesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marinesCount);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", marinesCount=" + marinesCount.toString() +
                '}';
    }
}