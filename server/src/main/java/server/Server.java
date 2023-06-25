package server;


import server.exceptions.ConnectException;
import server.exceptions.ServerLaunchException;
import server.supervisor.Supervisor;
import transfers.Request;
import transfers.Response;
import transfers.ResponseStatus;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int port = 8009;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private Socket socket;
    private ServerSocket server;
    private InputStream is;
    private OutputStream os;
    private boolean isActivate;
    private Supervisor supervisor;
    private RequestHandler requestHandler;
    private int timeout;


    public Server(Supervisor supervisor, int port, int timeout, RequestHandler requestHandler) {
        this.supervisor = supervisor;
        this.timeout = timeout;
        this.requestHandler = requestHandler;
    }

    public void open() throws ServerLaunchException {
        try {
            System.out.println("Запуск сервера... ");
            server = new ServerSocket(port);
            server.setSoTimeout(timeout);
            activateServer();
        } catch (IllegalArgumentException e) {
            System.out.println("Порт " + port + " недоступен!");
            throw new ServerLaunchException("Сервер не смог запуститься!!!");
        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка при использовании порта " + port + "!");
            throw new ServerLaunchException("Сервер не смог запуститься!!!");
        }
    }

    public Socket connect() throws ConnectException {
        try {
            socket = server.accept();
            System.out.println("Соединение с клиентом установлено!");
            return socket;
        } catch (SocketTimeoutException e) {
            System.out.println("Превышено время ожидания подключения!");
            throw new ConnectException("");
        } catch (IOException e) {
            System.out.println("Ошибка при соединении с клиентом!");
            throw new ConnectException("");
        }
    }


    public boolean receiveRequest(Socket socket) {
        executor.submit(() -> {
            Request userRequest = null;
            Response responseToUser = null;
            try (ObjectInputStream clientReader = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream clientWriter = new ObjectOutputStream(socket.getOutputStream())) {
                do {
                    userRequest = (Request) clientReader.readObject();
                    responseToUser = requestHandler.handle(userRequest);
                    System.out.println("Запрос '" + userRequest.getCommandName() + "' успешно обработан");
                    clientWriter.writeObject(responseToUser);
                    clientWriter.flush();
                } while (responseToUser.getStatus() != ResponseStatus.EXIT);
                return false;
            } catch (ClassNotFoundException e) {
                System.out.println("Ошибка при чтении полученных данных");
            } catch (InvalidClassException | NotSerializableException ex) {
                System.out.println("Ошибка при отправке данных на клиент");
            } catch (IOException e) {
                if (userRequest == null) {
                    System.out.println("Разрыв соединения с клиентом");
                } else {
                    System.out.println("Клиент успешно отключен от сервера");
                }
            }
            return true;
        });
        return true;
    }

    public void run() {
        try {
            open();
            while (isActivate) {
                try {
                    isActivate = receiveRequest(connect());
                } catch (ConnectException e) {
                    break;
                }
            }
            stop();
        } catch (ServerLaunchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        deactivateServer();
        try {
            socket.close();
            System.out.println("Работа сервера завершена!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void activateServer() {
        isActivate = true;
        System.out.println("Сервер запущен!");
    }

    public void deactivateServer() {
        isActivate = false;
        System.out.println("Сервер закрыт!");
    }

    public int getPort() {
        return port;
    }

    public void controlServer(Thread threadToControl) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (!threadToControl.isAlive()) {
                break;
            }
            switch (command) {
                case "save" -> {
                    try {
                        supervisor.getDatabase().saveData();
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении коллекции");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "exit" -> {
                    try {
                        if (!server.isClosed()) {
                            server.close();
                        }
                    } catch (IOException e) {

                    }

                    System.out.println("На выход!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Неизвестная команда: " + command);
                }
            }
        }
    }
}
