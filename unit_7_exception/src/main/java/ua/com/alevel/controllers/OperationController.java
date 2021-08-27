package ua.com.alevel.controllers;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.exceptions.CalendarFalseDateException;
import ua.com.alevel.util.CheckerDateFormatUtil;
import ua.com.alevel.util.ConverterToDateUtil;
import ua.com.alevel.util.DateFormatterUtil;
import ua.com.alevel.util.DateManipulationUtil;
import ua.com.alevel.controllers.CalendarController;

import java.util.Set;
import java.util.TreeSet;


public class OperationController{

    public static void plusYears(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input years");
        String year = CalendarController.getUsersPreEditedInput();
        if(checkYearCorrect(year)){
            CalendarDate result = DateManipulationUtil.plusYear(calendarDate, Integer.parseInt(year));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusYears();
        }
    }

    private static boolean checkYearCorrect(String year){
        if(year.matches("^[0-9]{1,4}$")){
            return true;
        }else return false;
    }

    public static void plusDays(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input days");
        String day = CalendarController.getUsersPreEditedInput();
        if(checkDayCorrect(day)){
            CalendarDate result = DateManipulationUtil.plusDay(calendarDate, Integer.parseInt(day));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusDays();
        }
    }

    private static boolean checkDayCorrect(String day){
        if(day.matches("^[0-9]{1,5}$")){
            return true;
        }else return false;
    }

    public static void plusHours(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input hours:");
        String hours = CalendarController.getUsersPreEditedInput();
        if(checkHoursCorrect(hours)){
            CalendarDate result = DateManipulationUtil.plusHours(calendarDate, Integer.parseInt(hours));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusHours();
        }
    }

    private static boolean checkHoursCorrect(String hours){
        if(hours.matches("^[0-9]{1,5}$")){
            return true;
        }else return false;
    }

    public static void plusMinutes(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input minutes:");
        String minutes = CalendarController.getUsersPreEditedInput();
        if(checkMinutesCorrect(minutes)){
            CalendarDate result = DateManipulationUtil.plusMinutes(calendarDate, Integer.parseInt(minutes));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusMinutes();
        }
    }

    private static boolean checkMinutesCorrect(String minutes){
        if(minutes.matches("^[0-9]{1,8}$")){
            return true;
        }else return false;
    }

    public static void plusSec(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input seconds");
        String seconds = CalendarController.getUsersPreEditedInput();
        if(checkSecondsCorrect(seconds)){
            CalendarDate result = DateManipulationUtil.plusSeconds(calendarDate, Integer.parseInt(seconds));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusSec();
        }
    }

    private static boolean checkSecondsCorrect(String seconds){
        if(seconds.matches("^[0-9]{1,9}$")){
            return true;
        }else return false;
    }

    public static void plusMills(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input milliseconds:");
        String milliseconds = CalendarController.getUsersPreEditedInput();
        if(checkMillisecondsCorrect(milliseconds)){
            CalendarDate result = DateManipulationUtil.plusMilliseconds(calendarDate, Integer.parseInt(milliseconds));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            plusMills();
        }
    }

    private static boolean checkMillisecondsCorrect(String milliseconds){
        if(milliseconds.matches("^[0-9]{1,10}$")){
            return true;
        }else return false;
    }

    public static void minusYears(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input years");
        String year = CalendarController.getUsersPreEditedInput();
        if(checkYearCorrect(year)){
            CalendarDate result = DateManipulationUtil.minusYear(calendarDate, Integer.parseInt(year));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusYears();
        }
    }

    public static void minusDays(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input days");
        String day = CalendarController.getUsersPreEditedInput();
        if(checkDayCorrect(day)){
            CalendarDate result = DateManipulationUtil.minusDay(calendarDate, Integer.parseInt(day));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusDays();
        }
    }

    public static void minusHours(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input hours:");
        String hours = CalendarController.getUsersPreEditedInput();
        if(checkHoursCorrect(hours)){
            CalendarDate result = DateManipulationUtil.minusHours(calendarDate, Integer.parseInt(hours));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusHours();
        }
    }

