package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.AstartesCategory;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Parser implements Parsing {
    @Override
    public SpaceMarine reading(String line, Scanner scanner, String[] keys) throws Exception {
        SpaceMarine sp = new SpaceMarine();
        try (Scanner rowScanner = new Scanner(line)) {
            String[] values = rowScanner.nextLine().split(",");
            HashMap<String, String> mp = new HashMap<>();
            int i = 0;
            for (String k : keys) {
                mp.put(k, values[i]);
                i++;
            }
            for (String k : mp.keySet()) {
                switch (k) {
                    case "ID":
                        sp.setId(Integer.parseInt(mp.get("ID")));
                    case "NAME":
                        sp.setName(mp.get("NAME"));
                    case "COORDINATES.X":
                        sp.setCoordinatesX(Float.parseFloat(mp.get("COORDINATES.X")));
                    case "CREATIONDATE":
                        sp.setCreationDate(ZonedDateTime.now());
                    case "COORDINATES.Y":
                        sp.setCoordinatesY(Double.valueOf(mp.get("COORDINATES.Y")));
                    case "HEALTH":
                        sp.setHealth(Integer.parseInt(mp.get("HEALTH")));
                    case "HEARTCOUNT":
                        sp.setHeartCount(Integer.parseInt(mp.get("HEARTCOUNT")));
                    case "ACHIEVEMENTS":
                        sp.setAchievements(mp.get("ACHIEVEMENTS"));
                    case "CATEGORY":
                        switch (mp.get("CATEGORY")) {
                            case "SCOUT":
                                sp.setCategory(AstartesCategory.SCOUT);
                            case "ASSAULT":
                                sp.setCategory(AstartesCategory.ASSAULT);
                            case "SUPPRESSOR":
                                sp.setCategory(AstartesCategory.SUPPRESSOR);
                            case "APOTHECARY":
                                sp.setCategory(AstartesCategory.APOTHECARY);
                        }
                    case "CHAPTER.NAME":
                        sp.setChapterName(mp.get("CHAPTER.NAME"));
                    case "CHAPTER.MARINESCOUNT":
                        sp.setChapterMarinesCount(Long.parseLong(mp.get("CHAPTER.MARINESCOUNT")));
                }
            }
        }
        try{
            SpaceMarine.SpaceMarineValidation.validate(sp);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return sp;
    }

    /*@Override
    public LinkedList<SpaceMarine> reading(String line) {

        String[] objects = line.split("\n");
        for(String str : objects){
            SpaceMarine sm = new SpaceMarine();
            String[] elements = str.split(",");
            sm.setId(Integer.parseInt(elements[0]));
            sm.setName(elements[1]);
            sm.setCoordinates(new Coordinates(Float.parseFloat(elements[2]), Double.valueOf(elements[3])));
            sm.;
            sm;
            sm;
            sm;
            sm;
            sm;
        }
    }*/
    /*@Override
    public LinkedList<SpaceMarine> reading(String line) {
        try (CSVReader reader = new CSVReader(new FileReader(line)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }*/
}
