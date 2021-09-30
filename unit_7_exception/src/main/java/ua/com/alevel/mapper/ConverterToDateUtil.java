package ua.com.alevel.mapper;

import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;


public class ConverterToDateUtil{

    static private final long MILLISECONDS = 1;
    static private final long SECOND = MILLISECONDS / 1000;
    static private final long MINUTE = SECOND / 60;
    static private final long HOUR = MINUTE / 60;
    static private final long DAY = HOUR / 24;
    static private final long DAYS_IN_SIMPLE_YEAR = 365;
    static private final long DAYS_IN_LEAP_YEAR = 366;

    static private final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static CalendarDate convert(long mills){
        CalendarDate date = new CalendarDate();

        long allMs = mills;
        long allSec = allMs / 1000;
        long allMin = allSec / 60;
        long allHours = allMin / 60;
        long allDays = allHours / 24;

        int amountOfYears = 0;

        long tempAllDays = allDays;
        int currentMonth = 0;
        while(tempAllDays >= DAYS_IN_MONTHS[currentMonth]){
            if(currentMonth == 1 && isYearLeap(amountOfYears)){
                tempAllDays = tempAllDays - 29;
            }else{
                tempAllDays = tempAllDays - DAYS_IN_MONTHS[currentMonth];
            }
            currentMonth += 1;
            if(currentMonth > 11){
                amountOfYears += 1;
                currentMonth = 0;
            }
        }

        date.setMilliseconds(mills % 1000);
        date.setSeconds((int) (allSec % 60));
        date.setMinutes((int) (allMin % 60));
        date.setHours((int) (allHours % 24));
        date.setDay((int) (tempAllDays % DAYS_IN_MONTHS[currentMonth] + 1));
        date.setMonth(Month.values()[((currentMonth) % 12)]);
        date.setYear(amountOfYears);
        return date;
    }

    private static boolean isYearLeap(int year){

        if(year == 0){
            return true;
        }else{
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        }
    }

    public static long toSeconds(long milliseconds){
        return milliseconds / 1000;
    }

    public static long toMinutes(long milliseconds){
        return milliseconds / 1000 / 60;
    }

    public static long toHours(long milliseconds){
        return milliseconds / 1000 / 60 / 60;
    }

    public static long toDays(long milliseconds){
        return milliseconds / 1000 / 60 / 60 / 24;
    }

    public static long toYears(long milliseconds){
        long years = 0;
        int currentYear = 1;
        while(milliseconds != 0){
            if(isYearLeap(currentYear)){
                if(milliseconds >= ConverterToMsUtill.daysToMills(DAYS_IN_LEAP_YEAR)){
                    milliseconds -= ConverterToMsUtill.daysToMills(DAYS_IN_LEAP_YEAR);
                    years++;
                }else{
                    years += toDays(milliseconds) / 366;
                    milliseconds = 0;
                }
            }else{
                if(milliseconds >= ConverterToMsUtill.daysToMills(DAYS_IN_SIMPLE_YEAR)){
                    milliseconds -= ConverterToMsUtill.daysToMills(DAYS_IN_SIMPLE_YEAR);
                    years++;
                }else{
                    years += toDays(milliseconds) / 365;
                    milliseconds = 0;
                }
            }
            currentYear++;
        }
        return years;
    }

}