    public static void minusMinutes(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input minutes:");
        String minutes = CalendarController.getUsersPreEditedInput();
        if(checkMinutesCorrect(minutes)){
            CalendarDate result = DateManipulationUtil.minusMinutes(calendarDate, Integer.parseInt(minutes));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusMinutes();
        }
    }

    public static void minusSec(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input seconds:");
        String seconds = CalendarController.getUsersPreEditedInput();
        if(checkSecondsCorrect(seconds)){
            CalendarDate result = DateManipulationUtil.minusSeconds(calendarDate, Integer.parseInt(seconds));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusSec();
        }
    }

    public static void minusMills(){
        CalendarDate calendarDate = CalendarController.inputDate();
        System.out.println("Input milliseconds:");
        String milliseconds = CalendarController.getUsersPreEditedInput();
        if(checkMillisecondsCorrect(milliseconds)){
            CalendarDate result = DateManipulationUtil.minusMilliseconds(calendarDate, Integer.parseInt(milliseconds));
            DateFormatterUtil.showInStandardFormat(result);
        }else{
            Menu.notifyOfIncorrectInput();
            minusMills();
        }
    }

    private static long findDifference(){
        System.out.println("Input first date:");
        CalendarDate calendarDate1 = CalendarController.inputDate();
        System.out.println("Input second date:");
        CalendarDate calendarDate2 = CalendarController.inputDate();
        return DateManipulationUtil.findDifference(calendarDate1, calendarDate2);
    }

    public static void findDiffInYears(){
        long result = findDifference();
        System.out.println(ConverterToDateUtil.toYears(result));
    }

    public static void findDiffInDays(){
        long result = findDifference();
        System.out.println(ConverterToDateUtil.toDays(result));
    }

    public static void findDiffInHours(){
        long result = findDifference();
        System.out.println(ConverterToDateUtil.toHours(result));
    }

    public static void findDiffInMinutes(){
        long result = findDifference();
        System.out.println(ConverterToDateUtil.toMinutes(result));
    }

    public static void findDiffInSec(){
        long result = findDifference();
        System.out.println(ConverterToDateUtil.toSeconds(result));
    }

    public static void findDiffInMills(){
        System.out.println(findDifference());
    }

    public static void sortDates() throws CalendarFalseDateException{
        Set<CalendarDate> dates = new TreeSet<>();
        CalendarDate date = CalendarController.inputDate();
        dates.add(date);
        boolean cycleBreaker = true;
        while(cycleBreaker){
            System.out.println(AppMessages.ASK_TO_ENTER_ANOTHER_DATE_OR_QUIT);
            String input = CalendarController.getUsersPreEditedInput();
            if(input.equals("q")){
                cycleBreaker = false;
            }else{
                if(CheckerDateFormatUtil.checkDateCorrect(input)){
                    CalendarDate tempDate = CalendarController.convertToDate(input);
                    boolean added = dates.add(tempDate);
                    System.out.println(added);
                }else{
                    throw new CalendarFalseDateException();
                }
            }
        }
        System.out.println(AppMessages.ASC_SORT + AppMessages.DESC_SORT);
        String input = CalendarController.getUsersPreEditedCommand();
        if(input.equals("1")){
            System.out.println(doAscSort(dates));
        }
        if(input.equals("2")){
            System.out.println(doDescSort(dates));
        }else{
            Menu.notifyOfIncorrectInput();
            sortDates();
        }
    }

    public static String doDescSort(Set<CalendarDate> dates){
        StringBuilder stringBuilder = new StringBuilder();
        Object[] toReverse = dates.toArray();
        for(int i = toReverse.length - 1; i >= 0; i--){
            stringBuilder.append(DateFormatterUtil.showInStandardFormat((CalendarDate) toReverse[i])
            ).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String doAscSort(Set<CalendarDate> dates){
        StringBuilder stringBuilder = new StringBuilder();
        for(CalendarDate iterator : dates){
            stringBuilder.append(DateFormatterUtil.showInStandardFormat(iterator)).append("\n");
        }
        return stringBuilder.toString();

    }

}