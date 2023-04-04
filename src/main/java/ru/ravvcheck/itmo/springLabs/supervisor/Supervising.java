package ru.ravvcheck.itmo.springLabs.supervisor;

public interface Supervising {
    public void run();

    public void stop();

    public void waitCommand();
}

