package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.DFMessages;

import java.io.*;

public class DateFormatterController{

    private static final String PATH_TO_FILE_WITH_DATES = "module2/files/dates.txt";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    public void formatDates(){
        System.out.println("Formatting your dates from 'dates.txt'...");
        try(BufferedReader bufferedReader = new BufferedReader
                (new FileReader(PATH_TO_FILE_WITH_DATES))){
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String format = getFormat(line);
                String result = reformatDate(line, format);
                if(!result.equals(DFMessages.WRONG_TNPUT)){
                    System.out.print(line + " = " + result + System.lineSeparator());
                }
            }
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    private String getFormat(String usersDate){
        if(usersDate.contains("/") && !usersDate.contains("-")){
            String[] dateParts = usersDate.split("/");
            if(dateParts.length == 3 && dateParts[0].length() == 4 && dateParts[1].length() == 2 && dateParts[2].length() == 2){
                return DFMessages.FORMAT_ONE;
            }else if(dateParts.length == 3 && dateParts[0].length() == 2 && dateParts[1].length() == 2
                    && dateParts[2].length() == 4){
                return DFMessages.FORMAT_TWO;
            }else return DFMessages.WRONG_TNPUT;
        }else if(usersDate.contains("-") && !usersDate.contains("/")){
            String[] dateParts = usersDate.split("-");
            if(dateParts.length == 3 && dateParts[0].length() == 2 && dateParts[1].length() == 2 && dateParts[2].length() == 4){
                return DFMessages.FORMAT_THREE;
            }else return DFMessages.WRONG_TNPUT;
        }else return DFMessages.WRONG_TNPUT;
    }

    private String reformatDate(String line, String format){
        switch(format){
            case DFMessages.FORMAT_ONE:
                return getDateFromFormat1(line);
            case DFMessages.FORMAT_TWO:
                return getDateFromFormat2(line);
            case DFMessages.FORMAT_THREE:
                return getDateFromFormat3(line);
            default:
                return DFMessages.WRONG_TNPUT;
        }
    }

    private String getDateFromFormat3(String date){
        int year = getYearFromString(date.split("-")[2]);
        int month = getMonthFromString(date.split("-")[0]);
        int day = getDayFromString(date.split("-")[1], month, year);
        if(day != -1 && year != -1 && month != -1){
            return getProperYearPresentation(year) + getProperMonthPresentation(month) + getProperDayPresentation(day);
        }else return DFMessages.WRONG_TNPUT;
    }

    private String getDateFromFormat2(String date){
        int year = getYearFromString(date.split("/")[2]);
        int month = getMonthFromString(date.split("/")[1]);
        int day = getDayFromString(date.split("/")[0], month, year);
        if(day != -1 && year != -1 && month != -1){
            return getProperYearPresentation(year) + getProperMonthPresentation(month) + getProperDayPresentation(day);
        }else return DFMessages.WRONG_TNPUT;
    }

    private String getDateFromFormat1(String date){
        int year = getYearFromString(date.split("/")[0]);
        int month = getMonthFromString(date.split("/")[1]);
        int day = getDayFromString(date.split("/")[2], month, year);
        if(day != -1 && year != -1 && month != -1){
            return getProperYearPresentation(year) + getProperMonthPresentation(month) + getProperDayPresentation(day);
        }else return DFMessages.WRONG_TNPUT;
    }


    private static int getYearFromString(String year){
        if(checkYear(year)){
            return Integer.parseInt(year);
        }else return -1;
    }

    private static boolean checkYear(String year){
        return year.matches("^\\d{4}$") && Integer.parseInt(year) >= 0;
    }

    private static int getMonthFromString(String month){
        if(checkMonthSane(month)){
            return Integer.parseInt(month);
        }else return -1;
    }

    private static int getDayFromString(String day, int month, int year){
        if(checkDay(day, month, year)){
            return Integer.parseInt(day);
        }else return -1;
    }

    private static boolean checkDay(String day, int month, int year){
        return day.matches("^\\d{2}$") && Integer.parseInt(day) > 0 &&
                Integer.parseInt(day) <= 31 && checkDaySane(Integer.parseInt(day), month, year);
    }

    private static boolean checkMonthSane(String month){
        return month.matches("^\\d{2}$") && Integer.parseInt(month) > 0 &&
                Integer.parseInt(month) <= 12;
    }

    private static boolean checkDaySane(int day, int month, int year){
        if(isLeapYear(year) && month == 2 && day > 29){
            return false;
        }else if((!isLeapYear(year)) && month == 2 && day > 28){
            return false;
        }else if(!isLeapYear(year) && !isMonthDaysCorrect(month, day)){
            return false;
        }else return true;
    }

    private static boolean isMonthDaysCorrect(int month, int day){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:{
                if(day > 31){
                    return false;
                }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11:{
                if(day > 30){
                    return false;
                }
                break;
            }
        }
        return true;
    }

    private static boolean isLeapYear(int year){
        if(year == 0){
            return true;
        }else{
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        }
    }

    private static String getProperMonthPresentation(int month){
        if(String.valueOf(month).length() < 2){
            return "0" + month;
        }else return String.valueOf(month);
    }

    private static String getProperDayPresentation(int day){
        if(String.valueOf(day).length() < 2){
            return "0" + day;
        }else return String.valueOf(day);
    }

    private static String getProperYearPresentation(int year){
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