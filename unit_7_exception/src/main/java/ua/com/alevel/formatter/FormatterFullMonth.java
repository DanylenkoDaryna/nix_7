package ua.com.alevel.formatter;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.DateInsaneException;
import ua.com.alevel.util.CheckerDateFormatUtil;
import ua.com.alevel.util.ConverterToMsUtill;
import ua.com.alevel.util.DateFormatterUtil;

public class FormatterFullMonth implements Formatter{

    private static final String FORMAT = "mmm-d-yy";
    private static final String REGEX = "^([A-Z]+)-([1-9]{1})-(\\d{1,2})$";


    @Override
    public String format(CalendarDate date){
        StringBuilder result = new StringBuilder();
        result.append(date.getMonth().toString())
                .append("-")
                .append(DateFormatterUtil.getProperDayPresentation(date.getDay()))
                .append("-")
                .append(date.getYear());
        System.out.println(FORMAT);
        System.out.println(result);
        return result.toString();
    }

    @Override
    public boolean checkDateCompareFormatter(String date){
        return date.matches(REGEX);
    }

    @Override
    public CalendarDate convertFromFormat(String usersDate) throws DateInsaneException{
        if(checkDateCompareFormatter(usersDate)){
            CalendarDate calendarDate = new CalendarDate();
            setDate(calendarDate, usersDate);
            setDateAverageMills(calendarDate);
            calendarDate.setFormatter(this);
            return calendarDate;
        }else throw new DateInsaneException("Date is not fit to format " + FORMAT + "Please, try again!");
    }

    private static void setDateAverageMills(CalendarDate calendarDate){
        calendarDate.setAverageMills(
                ConverterToMsUtill.countAverageMills(calendarDate));
    }

    private static void setDate(CalendarDate calendarDate, String date) throws DateInsaneException{
        String[] parts = date.split(AppMessages.DEFIS);
        int day = Integer.parseInt(parts[1]);
        String month = parts[0].toUpperCase();
        int year = Integer.parseInt(parts[2]);
        if(CheckerDateFormatUtil.checkMonthSane(month, year) && CheckerDateFormatUtil.checkDaySane(day, month, year)){
            calendarDate.setDay(day);
            calendarDate.setMonth(Month.valueOf(month));
            calendarDate.setYear(Integer.parseInt(parts[2]));
        }
    }

}
