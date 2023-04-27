package ru.ravvcheck.itmo.springLabs.forms;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
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
        while (true) {
            String name;
            System.out.println("Введите имя главы (поле не может быть null, строка не может быть пустой)");
            name = scanner.nextLine().trim();
            try {
                SpaceMarine.SpaceMarineValidation.validateName(name);
                return name;
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public long buildMarinesCount() {
        while (true) {
            String marinesCount;
            System.out.println("Введите количество десантников (Значение поля должно быть больше 0, Максимальное значение поля: 1000)");
            marinesCount = scanner.nextLine().trim();
            try {
                Chapter.ChapterValidation.validateMarinesCount(Long.parseLong(marinesCount));
                return Long.parseLong(marinesCount);
            } catch (NumberFormatException e) {
                System.out.println("Поле chapter_marines_count принимает значения long");
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
