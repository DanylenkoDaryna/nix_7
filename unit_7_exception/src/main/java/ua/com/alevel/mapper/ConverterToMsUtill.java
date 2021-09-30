package ua.com.alevel.mapper;

import ua.com.alevel.entity.CalendarDate;

public class ConverterToMsUtill{

    static private final long MILLISECONDS = 1;
    static private final long SECOND = MILLISECONDS * 1000;
    static private final long MINUTE = SECOND * 60;
    static private final long HOUR = MINUTE * 60;
    static private final long DAY = HOUR * 24;

    static private final long SIMPLE_YEAR = DAY * 365;
    static private final long LEAP_YEAR = DAY * 366;


    public static long countAverageMills(CalendarDate date){
        long dateMilliseconds = 0;

        dateMilliseconds += yearsToMills(date.getYear());
        dateMilliseconds += monthsToMills(date.getMonth().monthAsInt(), date.getYear());
        dateMilliseconds += daysToMills(date.getDay());
        dateMilliseconds += hoursToMills(date.getHours());
        dateMilliseconds += minutesToMills(date.getMinutes());
        dateMilliseconds += secondsToMills(date.getSeconds());
        dateMilliseconds += date.getMilliseconds();
        return dateMilliseconds;
    }

    static public long secondsToMills(long seconds){
        return SECOND * seconds;
    }

    static public long minutesToMills(long minutes){
        return MINUTE * minutes;
    }

    static public long hoursToMills(long hours){
        return HOUR * hours;
    }

    static public long daysToMills(long days){
        return DAY * days;
    }

    public static long monthsToMills(int numberOfMonth, int year){
        long monthMilliseconds = 0;
        numberOfMonth--;
        switch(numberOfMonth){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthMilliseconds += daysToMills(31);
                monthMilliseconds += monthsToMills(numberOfMonth, year);
                break;
            case 2:
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                    monthMilliseconds += daysToMills(28);
                else monthMilliseconds += daysToMills(29);
                monthMilliseconds += monthsToMills(numberOfMonth, year);
                break;
            case 0:
                break;
            default:
                monthMilliseconds += daysToMills(30);
                monthMilliseconds += monthsToMills(numberOfMonth, year);
        }
        return monthMilliseconds;
    }

    public static long yearsToMills(int year){
        int leapYears = (year / 4) - (year / 100) + (year / 400);
        int commonYears = year - leapYears;

        long leapMilli = LEAP_YEAR * leapYears;
        long commonMilli = SIMPLE_YEAR * commonYears;

        return commonMilli + leapMilli;
    }
}