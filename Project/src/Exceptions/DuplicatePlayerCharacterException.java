package Exceptions;

public class DuplicatePlayerCharacterException extends RuntimeException{
    public DuplicatePlayerCharacterException(String message) {
        super(message);
    }
}
