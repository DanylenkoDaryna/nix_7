package ua.com.alevel.formatter;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.DateInsaneException;
import ua.com.alevel.mapper.CheckerDateFormatUtil;
import ua.com.alevel.mapper.ConverterToMsUtill;
import ua.com.alevel.mapper.DateFormatterUtil;

public class FormatterUSA implements Formatter{
    private static final String FORMAT = "m/d/yyyy";
    private static final String REGEX = "^(\\d{1})/(\\d{1})/(\\d{1,4})$";

    @Override
    public String format(CalendarDate date){
        StringBuilder result = new StringBuilder();
        result.append(date.getMonth().monthAsInt())
                .append("/")
                .append(date.getDay())
                .append("/")
                .append(DateFormatterUtil.getProperYearPresentation(date.getYear()));
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
        String[] parts = date.split(AppMessages.SLASH);
        int day = Integer.parseInt(parts[1]);
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[2]);
        if(CheckerDateFormatUtil.checkMonthSane(Month.values()[month - 1].name(), year)
                && CheckerDateFormatUtil.checkDaySane(day, Month.values()[month - 1].name(), year)){
            calendarDate.setDay(day);
            calendarDate.setMonth(Month.values()[month - 1]);
            calendarDate.setYear(year);
        }
    }
}
