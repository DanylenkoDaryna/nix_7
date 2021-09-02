package ua.com.alevel.controllers;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.db.MathSet;

import static ua.com.alevel.controllers.MainController.getMaxFromMathSet;

public class MenuController{

    public static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.WARN_INCORRECT_INPUT);
    }

    public static void startAppMenu(){
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            Menu.startAppMenuShow();
            String inputValue = MainController.getUsersPreEditedCommand();
            switch(inputValue){
                case "s":
                    chooseMathSetOperations();
                    break;
                case AppMessages.CHOOSE_TO_EXIT_BY_Q:
                    System.exit(0);
                    break;
                default:
                    Menu.notifyOfIncorrectInput();
                    break;
            }
        }
    }

    private static void chooseMathSetOperations(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showMathSetOperations();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    addSmthToMathSetMenu();
                    break;
                case "2":
                    sortMathSetMenu();
                    break;
                case "3":
                    getMathSetMenu();
                    break;
                case "4":
                    mathSetToArrayMenu();
                    break;
                case "5":
                    clearMathSetMenu();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    private static void clearMathSetMenu(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showMathSetClear();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    MainController.clearMathSet();
                    break;
                case "2":
                    MainController.clearNumsInMathSet();
                    break;
                case "3":
                    MainController.cutMathSet();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }


    private static void mathSetToArrayMenu(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showMathSetToArray();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    MainController.toFullArray();
                    break;
                case "2":
                    MainController.toPartArray();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    private static void getMathSetMenu(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showGetMathSet();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    MainController.getFromMathSet();
                    break;
                case "2":
                    getMaxFromMathSet();
                    break;
                case "3":
                    MainController.getMinFromMathSet();
                    break;
                case "4":
                    MainController.getAverageFromMathSet();
                    break;
                case "5":
                    MainController.getMedianFromMathSet();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    private static void sortMathSetMenu(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showSortMathSet();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    MainController.sortDescMathSet();
                    break;
                case "2":
                    MainController.sortDescBetweenMathSet();
                    break;
                case "3":
                    MainController.sortDescMathSetByValue();
                    break;
                case "4":
                    MainController.sortAscMathSet();
                    break;
                case "5":
                    MainController.sortAscBetweenMathSet();
                    break;
                case "6":
                    MainController.sortAscMathSetByValue();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    static void addSmthToMathSetMenu(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showAddToMathSet();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    MainController.addNumToMathSet();
                    break;
                case "2":
                    MainController.addNumsToMathSet();
                    break;
                case "3":
                    MainController.joinMathSet();
                    break;
                case "4":
                    MainController.joinMathSets();
                    break;
                case "5":
                    MainController.intersectionMathSet();
                    break;
                case "6":
                    MainController.intersectionMathSets();
                    break;
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
    }

    static MathSet<Number> createMathSetMenu() throws NoSuchMethodException{
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.createMathSet();
            String input = MainController.getUsersPreEditedCommand();
            switch(input){
                case "0":
                    cycleBreaker = false;
                    break;
                case "1":
                    return MainController.createMathSet();
                case "2":
                    return MainController.createMathSetCapacity();
                case "3":
                    return MainController.createMathSetWithArray();
                case "4":
                    return MainController.createMathSetWithArrays();
                case "5":
                    return MainController.createMathSetWithMathSet();
                case "6":
                    return MainController.createMathSetWithMathSets();
                default:
                    System.out.println(AppMessages.WARN_INCORRECT_INPUT);
            }
        }
        throw new NoSuchMethodException("There is no such method");
    }
}
