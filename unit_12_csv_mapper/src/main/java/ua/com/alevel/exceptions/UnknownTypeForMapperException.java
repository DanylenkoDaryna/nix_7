package ua.com.alevel.exceptions;

public class UnknownTypeForMapperException extends RuntimeException{
    public UnknownTypeForMapperException(){
        super("Unknown type for Mapper");
    }

    public UnknownTypeForMapperException(String message){
        super(message);
    }

    public UnknownTypeForMapperException(String message, Exception e){
        super(message, e);
    }
}
