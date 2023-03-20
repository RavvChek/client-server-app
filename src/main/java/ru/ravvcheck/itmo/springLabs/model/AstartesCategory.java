package ru.ravvcheck.itmo.springLabs.model;

public enum AstartesCategory {
    SCOUT("Разведчик"),
    AGGRESSOR("Агрессор"),
    SUPPRESSOR("Подавитель"),
    TACTICAL("Тактический");
    private String name;

    AstartesCategory(String name) {
        this.name = name;
    }
}
