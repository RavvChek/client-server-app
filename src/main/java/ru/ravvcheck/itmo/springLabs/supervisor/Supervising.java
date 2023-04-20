package ru.ravvcheck.itmo.springLabs.supervisor;

public interface Supervising {
    public void run() throws Exception;

    public void stop();

    public void waitCommand() throws Exception;
}

