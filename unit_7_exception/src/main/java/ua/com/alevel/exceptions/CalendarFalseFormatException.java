package ua.com.alevel.exceptions;

import ua.com.alevel.cmd.AppMessages;

public class CalendarFalseFormatException extends Exception{

    public String getMessage(){
        return AppMessages.INCORRECT_FORMAT_EXCEPTION;
    }
}
