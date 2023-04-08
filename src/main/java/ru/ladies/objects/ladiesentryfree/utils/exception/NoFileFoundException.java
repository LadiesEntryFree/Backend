package ru.ladies.objects.ladiesentryfree.utils.exception;

public class NoFileFoundException extends RuntimeException{

    public NoFileFoundException(String message) {
        super(message);
    }

    public NoFileFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
