package com.ifmo.collection;

import com.ifmo.exceptions.WrongInputException;
import com.ifmo.io.ErrorHandler;
import com.ifmo.model.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.reader.DataReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class TestReader extends DataReader {
    private PriorityQueue<SpaceMarine> collection;

    TestReader(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    private boolean groupExists(Long id) {
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveData(LinkedList<SpaceMarine> values) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(filePath), ',', CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        String[] header = {"id", "name", "coordinates_x", "coordinates_y", "creation_date", "students_count", "should_be_expelled", "average_mark", "form_of_education", "group_admin_name", "group_admin_height", "group_admin_eye_color", "group_admin_nationality"};
        writer.writeNext(header);

        List<String[]> data = new ArrayList<>();
        for (SpaceMarine spaceMarine : collection) {
            String[] line = {
                    String.

            };
            data.add(line);
        }
        writer.writeAll(data);
        writer.close();
    }


    public LinkedList<SpaceMarine> getData() {

        try {
            collection.clear();
            CSVReader reader = new CSVReader(new FileReader(file));

// Считываем первую строку (заголовки столбцов)
            String[] header = reader.readNext();
            Map<String, Integer> headerMap = new HashMap<>();
            for (int i = 0; i < header.length; i++) {
                headerMap.put(header[i], i);
            }

// Считываем остальные строки
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Создаем объект StudyGroup
                if (groupExists(Long.parseLong(nextLine[headerMap.get("id")]))) {
                    ErrorHandler.logError("Данные в файле неверны, существуют две группы с одинаковыми id!");
                    return;
                }

                // Добавляем объект в коллекцию
                StudyGroup studyGroup = new StudyGroup(Long.parseLong(nextLine[headerMap.get("id")]));
                studyGroup.setName(nextLine[headerMap.get("name")]);
                studyGroup.setCoordinates(new Coordinates(Double.parseDouble(nextLine[headerMap.get("coordinates_x")]), Double.parseDouble(nextLine[headerMap.get("coordinates_y")])));
                studyGroup.setCreationDate(LocalDate.parse(nextLine[headerMap.get("creation_date")]));
                studyGroup.setStudentsCount(Integer.parseInt(nextLine[headerMap.get("students_count")]));
                studyGroup.setShouldBeExpelled(Integer.parseInt(nextLine[headerMap.get("should_be_expelled")]));
                studyGroup.setAverageMark(Long.parseLong(nextLine[headerMap.get("average_mark")]));
                studyGroup.setFormOfEducation(FormOfEducation.valueOf(nextLine[headerMap.get("form_of_education")]));
                studyGroup.setGroupAdmin(new Person(nextLine[headerMap.get("group_admin_name")], Double.parseDouble(nextLine[headerMap.get("group_admin_height")]),
                        Color.valueOf(nextLine[headerMap.get("group_admin_eye_color")]), Country.valueOf(nextLine[headerMap.get("group_admin_nationality")])));
                collection.add(studyGroup);
            }

            reader.close();

        } catch (CsvValidationException | IOException e) {
            ErrorHandler.logError("Ошибка чтения файла!" + e.getMessage());
        } catch (NumberFormatException | WrongInputException e) {
            ErrorHandler.logError("Данные в файле неверны!\n" + e.getMessage());
        } catch (Exception e) {
            ErrorHandler.logError("Данные в файле неверны!\n" + e.getMessage());
        }
        return;
    }
}
