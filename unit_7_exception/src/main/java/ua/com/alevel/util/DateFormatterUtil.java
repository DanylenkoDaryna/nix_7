package ua.com.alevel.util;

import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;

public class DateFormatterUtil{

    public static String showInStandardFormat(CalendarDate date){
        if(date.getFormatter() != null){
            return date.getFormatter().format(date);
        }else{
            StringBuilder standardDate = new StringBuilder();
            String day = getProperDayPresentation(date.getDay());
            String month = getProperMonthPresentation(date.getMonth());
            String hours = getProperHourPresentation(date.getHours());
            String minutes = getProperMinutePresentation(date.getMinutes());
            String seconds = getProperSecPresentation(date.getSeconds());
            String mills = getProperMillsPresentation(date.getMilliseconds());
            standardDate.append(day).append("/").append(month).append("/").append(date.getYear()).append(" ")
                    .append(hours).append(":").append(minutes).append(":").append(seconds).append(":")
                    .append(mills);
            System.out.println(standardDate);
            return standardDate.toString();
        }
    }

    public static String getProperMillsPresentation(long milliseconds){
        if(String.valueOf(milliseconds).length() == 1){
            return "00" + milliseconds;
        }else if(String.valueOf(milliseconds).length() == 2){
            return "0" + milliseconds;
        }else if(String.valueOf(milliseconds).length() == 3){
            return String.valueOf(milliseconds);
        }else return String.valueOf(milliseconds).substring(1, 4);
    }

    public static String getProperSecPresentation(int seconds){
        if(String.valueOf(seconds).length() < 2){
            return "0" + seconds;
        }else return String.valueOf(seconds);
    }

    public static String getProperMinutePresentation(int minutes){
        if(String.valueOf(minutes).length() < 2){
            return "0" + minutes;
        }else return String.valueOf(minutes);
    }

    public static String getProperHourPresentation(int hours){
        if(String.valueOf(hours).length() < 2){
            return "0" + hours;
        }else return String.valueOf(hours);
    }

    public static String getProperMonthPresentation(Month month){
        if(String.valueOf(month.monthAsInt()).length() < 2){
            return "0" + month.monthAsInt();
        }else return String.valueOf(month.monthAsInt());
    }

    public static String getProperDayPresentation(int day){
        if(String.valueOf(day).length() < 2){
            if(String.valueOf(day).equals("0")){
                return "01";
            }else return "0" + day;
        }else return String.valueOf(day);
    }

    public static String getProperYearPresentation(int year){
        if(String.valueOf(year).length() < 4){
            if(String.valueOf(year).equals("0")){
                return "0000";
            }else if(String.valueOf(year).length() == 1){
                return "000" + year;
            }else if(String.valueOf(year).length() == 2){
                return "00" + year;
            }else if(String.valueOf(year).length() == 3){
                return "0" + String.valueOf(year);
            }
        }
        return String.valueOf(year);
    }
}
