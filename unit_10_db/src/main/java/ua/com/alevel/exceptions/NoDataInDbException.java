package ua.com.alevel.exceptions;

public class NoDataInDbException extends Exception{
    public NoDataInDbException(){
        super();
    }

    public NoDataInDbException(String message){
        super(message);
    }

    public NoDataInDbException(String message, Throwable cause){
        super(message, cause);
    }

    public NoDataInDbException(Throwable cause){
        super(cause);
    }
}
