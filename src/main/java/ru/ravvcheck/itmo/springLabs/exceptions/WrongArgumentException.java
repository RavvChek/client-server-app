package ru.ravvcheck.itmo.springLabs.exceptions;

public class WrongArgumentException extends Exception{
    WrongArgumentException(String message){
        super(message);
    }
}
