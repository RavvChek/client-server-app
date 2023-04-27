package ru.ravvcheck.itmo.springLabs.forms;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.model.Coordinates;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.Scanner;

public class CoordinatesBuild implements Build {
    private final Scanner scanner = Supervisor.getScanner();

    @Override
    public Coordinates build() {
        return new Coordinates(buildX(), buildY());
    }

    public float buildX() {
        while (true) {
            String x;
            float X;
            System.out.println("Введите координату X");
            x = scanner.nextLine().trim();
            try {
                return Float.parseFloat(x);
            } catch (NumberFormatException e) {
                System.out.println("Поле x принимает значения типа long");
            }
        }
    }

    public Double buildY() {
        while (true) {
            String y;
            Double Y;
            System.out.println("Введите координату Y (Значение поля должно быть больше -903, Поле не может быть null)");
            y = scanner.nextLine().trim();
            try {
                Y = Double.valueOf(y);
                Coordinates.CoordinatesValidation.validateY(Y);
                return Double.valueOf(y);
            } catch (NumberFormatException e) {
                System.out.println("Поле y принимает double значения");
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
