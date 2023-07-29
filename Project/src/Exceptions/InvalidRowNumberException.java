package Exceptions;

public class InvalidRowNumberException extends RuntimeException{
    public InvalidRowNumberException(String message) {
        super(message);
    }
}
