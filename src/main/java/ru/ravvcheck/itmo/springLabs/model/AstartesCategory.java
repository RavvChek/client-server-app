package ru.ravvcheck.itmo.springLabs.model;

public enum
AstartesCategory {
    SCOUT("Разведчик"),
    ASSAULT("Атакующий"),
    SUPPRESSOR("Подавитель"),
    APOTHECARY("Аптекарь");
    private String name;

    AstartesCategory(String name) {
        this.name = name;
    }
}
