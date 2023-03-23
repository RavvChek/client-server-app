package ru.ravvcheck.itmo.springLabs.model;

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Double y; //Значение поля должно быть больше -903, Поле не может быть null

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
