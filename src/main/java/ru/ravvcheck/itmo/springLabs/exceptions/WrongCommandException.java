package ru.ravvcheck.itmo.springLabs.exceptions;

public class WrongCommandException extends Exception{
    WrongCommandException(String message){
        super(message);
    }
}
