package ru.ravvcheck.itmo.springLabs.reader;

import com.epam.parso.CSVDataWriter;
import com.opencsv.CSVWriter;
import ru.ravvcheck.itmo.springLabs.model.AstartesCategory;
import ru.ravvcheck.itmo.springLabs.model.Chapter;
import ru.ravvcheck.itmo.springLabs.model.Coordinates;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser extends AbstractParser {
    @Override
    public SpaceMarine reading(String line, Scanner scanner, List<String> keys) {
        SpaceMarine sp = new SpaceMarine();
        try (Scanner rowScanner = new Scanner(line)) {
            String[] values = rowScanner.nextLine().split(";");
            for (String k : keys) {
                switch (k) {
                    case "id":
                        sp.setId(Integer.parseInt(values[0]));
                    case "name":
                        sp.setName(values[1]);
                    case "Coordinates.x":
                        sp.setCoordinates(new Coordinates(Float.parseFloat(values[2]), Double.valueOf(values[3])));
                    case "creationDate":
                        System.out.println();
                    case "health":
                        sp.setHealth(Integer.parseInt(values[5]));
                    case "hearCount":
                        sp.setHeartCount(Integer.parseInt(values[6]));
                    case "achievements":
                        sp.setAchievements(values[7]);
                    case "AstartesCategory":
                        switch (values[8]) {
                            case "SCOUT":
                                sp.setCategory(AstartesCategory.SCOUT);
                            case "ASSAULT":
                                sp.setCategory(AstartesCategory.ASSAULT);
                            case "SUPPRESSOR":
                                sp.setCategory(AstartesCategory.SUPPRESSOR);
                            case "APOTHECARY":
                                sp.setCategory(AstartesCategory.APOTHECARY);
                        }
                    case "Chapter.name":
                        sp.setChapter(new Chapter(values[9], Long.parseLong(values[10])));
                }
            }
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
