package ru.ravvcheck.itmo.springLabs.model;

public enum
AstartesCategory {
    SCOUT("scout"),
    ASSAULT("assault"),
    SUPPRESSOR("suppressor"),
    APOTHECARY("apothecary");
    private String name;

    AstartesCategory(String name) {
        this.name = name;
    }
}
