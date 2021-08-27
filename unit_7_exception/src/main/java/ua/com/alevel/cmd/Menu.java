package ua.com.alevel.cmd;


public class Menu{
    public static void show(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.WELCOMING
                + AppMessages.MAIN_DESCRIPTION
                + AppMessages.STOP_PROGRAM
                + AppMessages.HORIZONTAL_BORDER);
    }

    public static void showInputDateMenu(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.CHOOSE_TO_ENTER_FORMAT
                + AppMessages.CHOOSE_TO_ENTER_DATE
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void showDateOperations(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.CHOOSE_TO_FIND_DIFFERENCE
                + AppMessages.CHOOSE_TO_SUM_DATES
                + AppMessages.CHOOSE_TO_SUBSTRACT_DATES
                + AppMessages.CHOOSE_TO_SORT_DATES
                + AppMessages.CHOOSE_TO_SHOW_DATE
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.WARN_INCORRECT_INPUT);
    }

    public static void menuForSorting(){
        System.out.println(AppMessages.SORT_DATES);

    }

    public static void menuForSubstract(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.MINUS_YEARS
                + AppMessages.MINUS_DAYS
                + AppMessages.MINUS_HOURS
                + AppMessages.MINUS_MINS
                + AppMessages.MINUS_SEC
                + AppMessages.MINUS_MILLS
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void menuForAdding(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.ADD_YEARS
                + AppMessages.ADD_DAYS
                + AppMessages.ADD_HOURS
                + AppMessages.ADD_MINS
                + AppMessages.ADD_SEC
                + AppMessages.ADD_MILLS
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void menuForDifference(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.DIFFERENCE_IN_YEARS
                + AppMessages.DIFFERENCE_IN_DAYS
                + AppMessages.DIFFERENCE_IN_HOURS
                + AppMessages.DIFFERENCE_IN_MINS
                + AppMessages.DIFFERENCE_IN_SEC
                + AppMessages.DIFFERENCE_IN_MILLS
                + AppMessages.ASK_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }
}
