package Exceptions;

public class InvalidColumnNumberException extends RuntimeException{
    public InvalidColumnNumberException(String message) {
        super(message);
    }
}
