package ua.com.alevel.formatter;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.DateInsaneException;
import ua.com.alevel.mapper.CheckerDateFormatUtil;
import ua.com.alevel.mapper.ConverterToMsUtill;
import ua.com.alevel.mapper.DateFormatterUtil;

public class FormatterWithTime implements Formatter{

    private static final String FORMAT = "dd-mmm-yyyy 00:00";
    private static final String REGEX = "^([1-9]{2})-([A-Z]+)-(\\d{1,4}) (\\d{2}):(\\d{2})$";

    @Override
    public String format(CalendarDate date){
        StringBuilder result = new StringBuilder();
        result.append(DateFormatterUtil.getProperDayPresentation(date.getDay()))
                .append("-")
                .append(date.getMonth().toString())
                .append("-")
                .append(DateFormatterUtil.getProperYearPresentation(date.getYear()))
                .append(" ")
                .append(DateFormatterUtil.getProperHourPresentation(date.getHours()))
                .append(":")
                .append(DateFormatterUtil.getProperMinutePresentation(date.getMinutes()));
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
            String date = usersDate.split(AppMessages.SPACE)[0];
            String time = usersDate.split(AppMessages.SPACE)[1];
            setDatePart(calendarDate, date);
            setTimePart(calendarDate, time);
            setDateAverageMills(calendarDate);
            calendarDate.setFormatter(this);
            return calendarDate;
        }else throw new DateInsaneException("Date is not fit to format " + FORMAT + "Please, try again!");
    }

    private static void setDateAverageMills(CalendarDate calendarDate){
        calendarDate.setAverageMills(
                ConverterToMsUtill.countAverageMills(calendarDate));
    }

    private static void setDatePart(CalendarDate calendarDate, String date) throws DateInsaneException{
        String[] parts = date.split(AppMessages.DEFIS);
        int day = Integer.parseInt(parts[0]);
        String month = parts[1].toUpperCase();
        int year = Integer.parseInt(parts[2]);
        if(CheckerDateFormatUtil.checkMonthSane(month, year) && CheckerDateFormatUtil.checkDaySane(day, month, year)){
            calendarDate.setDay(day);
            calendarDate.setMonth(Month.valueOf(month));
            calendarDate.setYear(Integer.parseInt(parts[2]));
        }
    }

    private static void setTimePart(CalendarDate calendarDate, String time){
        String[] parts = time.split(AppMessages.DOUBLE_DOT);
        calendarDate.setHours(Integer.parseInt(parts[0]));
        calendarDate.setMinutes(Integer.parseInt(parts[1]));
        calendarDate.setSeconds(0);
        calendarDate.setMilliseconds(0);
    }
}
