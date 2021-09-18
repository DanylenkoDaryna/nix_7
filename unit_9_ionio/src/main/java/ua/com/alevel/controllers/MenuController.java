package ua.com.alevel.controllers;

import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;

public class MenuController{

    private MenuController(){
        System.out.println("This is util class");
    }

    private static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.INCORRECT_INPUT);
    }

    public static void startAppMenu(App9Controller controller){
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            Menu.showMainMenu();
            String inputValue = App9Controller.getUsersPreEditedCommand();
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

    static void chooseOption(App9Controller controller){
        boolean cycleBreaker = true;
        while(cycleBreaker){
            Menu.showMenuItems();
            String input = App9Controller.getUsersPreEditedCommand();
            switch(input){
                case "1":
                    controller.createBook();
                    break;
                case "2":
                    controller.findBook();
                    break;
                case "3":
                    controller.findAllBooks();
                    break;
                case "4":
                    controller.updateBook();
                    break;
                case "5":
                    controller.deleteBook();
                    break;
                case "6":
                    controller.createAuthor();
                    break;
                case "7":
                    controller.findAuthor();
                    break;
                case "8":
                    controller.findAllAuthors();
                    break;
                case "9":
                    controller.updateAuthor();
                    break;
                case "10":
                    controller.deleteAuthor();
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