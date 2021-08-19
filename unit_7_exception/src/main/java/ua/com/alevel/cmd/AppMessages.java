package ua.com.alevel.cmd;

public class AppMessages{
    public static final String HORIZONTAL_BORDER = " ==========================================================\n";
    public static final String VERTICAL_BORDER = "|                                                          |\n";
    public static final String WELCOMING = "|----------------------Hello, user!------------------------|\n";
    public static final String MAIN_DESCRIPTION = "|----Enter \'s\' to start working with Calendar!-------|\n";
    public static final String STOP_PROGRAM = "|----Or enter \'q\' to exit!---------------------------------|\n";

    public static final String INCORRECT_INPUT = "|------------Incorrect input. Try Again..------------------|\n";

    public static final String CREATE_NEW_BOOK = "if you want to add new book on your Bookshelf, please, enter 1\n";
    public static final String FIND_BOOK = "if you wanna find book by id, please, enter 2\n";
    public static final String FIND_ALL_BOOKS = "if you wanna see all your books, please, enter 3\n";
    public static final String UPDATE_BOOK = "if you want to update some book info, please, enter 4\n";
    public static final String DELETE_BOOK = "if you want to delete book from your Bookshelf, please, enter 5\n";

    public static final String CREATE_NEW_AUTHOR = "if you want to add new author in your catalogue, please, enter 6\n";
    public static final String FIND_AUTHOR = "if you wanna find author by id, please, enter 7\n";
    public static final String FIND_ALL_AUTHORS = "if you wanna find all authors, please, enter 8\n";
    public static final String UPDATE_AUTHOR = "if you want to update author, please, enter 9\n";
    public static final String DELETE_AUTHOR = "if you want to delete author from your catalogue, please, enter 10\n";
    public static final String ASK_TO_EXIT_BY_0 = "if you want to exit, please, enter 0";
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
    public static final String WARN_INCORRECT_FIRST_NAME = "Wrong! Print correct first name in format 'Anton'!";
    public static final String WARN_INCORRECT_FIRST_NAME_SIZE = "Out of allowed size for name!";
    public static final String WARN_INCORRECT_LAST_NAME = "Wrong! Print correct last name in format 'Sentsov'!";
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
