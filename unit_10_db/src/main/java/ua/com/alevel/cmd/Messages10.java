package ua.com.alevel.cmd;

import java.util.ArrayList;

public class Messages10{

    private static ArrayList<String> menuList;

    public static final String HORIZONTAL_BORDER = " ==========================================================\n";
    public static final String VERTICAL_BORDER = "|                                                          |\n";
    public static final String WELCOMING = "|----------------------Hello, user!------------------------|\n";
    public static final String MAIN_DESCRIPTION = "|----Enter \'s\' to start creating your new bookshelf!-------|\n";
    public static final String STOP_PROGRAM = "|----Or enter \'q\' to quit!---------------------------------|\n";
    public static final String INCORRECT_INPUT = "|------------Incorrect input. Try Again..------------------|\n";

    private static final String FILTER_DATES = "1\t if you want to filter dates\n";
    private static final String SORT_NAMES = "2\t if you wanna sort names\n";
    private static final String FIND_CHEAPEST_PATH = "3\t if you wanna find the cheapest path between cities\n";

    public static final String ASK_TO_QUIT_BY_0 = "0\t if you want to quit\n";
    public static final String SPACE = " ";
    public static final String NO_SPACE = "";

    public static final int OFFSET_CUZ_ARRAY_STARTS_WITH_ZERO = 1;
    public static final int CITY_OF_DEPARTURE = 0;
    public static final int CITY_OF_DESTINATION = 1;
    public static final int MAX_PATH_COST = 200000;

    static{
        menuList = new ArrayList<>();
        menuList.add(Messages10.FILTER_DATES);
        menuList.add(Messages10.SORT_NAMES);
        menuList.add(Messages10.FIND_CHEAPEST_PATH);
    }

    private Messages10(){
        System.out.println("it`s mapper class!");
    }

    public static ArrayList<String> getMenuList(){
        return menuList;
    }

}