package ua.com.alevel.exceptions;

import ua.com.alevel.cmd.AppMessages;

public class NullMathSetException extends Exception{
    public NullMathSetException(String message){
        super(message);
    }

    public String getMessage(){
        return AppMessages.EMPTY_SET_EXCEPTION;
    }
}
