package ru.ravvcheck.itmo.springLabs.model;

public enum
AstartesCategory {
    SCOUT("SCOUT"),
    ASSAULT("ASSAULT"),
    SUPPRESSOR("SUPPRESSOR"),
    APOTHECARY("APOTHECARY");
    private String name;

    AstartesCategory(String name) {
        this.name = name;
    }
}
