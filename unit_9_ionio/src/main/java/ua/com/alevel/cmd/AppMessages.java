package ua.com.alevel.cmd;

public class AppMessages{

    private AppMessages(){
        System.out.println("it`s mapper class!");
    }

    public static final String HORIZONTAL_BORDER = " ==========================================================\n";
    public static final String VERTICAL_BORDER = "|                                                          |\n";
    public static final String WELCOMING = "|----------------------Hello, user!------------------------|\n";
    public static final String MAIN_DESCRIPTION = "|----Enter \'s\' to start creating your new bookshelf!-------|\n";
    public static final String STOP_PROGRAM = "|----Or enter \'q\' to exit!---------------------------------|\n";

    public static final String INCORRECT_INPUT = "|------------Incorrect input. Try Again..------------------|\n";
    public static final String ARRAY_EXCEPTION_OUT_OF_BOUNDS = "You out of MyArrayListImpl bounds!\n";

    public static final String CREATE_NEW_BOOK = "1\t if you want to add new book on your Bookshelf\n";
    public static final String FIND_BOOK = "2\t if you wanna find book by id\n";
    public static final String FIND_ALL_BOOKS = "3\t if you wanna see all your books\n";
    public static final String UPDATE_BOOK = "4\t if you want to update some book info\n";
    public static final String DELETE_BOOK = "5\t if you want to delete book from your Bookshelf\n";
    public static final String CREATE_NEW_AUTHOR = "6\t if you want to add new author in your catalogue\n";
    public static final String FIND_AUTHOR = "7\t if you wanna find author by id\n";
    public static final String FIND_ALL_AUTHORS = "8\t if you wanna find all authors\n";
    public static final String UPDATE_AUTHOR = "9\t if you want to update author\n";
    public static final String DELETE_AUTHOR = "10\t if you want to delete author from your catalogue\n";
    public static final String ASK_TO_EXIT_BY_0 = "0\t if you want to exit\n";
    public static final String EXIT_BY_Q = "q";
    public static final String SPACE = " ";
    public static final String NO_SPACE = " ";

    public static final String ASK_TO_ENTER_ID = "Please, enter id..";
    public static final String ASK_TO_ENTER_TITLE = "Please, enter title..";
    public static final String ASK_TO_ENTER_AUTHOR = "Please, enter authors:";
    public static final String ASK_TO_ENTER_ANOTHER_AUTHOR_OR_QUIT = "Enter 'q' if you have already added all authors " +
            "or 'c' to continue!";
    public static final String ASK_TO_ENTER_PUBLISHER = "Please, enter Publisher";
    public static final String ASK_TO_ENTER_PAGES = "Please, enter Number Of Pages";
    public static final String ASK_TO_ENTER_FIRST_NAME = "Please, enter firs name..";
    public static final String ASK_TO_ENTER_LAST_NAME = "Please, enter last name..";

    public static final String WARN_INCORRECT_ID = "Wrong! Need a correct id number";
    public static final String WARN_INCORRECT_TITLE = "Title should not consist of numbers only!";
    public static final String WARN_INCORRECT_PUBLISHER = "Publisher should not consist of numbers only!";
    public static final String WARN_INCORRECT_PAGES = "Wrong! Need a correct number of pages!";
    public static final String WARN_INCORRECT_FIRST_LAST_NAME = "Last name can not be like first name!";
    public static final String WARN_INCORRECT_FIRST_NAME = "Wrong! Print correct first name in formatter 'Anton'!";
    public static final String WARN_INCORRECT_FIRST_NAME_SIZE = "Out of allowed size for name!";
    public static final String WARN_INCORRECT_LAST_NAME = "Wrong! Print correct last name in formatter 'Sentsov'!";
    public static final String WARN_INCORRECT_LAST_NAME_SIZE = "Out of allowed size for last name!";

    public static final String REGEX_FOR_ID = "^[0-9]+$";
    public static final String REGEX_IT_IS_NOT_A_TITLE = "^[0-9]+$";
    public static final String REGEX_IT_IS_NOT_A_PUBLISHER = "^[0-9]+$";
    public static final String REGEX_FOR_PAGES = "^[1-9][0-9]+$";
    public static final String REGEX_FOR_NAME = "^[A-Z][a-z]+$";

    public static final int MAX_SIZE_OF_NAME = 15;
    public static final int MAX_SIZE_OF_LAST_NAME = 20;
    public static final int MIN_SIZE_OF_NAME = 2;
    public static final int MAX_NUM_OF_PAGES = 4;
}
