package ru.ravvcheck.itmo.springLabs.exceptions;

public class WrongValuesException extends Exception{
    WrongValuesException(String  message){
        super(message);
    }
}
