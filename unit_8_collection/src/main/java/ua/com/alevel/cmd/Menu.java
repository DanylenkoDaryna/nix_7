package ua.com.alevel.cmd;


public class Menu{
    public static void startAppMenuShow(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.WELCOMING
                + AppMessages.MAIN_DESCRIPTION
                + AppMessages.STOP_PROGRAM
                + AppMessages.HORIZONTAL_BORDER);
    }

    public static void showMathSetOperations(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.ADD_TO_MATHSET
                + AppMessages.SORT_MATHSET
                + AppMessages.GET_FROM_MATHSET
                + AppMessages.MATHSET_TO_ARRAY
                + AppMessages.MATHSET_CLEAR
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.WARN_INCORRECT_INPUT);
    }

    public static void showMathSetClear(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.CLEAR_ALL_MATHSET
                + AppMessages.CLEAR_PART_OF_MATHSET
                + AppMessages.CUT_PART_OF_MATHSET
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void showMathSetToArray(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.GET_ARRAY_FROM_ALL_MATHSET
                + AppMessages.GET_ARRAY_FROM_PART_MATHSET
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void showGetMathSet(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.GET_SMTH_FROM_MATHSET
                + AppMessages.GET_MAX_FROM_MATHSET
                + AppMessages.GET_MIN_FROM_MATHSET
                + AppMessages.GET_AVERAGE_FROM_MATHSET
                + AppMessages.GET_MEDIAN_FROM_MATHSET
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void showSortMathSet(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.SORT_ALL_MATHSET_BY_DESC
                + AppMessages.SORT_PART_BY_DESC
                + AppMessages.SORT_MATHSET_BY_DESC_FROM_VALUE
                + AppMessages.SORT_ALL_MATHSET_BY_ASC
                + AppMessages.SORT_PART_BY_ASC
                + AppMessages.SORT_MATHSET_BY_ASC_FROM_VALUE
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void showAddToMathSet(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.ADD_NUMBER
                + AppMessages.ADD_NUMBERS
                + AppMessages.JOIN_MATHSET
                + AppMessages.JOIN_MATHSETS
                + AppMessages.INTERSECTION_MATHSET
                + AppMessages.INTERSECTION_MATHSETS
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }

    public static void createMathSet(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.CREATING
                + AppMessages.CREATE_EMPTY
                + AppMessages.CREATE_EMPTY_CAPACITY
                + AppMessages.CREATE_WITH_ARRAY
                + AppMessages.CREATE_WITH_ARRAYS
                + AppMessages.CREATE_WITH_MATHSET
                + AppMessages.CREATE_WITH_MATHSETS
                + AppMessages.CHOOSE_TO_EXIT_BY_0
                + AppMessages.HORIZONTAL_BORDER
        );
    }
}
