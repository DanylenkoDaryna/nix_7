package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.exceptions.CalendarFalseDateException;
import ua.com.alevel.util.DateFormatterUtil;
import ua.com.alevel.util.DateManipulationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MenuController{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");


    public static void startAppMenu(){
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            Menu.show();
            String inputValue = CalendarController.getUsersPreEditedCommand();
            switch(inputValue){
                case "s":
                    chooseOperationWithDate();
                    break;
                case "q":
                    menuCycleBreaker = false;
                    break;
                default:
                    Menu.notifyOfIncorrectInput();
                    break;
            }
        }
    }

    private static void chooseOperationWithDate(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showDateOperations();
            String input = CalendarController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    findDifferenceInDates();
                    break;
                case "2":
                    addSmthToDate();
                    break;
                case "3":
                    subtractSmthFromDate();
                    break;
                case "4":
                    sortDates();
                    break;
                case "5":
                    showDateInStandard();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    private static void showDateInStandard(){
        System.out.println("showDateInStandard");
        CalendarDate calendarDate1 = CalendarController.inputDate();
        System.out.println(DateFormatterUtil.showInStandardFormat(calendarDate1));
    }

    private static void sortDates(){
        System.out.println("sortDates");
        MenuController.showMenuForSorting();
    }

    private static void subtractSmthFromDate(){
        System.out.println("subtractSmthFromDate");
        MenuController.showMenuForSubstract();
    }

    private static void addSmthToDate(){
        System.out.println("addSmthToDate");
        MenuController.showMenuForAdding();
    }

    private static void findDifferenceInDates(){
        System.out.println("findDifferenceInDates");
        MenuController.showMenuForDifference();
    }

    public static void showMenuForSorting(){
        Menu.menuForSorting();
        try{
            OperationController.sortDates();
        }catch(CalendarFalseDateException e){
            System.out.println(e.getMessage());
            LOGGER_ERR.error(e.getMessage());
            showMenuForSorting();
        }
    }

    public static void showMenuForAdding(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.menuForAdding();
            String input = CalendarController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    OperationController.plusYears();
                    break;
                case "2":
                    OperationController.plusDays();
                    break;
                case "3":
                    OperationController.plusHours();
                    break;
                case "4":
                    OperationController.plusMinutes();
                    break;
                case "5":
                    OperationController.plusSec();
                    break;
                case "6":
                    OperationController.plusMills();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    public static void showMenuForSubstract(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.menuForSubstract();
            String input = CalendarController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    OperationController.minusYears();
                    break;
                case "2":
                    OperationController.minusDays();
                    break;
                case "3":
                    OperationController.minusHours();
                    break;
                case "4":
                    OperationController.minusMinutes();
                    break;
                case "5":
                    OperationController.minusSec();
                    break;
                case "6":
                    OperationController.minusMills();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    public static void showMenuForDifference(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.menuForDifference();
            String input = CalendarController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    OperationController.findDiffInYears();
                    break;
                case "2":
                    OperationController.findDiffInDays();
                    break;
                case "3":
                    OperationController.findDiffInHours();
                    break;
                case "4":
                    OperationController.findDiffInMinutes();
                    break;
                case "5":
                    OperationController.findDiffInSec();
                    break;
                case "6":
                    OperationController.findDiffInMills();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }
}
