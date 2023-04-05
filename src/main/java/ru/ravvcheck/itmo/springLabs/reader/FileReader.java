package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileReader extends DataReader {

    {
        this.parser = new Parser();
    }

    public FileReader(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    @Override
    public LinkedList<SpaceMarine> getData() throws Exception {
        LinkedList<SpaceMarine> list = new LinkedList<>();
        if (!Files.isReadable(file.toPath())) {
            throw new Exception("");
        }
        scanner = new Scanner(file);
        String[] keyStr = scanner.nextLine().split(";");
        keys = new ArrayList<>(List.of(keyStr));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(parser.reading(line, scanner, keys));
        }
        scanner.close();
        return list;
    }

    @Override
    public void saveData() {

    }
}
