package ua.com.alevel.exceptions;

import ua.com.alevel.cmd.AppMessages;

public class CalendarUnknownFormatException extends Exception{

    public CalendarUnknownFormatException(String message){
        super(message);
    }

    public String getMessage(){
        return AppMessages.NO_SUCH_FORMAT_EXCEPTION;
    }
}
