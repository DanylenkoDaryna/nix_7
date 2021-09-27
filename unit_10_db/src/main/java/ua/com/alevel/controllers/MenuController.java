package ua.com.alevel.controllers;

import ua.com.alevel.cmd.Messages10;

public class MenuController{

    private MenuController(){
        System.out.println("This is mapper class");
    }

    private static void notifyOfIncorrectInput(){
        System.out.println(Messages10.INCORRECT_INPUT);
    }

//    public static void startAppMenu(App10Controller controller){
//        boolean menuCycleBreaker = true;
//        while(menuCycleBreaker){
//            Menu.showMainMenu();
//            String inputValue = controller.getUsersPreEditedCommand();
//            switch(inputValue){
//                case "s":
//                    controller.checkMenuInput();
//                    break;
//                case "q":
//                    System.exit(0);
//                    break;
//                default:
//                    notifyOfIncorrectInput();
//                    break;
//            }
//        }
//    }
//
//
//    static void chooseOption(){
//        boolean cycleBreaker = true;
//        while(cycleBreaker){
//            Menu.showMenuItems();
//            String input = App10Controller.getUsersPreEditedCommand();
//            switch(input){
//                case "1":
//                    new DateFormatterController().formatDates();
//                    break;
//                case "2":
//                    new NameFinderController().findName();
//                    break;
//                case "3":
//                    new PathSearcherController().findCheapestPath();
//                    break;
//                case "0":
//                    cycleBreaker = false;
//                    break;
//                default:
//                    System.out.println(AppMessages.INCORRECT_INPUT);
//            }
//        }
//    }
}
