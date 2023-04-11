package ru.ravvcheck.itmo.springLabs.forms;

import ru.ravvcheck.itmo.springLabs.model.Chapter;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.util.Scanner;

public class ChapterBuild implements Build {
    private final Scanner scanner = Supervisor.getScanner();

    @Override
    public Chapter build() {
        return new Chapter(buildName(), buildMarinesCount());
    }

    public String buildName() {
        String name;
        System.out.println("Введите имя главы");
        name = scanner.nextLine().trim();
        try {
            SpaceMarine.SpaceMarineValidation.validateName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public long buildMarinesCount() {
        String marinesCount;
        long mrsc;
        System.out.println("Введите количество десантников");
        marinesCount = scanner.nextLine().trim();
        try {
            mrsc = Long.parseLong(marinesCount);
            Chapter.ChapterValidation.validateMarinesCount(Long.parseLong(marinesCount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Long.parseLong(marinesCount);
    }
}
