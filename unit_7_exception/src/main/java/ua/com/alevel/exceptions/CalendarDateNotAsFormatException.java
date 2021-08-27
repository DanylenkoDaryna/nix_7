package ua.com.alevel.exceptions;

import ua.com.alevel.cmd.AppMessages;

public class CalendarDateNotAsFormatException extends Exception{

    public String getMessage(){
        return AppMessages.DATE_NOT_AS_FORMAT_EXCEPTION;
    }
}