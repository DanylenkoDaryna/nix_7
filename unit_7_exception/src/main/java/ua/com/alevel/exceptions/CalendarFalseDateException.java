package ua.com.alevel.exceptions;

import ua.com.alevel.cmd.AppMessages;

public class CalendarFalseDateException extends Exception{

    public String getMessage(){
        return AppMessages.INCORRECT_DATE_EXCEPTION;
    }
}
