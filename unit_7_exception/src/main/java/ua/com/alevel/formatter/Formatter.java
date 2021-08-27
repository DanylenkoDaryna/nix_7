package ua.com.alevel.formatter;


import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.exceptions.DateInsaneException;

public interface Formatter{

    String format(CalendarDate date);

    boolean checkDateCompareFormatter(String date);

    CalendarDate convertFromFormat(String usersDate) throws DateInsaneException;
}
