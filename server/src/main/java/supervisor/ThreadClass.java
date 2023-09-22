package supervisor;

import transfers.Request;
import transfers.Response;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ForkJoinPool;

public class ThreadClass extends ForkJoinPool implements Runnable {
    Response responseToUser;
    Request userRequest;
    RequestHandler requestHandler;
    ObjectOutputStream clientWriter;

    public ThreadClass(Response responseToUser, Request userRequest, RequestHandler requestHandler, ObjectOutputStream clientWriter) {
        this.responseToUser = responseToUser;
        this.clientWriter = clientWriter;
        this.requestHandler = requestHandler;
        this.userRequest = userRequest;
    }

    @Override
    public void run() {
        try {
            responseToUser = requestHandler.handle(userRequest);
            System.out.println("Запрос '" + userRequest.getCommandName() + "' успешно обработан");
            clientWriter.writeObject(responseToUser);
            clientWriter.flush();
        } catch (IOException e) {
            if (userRequest == null) {
                System.out.println("Разрыв соединения с клиентом");
            } else {
                System.out.println("Клиент успешно отключен от сервера");
            }
        }
    }
}
