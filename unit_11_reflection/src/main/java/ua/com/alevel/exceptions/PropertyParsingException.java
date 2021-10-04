package ua.com.alevel.exceptions;

public class PropertyParsingException extends RuntimeException{
    public PropertyParsingException(String message){
        super(message);
    }

    public PropertyParsingException(String message, Exception e){
        super(message, e);
    }
}

