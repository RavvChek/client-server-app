package ru.ravvcheck.itmo.springLabs.model;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Objects;

public class SpaceMarine implements Comparable<SpaceMarine> {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null

    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private int heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private String achievements; //Поле не может быть null
    private AstartesCategory category; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer health, int heartCount, String achievements, AstartesCategory category, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.achievements = achievements;
        this.category = category;
        this.chapter = chapter;
    }

    public SpaceMarine() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setCoordinatesX(float x) {
        this.getCoordinates().setX(x);
    }

    public void setCoordinatesY(Double y) {
        this.getCoordinates().setY(y);
    }

    public void setChapterName(String name) {
        this.getChapter().setName(name);
    }

    public void setChapterMarinesCount(long mrc) {
        this.getChapter().setMarinesCount(mrc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine that = (SpaceMarine) o;
        return id == that.id && heartCount == that.heartCount && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(health, that.health) && Objects.equals(achievements, that.achievements) && category == that.category && Objects.equals(chapter, that.chapter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, health, heartCount, achievements, category, chapter);
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", heartCount=" + heartCount +
                ", achievements='" + achievements + '\'' +
                ", category=" + category +
                ", chapter=" + chapter +
                '}';
    }

    public boolean compareToId(SpaceMarine sp) {
        if (this.getId() > sp.getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(SpaceMarine sp) {
        if (sp.getName().compareTo(this.getName()) == 0) {
            if (sp.getHealth().compareTo(this.getHealth()) == 0) {
                return 0;
            } else if (sp.getHealth().compareTo(this.getHealth()) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (sp.getName().compareTo(this.getName()) > 0) {
            return 1;
        } else {
            return -1;
        }

    }


    public static class SpaceMarineValidation {

        public static void listValidate(LinkedList<SpaceMarine> list) throws Exception {
            for (SpaceMarine sp : list) {
                validate(sp);
            }
        }

        public static void validate(SpaceMarine sp) throws Exception {
            validateName(sp.getName());
            validateAchievements(sp.getAchievements());
            validateChapter(sp.getChapter());
            validateHealth(sp.getHealth());
            validateCreationDate(sp.getCreationDate());
            validateHeartCount(sp.getHeartCount());
            validateCoordinates(sp.getCoordinates());
        }

        public static void validateUniqueId(LinkedList<SpaceMarine> list,  int id) throws Exception{
            for(SpaceMarine sp : list){
                if(sp.getId() == id){
                    throw new Exception();
                }
            }
        }
        public static void validateName(String name) throws Exception {
            if (name.equals("") || name == null) {
                throw new Exception();
            }
        }

        public static void validateCoordinates(Coordinates coordinates) throws Exception {
            if (coordinates == null) {
                throw new Exception();
            } else {
                Coordinates.CoordinatesValidation.validate(coordinates);
            }
        }

        public static void validateCreationDate(ZonedDateTime znd) throws Exception {
            if (znd == null) {
                throw new Exception();
            }
        }

        public static void validateHealth(Integer health) throws Exception {
            if (health < 0) {
                throw new Exception();
            }
        }

        public static void validateHeartCount(int heartCount) throws Exception {
            if (heartCount > 3 || heartCount < 0) {
                throw new Exception();
            }
        }

        public static void validateAchievements(String ach) throws Exception {
            if (ach == null) {
                throw new Exception();
            }
        }

        public static void validateChapter(Chapter chapter) throws Exception {
            if (chapter == null) {
                throw new Exception();
            }
            Chapter.ChapterValidation.validate(chapter);
        }

        public static AstartesCategory createValidateAstartresCategory(String astartesCategory) throws Exception {
            AstartesCategory ac = null;
            switch (astartesCategory) {
                case "SCOUT":
                    return AstartesCategory.SCOUT;
                case "ASSAULT":
                    return AstartesCategory.ASSAULT;
                case "APOTHECARY":
                    return AstartesCategory.APOTHECARY;
                case "SUPPRESSOR":
                    return AstartesCategory.SUPPRESSOR;
                default:
                    throw new Exception();
            }
        }
    }

}
