package ua.com.alevel.cmd;


public class Menu{

    private Menu(){
        System.out.println("it`s util class!");
    }

    public static void showMainMenu(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.VERTICAL_BORDER
                + AppMessages.WELCOMING
                + AppMessages.MAIN_DESCRIPTION
                + AppMessages.STOP_PROGRAM
                + AppMessages.VERTICAL_BORDER
                + AppMessages.HORIZONTAL_BORDER);
    }

    public static void showMenuItems(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.CREATE_NEW_BOOK
                + AppMessages.FIND_BOOK
                + AppMessages.FIND_ALL_BOOKS
                + AppMessages.UPDATE_BOOK
                + AppMessages.DELETE_BOOK
                + AppMessages.CREATE_NEW_AUTHOR
                + AppMessages.FIND_AUTHOR
                + AppMessages.FIND_ALL_AUTHORS
                + AppMessages.UPDATE_AUTHOR
                + AppMessages.DELETE_AUTHOR
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER);
    }
}