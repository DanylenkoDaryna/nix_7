package ua.com.alevel.exceptions;

public class PropertyMappingException extends RuntimeException{
    public PropertyMappingException(String message){
        super(message);
    }

    public PropertyMappingException(String message, Exception e){
        super(message, e);
    }
}
