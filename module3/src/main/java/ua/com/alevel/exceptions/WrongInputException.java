package ua.com.alevel.exceptions;

public class WrongInputException extends RuntimeException{
    public WrongInputException(){
        super("Wrong input from User!");
    }

    public WrongInputException(String message){
        super(message);
    }

    public WrongInputException(String message, Exception e){
        super(message, e);
    }
}
