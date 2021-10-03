package ua.com.alevel.exceptions;

public class CsvMapperException extends RuntimeException{
    public CsvMapperException(){
        super("Trouble with csv mapping");
    }

    public CsvMapperException(String message, Exception e){
        super(message, e);
    }
}
