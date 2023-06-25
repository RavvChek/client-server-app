package server;


import server.reader.FileReader;
import server.supervisor.Supervisor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class AppServer {
    private String host;
    private int port;

    public static void main(String[] args) throws Exception {
        if (args.length <= 0) {
            System.out.println("Передайте единственное значение аргументов - название файла");
            System.exit(0);
        }
        try {
            /*Writer writer = new OutputStreamWriter(new FileOutputStream(args[0]));
            writer.write("\"id\", \"name\", \"coordinates_x\", \"coordinates_y\", \"creation_date\", \"health\", \"heart_count\", \"achievements\", \"category\", \"chapter_name\", \"chapter_marines_count\"\n");
            for(int i = 1; i < 5000; i++){
                writer.write("\""+i+"\",\"Ravil\",\"NaN\",\"4.0\",\"2023-04-28T10:52:24.2986091+03:00[Europe/Moscow]\",\"4\",\"2\",\"winner\",\"ASSAULT\",\"chapter 4\",\"34\"\n");
            }*/
            var reader = new FileReader(args[0]);
            var supervisor = new Supervisor(reader);
            var requestHandler = new RequestHandler(supervisor);
            var server = new Server(supervisor, 8000, 1000000, requestHandler);
            Thread mainThread = Thread.currentThread();
            Thread controllingServerThread = new Thread(() -> server.controlServer(mainThread));
            controllingServerThread.start();
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("_");
        }
    }
}
