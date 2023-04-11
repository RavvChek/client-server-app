package ru.ravvcheck.itmo.springLabs.model;

import java.util.Objects;

public class Chapter {

    private String name; //Поле не может быть null, Строка не может быть пустой

    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public Chapter(String name, long marinesCount) {
        this.name = name;
        this.marinesCount = marinesCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMarinesCount() {
        return this.marinesCount;
    }


    public void setMarinesCount(long marinesCount) {
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
                ", marinesCount=" + marinesCount +
                '}';
    }

    public static class ChapterValidation {
        public static void validate(Chapter chp) throws Exception {
            validateName(chp.getName());
            validateMarinesCount(chp.getMarinesCount());
        }

        public static void validateName(String name) throws Exception {
            if (name == null || name.equals("")) {
                throw new Exception();
            }
        }

        public static void validateMarinesCount(long mrcount) throws Exception {
            if (mrcount < 0 || mrcount > 1000) {
                throw new Exception();
            }
        }
    }
}