package ru.ravvcheck.itmo.springLabs.exceptions;

public class RecursionScriptException extends RuntimeException{
    RecursionScriptException(String message){
        super(message);
    }
}
