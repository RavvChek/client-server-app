package ru.ravvcheck.itmo.springLabs.forms;

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

    public SpaceMarine build() throws Exception {
        return new SpaceMarine(Id++, buildName(), buildCoordinates(), buildZonedDateTime(), buildHealth(), buildHeartCount(), buildAchievements(), buildAstartesCategory(), buildChapter());
    }

    public String buildName() {
        String name;
        System.out.println("Введите имя десантника");
        name = scanner.nextLine().trim();
        try {
            SpaceMarine.SpaceMarineValidation.validateName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public Coordinates buildCoordinates() {
        return coordinatesBuild.build();
    }

    public ZonedDateTime buildZonedDateTime() {
        return ZonedDateTime.now();
    }

    public Integer buildHealth() {
        String health;
        Integer h;
        System.out.println("Введите количество здоровья");
        health = scanner.nextLine().trim();
        try {
            h = Integer.parseInt(health);
            SpaceMarine.SpaceMarineValidation.validateHealth(h);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(health);
    }

    public int buildHeartCount() {
        String heartCount;
        int hrt;
        System.out.println("Введите количество сердец");
        heartCount = scanner.nextLine().trim();
        try {
            hrt = Integer.parseInt(heartCount);
            SpaceMarine.SpaceMarineValidation.validateHeartCount(hrt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(heartCount);
    }

    public String buildAchievements() {
        String achievements;
        System.out.println("Введите достижения");
        achievements = scanner.nextLine().trim();
        try {
            SpaceMarine.SpaceMarineValidation.validateAchievements(achievements);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return achievements;
    }

    public AstartesCategory buildAstartesCategory() throws Exception {
        String astartesCategory;
        AstartesCategory ac;
        System.out.println(AstartesCategory.APOTHECARY.toString() + "\n" + AstartesCategory.ASSAULT.toString() + "\n" + AstartesCategory.SCOUT.toString() + "\n" + AstartesCategory.SUPPRESSOR.toString());
        System.out.println("Введите категорию десантника из предложенного списка");
        astartesCategory = scanner.nextLine().trim();
        try {
            ac = SpaceMarine.SpaceMarineValidation.createValidateAstartresCategory(astartesCategory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return SpaceMarine.SpaceMarineValidation.createValidateAstartresCategory(astartesCategory);
    }

    public Chapter buildChapter() {
        return new Chapter(chapterBuild.buildName(), chapterBuild.buildMarinesCount());
    }
}
