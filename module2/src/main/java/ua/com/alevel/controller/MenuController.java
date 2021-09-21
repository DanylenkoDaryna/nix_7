package ua.com.alevel.controller;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;

public class MenuController{

    private MenuController(){
        System.out.println("This is util class");
    }

    private static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.INCORRECT_INPUT);
    }

    public static void startAppMenu(Module2Controller controller){
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            Menu.showMainMenu();
            String inputValue = controller.getUsersPreEditedCommand();
            switch(inputValue){
                case "s":
                    controller.checkMenuInput();
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    notifyOfIncorrectInput();
                    break;
            }
        }
    }


    static void chooseOption(){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showMenuItems();
            String input = Module2Controller.getUsersPreEditedCommand();
            switch(input){
                case "1":
                    new DateFormatterController().formatDates();
                    break;
                case "2":
                    new NameFinderController().findName();
                    break;
                case "3":
                    new PathSearcherController().findCheapestPath();
                    break;
                case "0":
                    cycleBreaker = false;
                    break;
                default:
                    System.out.println(AppMessages.INCORRECT_INPUT);
            }
        }
    }
}
