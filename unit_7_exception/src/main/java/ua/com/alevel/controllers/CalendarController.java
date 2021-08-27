package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.CalendarFalseDateException;
import ua.com.alevel.exceptions.CalendarFalseFormatException;
import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.exceptions.CalendarUnknownFormatException;
import ua.com.alevel.exceptions.DateInsaneException;
import ua.com.alevel.factory.FormatterMakerUtil;
import ua.com.alevel.util.CheckerDateFormatUtil;
import ua.com.alevel.util.ConverterToMsUtill;
import ua.com.alevel.util.DateFormatterUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalendarController{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");
    private static Scanner scanner;

    private static List<String> formats;

    static{
        formats = new ArrayList<>();
        formats.add("dd/mm/yy");
        formats.add("m/d/yyyy");
        formats.add("mmm-d-yy");
        formats.add("dd-mmm-yyyy 00:00");
    }

    private static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }else
            return scanner;
    }

    private static Scanner takeScanner(){
        return getScanner();
    }

    public static void startApp(){
        MenuController.startAppMenu();
    }

    public static CalendarDate inputDate(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showInputDateMenu();
            String input = getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    try{
                        String format = chooseFormat();
                        return getDateFromInput(format);
                    }catch(DateInsaneException e){
                        LOGGER_ERR.error(e.getMessage());
                        System.out.println(e.getMessage());
                        return inputDate();
                    }catch(CalendarUnknownFormatException e){
                        System.out.println(e.getMessage());
                        return inputDate();
                    }catch(CalendarFalseFormatException fe){
                        System.out.println(fe.getMessage());
                        LOGGER_ERR.error(fe.getMessage());
                        return inputDate();
                    }
                case "2":
                    try{
                        return getDateFromInput();
                    }catch(CalendarFalseDateException de){
                        System.out.println(de.getMessage());
                        LOGGER_ERR.error(de.getMessage());
                        return inputDate();
                    }
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
        return new CalendarDate();
    }

    public static String getUsersPreEditedCommand(){
        return takeScanner().nextLine().trim().toLowerCase().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
    }

    public static String getUsersPreEditedInput(){
        return takeScanner().nextLine().trim();
    }

    private static String chooseFormat() throws CalendarFalseFormatException{
        System.out.println(AppMessages.ENTER_FORMAT + AppMessages.ENTER_FORMAT_EXAMPLE);
        String usersFormat = getUsersPreEditedInput();
        if(CheckerDateFormatUtil.checkFormatCorrect(usersFormat)){
            return usersFormat;
        }else{
            throw new CalendarFalseFormatException();
        }
    }

    private static CalendarDate getDateFromInput() throws CalendarFalseDateException{
        System.out.println(AppMessages.ENTER_DATE + AppMessages.ENTER_DATE_EXAMPLE);
        String usersDate = getUsersPreEditedInput();
        if(CheckerDateFormatUtil.checkDateCorrect(usersDate)){
            return convertToDate(usersDate);
        }else{
            throw new CalendarFalseDateException();
        }
    }

    private static CalendarDate getDateFromInput(String format) throws CalendarUnknownFormatException, DateInsaneException{
        System.out.println(AppMessages.ENTER_DATE + AppMessages.ENTER_DATE_EXAMPLE);
        String usersDate = getUsersPreEditedInput();
        return convertToDate(usersDate, format);

    }

    public static CalendarDate convertToDate(String usersDate){
        CalendarDate calendarDate = new CalendarDate();
        if(usersDate.contains(AppMessages.SPACE)){
            String date = usersDate.split(AppMessages.SPACE)[0];
            String time = usersDate.split(AppMessages.SPACE)[1];
            setDatePart(calendarDate, date);
            setTimePart(calendarDate, time);
        }else{
            setDatePart(calendarDate, usersDate);
        }
        setDateAverageMills(calendarDate);

        return calendarDate;
    }

    private static void setDateAverageMills(CalendarDate calendarDate){
        calendarDate.setAverageMills(
                ConverterToMsUtill.countAverageMills(calendarDate));
    }

    private static void setDatePart(CalendarDate calendarDate, String date){
        String[] parts = date.split(AppMessages.SLASH + AppMessages.OR + AppMessages.DEFIS);
        if(parts[0].equals(date)){
            getOnlyYearFromString(calendarDate, date);
        }else{
            int day = getDayFromString(parts);
            Month month = getMonthFromString(parts);
            int year = getYearFromString(parts);
            calendarDate.setDay(day);
            calendarDate.setMonth(month);
            calendarDate.setYear(year);
        }
    }

    private static void getOnlyYearFromString(CalendarDate calendarDate, String year){
        calendarDate.setDay(1);
        calendarDate.setMonth(Month.values()[0]);
        calendarDate.setYear(Integer.parseInt(year));
    }

    private static int getYearFromString(String[] parts){
        try{
            if(parts[2].isEmpty()){
                return 0;
            }else return Integer.parseInt(parts[2]);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 0;
        }
    }

    private static Month getMonthFromString(String[] parts){
        try{
            String month = parts[1];
            if(month.isEmpty()){
                return Month.values()[0];
            }else return Month.values()[Integer.parseInt(month) - AppMessages.ZERO_MONTH];
        }catch(ArrayIndexOutOfBoundsException ae){
            return Month.values()[0];
        }
    }

    private static int getDayFromString(String[] parts){
        try{
            String day = parts[0];
            if(day.isEmpty()){
                return 1;
            }else return Integer.parseInt(day);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 1;
        }
    }

    private static void setTimePart(CalendarDate calendarDate, String time){
        String[] parts = time.split(AppMessages.DOUBLE_DOT);
        if(parts == null){
            calendarDate.setHours(0);
            calendarDate.setMinutes(0);
            calendarDate.setSeconds(0);
            calendarDate.setMilliseconds(0);
        }else{
            int hours = getHoursFromString(parts);
            int mins = getMinutesFromString(parts);
            int sec = getSecFromString(parts);
            int mills = getMillsFromString(parts);
            calendarDate.setHours(hours);
            calendarDate.setMinutes(mins);
            calendarDate.setSeconds(sec);
            calendarDate.setMilliseconds(mills);
        }
    }

    private static int getMillsFromString(String[] parts){
        try{
            String mills = parts[3];
            if(mills.isEmpty()){
                return 0;
            }else return Integer.parseInt(mills);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 0;
        }
    }

    private static int getSecFromString(String[] parts){
        try{
            String sec = parts[2];
            if(sec.isEmpty()){
                return 0;
            }else return Integer.parseInt(sec);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 0;
        }
    }

    private static int getMinutesFromString(String[] parts){
        try{
            String min = parts[1];
            if(min.isEmpty()){
                return 0;
            }else return Integer.parseInt(min);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 0;
        }
    }

    private static int getHoursFromString(String[] parts){
        try{
            String hours = parts[0];
            if(hours.isEmpty()){
                return 0;
            }else return Integer.parseInt(hours);
        }catch(ArrayIndexOutOfBoundsException ae){
            return 0;
        }
    }

    private static CalendarDate convertToDate(String usersDate, String format) throws CalendarUnknownFormatException, DateInsaneException{
        for(String line : formats){
            if(format.equals(line)){
                return convertToDateWithFormat(usersDate, format);
            }
        }
        throw new CalendarUnknownFormatException("No such format yet");
    }

    private static CalendarDate convertToDateWithFormat(String usersDate, String format) throws CalendarUnknownFormatException, DateInsaneException{

        return FormatterMakerUtil.getFormatterFactory(format).createFormatter(format).convertFromFormat(usersDate);
    }
}
