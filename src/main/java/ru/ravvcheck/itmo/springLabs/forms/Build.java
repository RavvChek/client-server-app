package ru.ravvcheck.itmo.springLabs.forms;

public interface Build<T> {
    public T build() throws Exception;
}
