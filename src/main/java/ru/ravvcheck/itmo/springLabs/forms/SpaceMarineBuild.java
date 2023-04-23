package ru.ravvcheck.itmo.springLabs.forms;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.model.AstartesCategory;
import ru.ravvcheck.itmo.springLabs.model.Chapter;
import ru.ravvcheck.itmo.springLabs.model.Coordinates;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class SpaceMarineBuild implements Build {
    private static int Id;
    private final Scanner scanner = Supervisor.getScanner();
    private final CoordinatesBuild coordinatesBuild = new CoordinatesBuild();
    private final ChapterBuild chapterBuild = new ChapterBuild();

    public SpaceMarine build() throws WrongValuesException {
        return new SpaceMarine(Id++, buildName(), buildCoordinates(), buildZonedDateTime(), buildHealth(), buildHeartCount(), buildAchievements(), buildAstartesCategory(), buildChapter());
    }

    public String buildName() {
        while (true) {
            String name;
            System.out.println("Введите имя десантника");
            name = scanner.nextLine().trim();
            try {
                SpaceMarine.SpaceMarineValidation.validateName(name);
                return name;
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Coordinates buildCoordinates() throws WrongValuesException {
        return coordinatesBuild.build();
    }

    public ZonedDateTime buildZonedDateTime() {
        return ZonedDateTime.now();
    }

    public Integer buildHealth() {
        while (true) {
            String health;
            Integer h;
            System.out.println("Введите количество здоровья");
            health = scanner.nextLine().trim();
            try {
                h = Integer.parseInt(health);
                SpaceMarine.SpaceMarineValidation.validateHealth(h);
                return Integer.parseInt(health);
            } catch (NumberFormatException e) {
                System.out.println("Поле health должно быть типа Integer");
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int buildHeartCount() {
        while (true) {
            String heartCount;
            int hrt;
            System.out.println("Введите количество сердец");
            heartCount = scanner.nextLine().trim();
            try {
                hrt = Integer.parseInt(heartCount);
                SpaceMarine.SpaceMarineValidation.validateHeartCount(hrt);
                return Integer.parseInt(heartCount);
            } catch (NumberFormatException e) {
                System.out.println("Поле heart_count должно быть типа int");
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String buildAchievements() {
        while (true) {
            String achievements;
            System.out.println("Введите достижения");
            achievements = scanner.nextLine().trim();
            try {
                SpaceMarine.SpaceMarineValidation.validateAchievements(achievements);
                return achievements;
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public AstartesCategory buildAstartesCategory() {
        while (true) {
            String astartesCategory;
            System.out.println("Список всех категорий\n");
            System.out.println(AstartesCategory.APOTHECARY.toString() + "\n" + AstartesCategory.ASSAULT.toString() + "\n" + AstartesCategory.SCOUT.toString() + "\n" + AstartesCategory.SUPPRESSOR.toString());
            System.out.println("Введите категорию десантника из предложенного списка");
            astartesCategory = scanner.nextLine().trim();
            try {
                return SpaceMarine.SpaceMarineValidation.createValidateAstartresCategory(astartesCategory);
            } catch (WrongValuesException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Chapter buildChapter() throws WrongValuesException {
        return new Chapter(chapterBuild.buildName(), chapterBuild.buildMarinesCount());
    }
}
