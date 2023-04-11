package ru.ravvcheck.itmo.springLabs.model;

import java.util.Objects;

public class Coordinates {

    private float x;

    private Double y; //Значение поля должно быть больше -903, Поле не может быть null

    public Coordinates(float x, Double y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y.toString() +
                '}';
    }
    public static class CoordinatesValidation {
        public static void validate(Coordinates coordinates) throws Exception {
            validateY(coordinates.getY());
        }
        public static void validateY(Double y) throws Exception {
            if (y < -903 || y == null){
                throw new Exception();
            }
        }
    }
}
