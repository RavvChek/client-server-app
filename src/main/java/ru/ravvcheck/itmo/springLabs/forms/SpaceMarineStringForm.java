package ru.ravvcheck.itmo.springLabs.forms;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.util.ArrayList;
import java.util.List;

public class SpaceMarineStringForm {
    public static List<String> getListAllAttr(SpaceMarine sp) {
        List<String> result = new ArrayList<>();
        result.add(getIdStr(sp));
        result.add(sp.getName());
        result.add(getCoordinateXStr(sp));
        result.add(getCoordinatesYStr(sp));
        result.add(getCreationDateStr(sp));
        result.add(getHealthStr(sp));
        result.add(getHearCountStr(sp));
        result.add(getAchievements(sp));
        result.add(getCategoryStr(sp));
        result.add(getChapterStrName(sp));
        result.add(getChapterMarinesCountStr(sp));
        return result;
    }

    private static String getIdStr(SpaceMarine sp) {
        return String.valueOf(sp.getId());
    }

    private static String getCoordinateXStr(SpaceMarine sp) {
        return String.valueOf(sp.getCoordinates().getX());
    }

    private static String getCoordinatesYStr(SpaceMarine sp) {
        return String.valueOf(sp.getCoordinates().getY());
    }

    private static String getCreationDateStr(SpaceMarine sp) {
        return sp.getCreationDate().toString();
    }

    private static String getHealthStr(SpaceMarine sp) {
        return String.valueOf(sp.getHealth());
    }

    private static String getHearCountStr(SpaceMarine sp) {
        return String.valueOf(sp.getHeartCount());
    }

    private static String getAchievements(SpaceMarine sp) {
        return sp.getAchievements();
    }

    private static String getCategoryStr(SpaceMarine sp) {
        return sp.getCategory().toString();
    }

    private static String getChapterStrName(SpaceMarine sp) {
        return sp.getChapter().getName();
    }

    private static String getChapterMarinesCountStr(SpaceMarine sp) {
        return String.valueOf(sp.getChapter().getMarinesCount());
    }
}
