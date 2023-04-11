package ru.ravvcheck.itmo.springLabs.forms;

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
        String x;
        long X;
        System.out.println("Введите координату X");
        x = scanner.nextLine().trim();
        try {
            X = Long.parseLong(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Long.parseLong(x);
    }

    public Double buildY() {
        String y;
        Double Y;
        System.out.println("Введите координату Y");
        y = scanner.nextLine().trim();
        try {
            Y = Double.valueOf(y);
            Coordinates.CoordinatesValidation.validateY(Y);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Double.valueOf(y);
    }
}
