package ua.com.alevel.mapper;

import ua.com.alevel.entity.CalendarDate;


public class DateManipulationUtil{

    public static CalendarDate plusYear(CalendarDate calendarDate, int year){
        calendarDate.setYear(calendarDate.getYear() + year);
        return calendarDate;
    }

    public static CalendarDate plusDay(CalendarDate calendarDate, int day){
        long mills = ConverterToMsUtill.daysToMills(day);
        long result = mills + calendarDate.getAverageMills();
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate plusHours(CalendarDate calendarDate, int hour){
        long mills = ConverterToMsUtill.hoursToMills(hour);
        long result = mills + calendarDate.getAverageMills();
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate plusMinutes(CalendarDate calendarDate, int min){
        long mills = ConverterToMsUtill.minutesToMills(min);
        long result = mills + calendarDate.getAverageMills();
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate plusSeconds(CalendarDate calendarDate, int sec){
        long mills = ConverterToMsUtill.secondsToMills(sec);
        long result = mills + calendarDate.getAverageMills();
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate plusMilliseconds(CalendarDate calendarDate, int mills){
        long result = mills + calendarDate.getAverageMills();
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate minusYear(CalendarDate calendarDate, int year){
        calendarDate.setYear(calendarDate.getYear() - year);
        return calendarDate;
    }

    public static CalendarDate minusDay(CalendarDate calendarDate, int day){
        long mills = ConverterToMsUtill.daysToMills(day);
        long result = calendarDate.getAverageMills() - mills;
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate minusHours(CalendarDate calendarDate, int hours){
        long mills = ConverterToMsUtill.hoursToMills(hours);
        long result = calendarDate.getAverageMills() - mills;
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate minusMinutes(CalendarDate calendarDate, int min){
        long mills = ConverterToMsUtill.minutesToMills(min);
        long result = calendarDate.getAverageMills() - mills;
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate minusSeconds(CalendarDate calendarDate, int sec){
        long mills = ConverterToMsUtill.secondsToMills(sec);
        long result = calendarDate.getAverageMills() - mills;
        return ConverterToDateUtil.convert(result);
    }

    public static CalendarDate minusMilliseconds(CalendarDate calendarDate, long mills){
        long result = calendarDate.getAverageMills() - mills;
        return ConverterToDateUtil.convert(result);
    }

    public static long findDifference(CalendarDate calendarDate1, CalendarDate calendarDate2){
        return Math.abs(calendarDate1.getAverageMills() - calendarDate2.getAverageMills());
    }
}
