package ua.com.alevel.util;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.DateInsaneException;

public class CheckerDateFormatUtil{

    public static boolean checkFormatCorrect(String usersFormat){
        if(usersFormat.contains(AppMessages.SPACE)){
            String dateFormat = usersFormat.split(AppMessages.SPACE)[0];
            String timeFormat = usersFormat.split(AppMessages.SPACE)[1];
            return checkDateFormatCorrect(dateFormat) && checkTimeFormatCorrect(timeFormat);
        }else{
            return checkDateFormatCorrect(usersFormat);
        }
    }

    private static boolean checkDateFormatCorrect(String usersFormat){
        return usersFormat.matches("^(d{1,2})(/|-)(m{1,3})(/|-)(y{2}|y{4})$") ||
                usersFormat.matches("^(m{1,3})(/|-)(d{1,2})(/|-)(y{2}|y{4})$");
    }

    private static boolean checkTimeFormatCorrect(String timeFormat){
        return timeFormat.matches("^((00:){1,2}00)|((00:){1,3}000)$");
    }

    public static boolean checkDateCorrect(String usersDate){
        return checkDateParts(usersDate);
    }

    private static boolean checkDateParts(String userDate){
        if(userDate.contains(AppMessages.SPACE)){
            String date = userDate.split(AppMessages.SPACE)[0];
            String time = userDate.split(AppMessages.SPACE)[1];
            return checkDateByRools(date) && checkTimeByRools(time);
        }else{
            return checkDateByRools(userDate);
        }
    }

    private static boolean checkDateByRools(String date){
        if(date.contains(":") || date.length() > 11){
            return false;
        }else if(date.matches("^\\d{0,2}/\\d{1,2}/\\d{0,4}$") ||
                date.matches("^\\d{0,2}-\\d{1,2}-\\d{0,4}$") ||
                date.matches("^\\d{4}$")){
            return true;
        }
        return false;
    }

    private static boolean checkTimeByRools(String time){
        return time.matches("^((\\d{1,2}:){1,2}\\d{1,2})|((\\d{1,2}:){1,3}\\d{3})$") ||
                time.matches("^:\\d{1,2}$");
    }


    public static boolean checkMonthSane(String month, int year) throws DateInsaneException{
        try{
            Month.valueOf(month);
            return true;
        }catch(IllegalArgumentException iae){
            throw new DateInsaneException("There is no such month! Try again!");
        }
    }

    public static boolean checkDaySane(int day, String month, int year) throws DateInsaneException{
        if(isLeapYear(year) && Month.valueOf(month).equals(Month.FEBRUARY) && day > 29){
            throw new DateInsaneException("In Leap year in FEBRUARY the last day is 29! Try again!");
        }else if((!isLeapYear(year)) && Month.valueOf(month).equals(Month.FEBRUARY) && day > 28){
            throw new DateInsaneException("In simple year in FEBRUARY the last day is 28! Try again!");
        }else if(!isLeapYear(year) && !isMonthDaysCorrect(Month.valueOf(month), day)){
            return false;
        }else if(day < 1){
            throw new DateInsaneException("Day can not be less than 1! Try again!");
        }
        return true;
    }

    public static boolean isMonthDaysCorrect(Month month, int day) throws DateInsaneException{
        switch(month){
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:{
                if(day > 31){
                    throw new DateInsaneException("In simple year in this MONTH the last day is 31! Try again!");
                }
                break;
            }
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:{
                if(day > 31){
                    throw new DateInsaneException("In simple year in this month the last day is 30! Try again!");
                }
                break;
            }
        }
        return true;
    }

    public static boolean isLeapYear(int year){
        if(year == 0){
            return true;
        }else{
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        }
    }
}
