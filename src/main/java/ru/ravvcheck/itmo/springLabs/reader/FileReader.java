package ru.ravvcheck.itmo.springLabs.reader;

import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.forms.SpaceMarineStringForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.Scanner;

public class FileReader extends DataReader {
    private String[] keys;
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
        keys = scanner.nextLine().split(",");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(parser.reading(line, scanner, keys));
        }
        scanner.close();
        return list;
    }

    @Override
    public void saveData(LinkedList<SpaceMarine> value) throws Exception {
        if (!Files.isWritable(file.toPath())) {
            throw new Exception();
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file))) {
            for(String key : keys){
                writer.write(key + ",");
            }
            for(SpaceMarine sp : value){
                for(String attr : SpaceMarineStringForm.getListAllAttr(sp)){
                    writer.write(attr + ",");
                }
            }
        } catch (IOException e) {
            System.out.println();
        }
    }
}
