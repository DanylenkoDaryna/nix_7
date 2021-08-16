package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.facade.BookFacade;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.AuthorServiceImpl;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.BookServiceImpl;

import java.util.Scanner;

public class AppController{

    private static Scanner scanner;
    private static final BookService bookService = new BookServiceImpl();
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final BookFacade bookFacade = new BookFacade();
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    private static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }else
            return scanner;
    }

    public static Scanner takeScanner(){
        return getScanner();
    }

    public static void startApp(){
        Scanner scanner = AppController.takeScanner();
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            AppController.showMainMenu();
            String inputValue = scanner.nextLine().trim();
            switch(inputValue){
                case "s":
                    AppController.checkMenuInput();
                    break;
                case "q":
                    menuCycleBreaker = false;
                    break;
                default:
                    AppController.notifyOfIncorrectInput();
                    break;
            }
        }
    }

    public static void showMainMenu(){
        LOGGER_INFO.error("start main menu");
        Menu.show();
    }

    public static void checkMenuInput(){
        showMenuItems();
        boolean cycleBreaker = true;
        while(cycleBreaker){
            String inputValue = takeScanner().nextLine().replaceAll(" ", "");
            cycleBreaker = chooseOption(inputValue);
        }
    }

    public static void notifyOfIncorrectInput(){
        System.out.println(AppMessages.INCORRECT_INPUT);
    }

    private static void showMenuItems(){
        System.out.println(AppMessages.HORIZONTAL_BORDER +
                AppMessages.CREATE_NEW_BOOK +
                AppMessages.FIND_BOOK +
                AppMessages.FIND_ALL_BOOKS +
                AppMessages.UPDATE_BOOK +
                AppMessages.DELETE_BOOK +
                AppMessages.CREATE_NEW_AUTHOR +
                AppMessages.FIND_AUTHOR +
                AppMessages.FIND_ALL_AUTHORS +
                AppMessages.UPDATE_AUTHOR +
                AppMessages.DELETE_AUTHOR +
                AppMessages.EXIT);
    }

    public static boolean chooseOption(String option){
        switch(option){
            case "1":
                createBook();
                break;
            case "2":
                findBook();
                break;
            case "3":
                FindAllBooks();
                break;
            case "4":
                updateBook();
                break;
            case "5":
                deleteBook();
                break;
            case "6":
                createAuthor();
                break;
            case "7":
                findAuthor();
                break;
            case "8":
                FindAllAuthors();
                break;
            case "9":
                updateAuthor();
                break;
            case "10":
                deleteAuthor();
                break;
            case "0":
                return false;
            default:{
                System.out.println(AppMessages.INCORRECT_INPUT);
                showMenuItems();
                return true;
            }
        }
        return false;
    }

    private static void createBook(){
        String title = enterBookTitle();
        MyArrayListImpl<Author> authors = enterAuthors();
        String publisher = enterPublisher();
        int pages = Integer.parseInt(enterNumOfPages());
        bookFacade.register(title, authors, publisher, pages);

    }

    private static int enterId(){
        System.out.println("Please, enter id..");
        String id = getScanner().nextLine().trim().replaceAll(" ", "");
        if(id.matches("^[0-9]+$")){
            return Integer.parseInt(id);
        }else{
            System.out.println("Wrong! Need a correct id number");
            return enterId();
        }
    }

    private static String enterBookTitle(){
        System.out.println("Please, enter title");
        String title = getScanner().nextLine().trim();
        checkBookTitle(title);
        return title;
    }

    public static void checkBookTitle(String title){

        if(checkTitleNotNums(title)){
            return;
        }else{
            System.out.println("Title should not consist of numbers only!");
            enterBookTitle();
        }
    }

    public static boolean checkTitleNotNums(String title){

        if(titleMatchesRules(title)){
            return true;
        }
        return false;
    }

    private static boolean titleMatchesRules(String title){

        return !title.matches("^[0-9]+$");
    }

    private static MyArrayListImpl<Author> enterAuthors(){
        MyArrayListImpl<Author> authors = new MyArrayListImpl<>();
        System.out.println("Please, enter authors like 'author1' or 'q' ");
        boolean cyclebreaker = true;
        while(cyclebreaker){
            Author author = makeAuthor();
            authors.add(author);
            System.out.println("Enter 'q' when you added al the authors or 'c' to continue!");
            String input = getScanner().nextLine().trim();
            if(input.equals("q")){
                cyclebreaker = false;
            }
        }
        return authors;
    }

    private static String enterPublisher(){
        System.out.println("Please, enter Publisher");
        String publisher = getScanner().nextLine().trim();
        return checkPublisher(publisher);
    }

    public static String checkPublisher(String publisher){
        if(checkPublisherNotNums(publisher)){
            return publisher;
        }else{
            System.out.println("publisher should not consist of numbers only!");
             return enterPublisher();
        }
    }

    public static boolean checkPublisherNotNums(String publisher){
        if(publisherMatchesRules(publisher)){
            return true;
        }
        return false;
    }

    private static boolean publisherMatchesRules(String publisher){

        return !publisher.matches("^[0-9]+$");
    }

    private static String enterNumOfPages(){
        System.out.println("Please, enter Number Of Pages");
        String pages = getScanner().nextLine().trim().replaceAll(" ", "");
        return checkNumOfPages(pages);
    }

    public static String checkNumOfPages(String pages){
        if(pagesMatchTheRules(pages)){
            return pages;
        }else{
            System.out.println("Wrong! Need a correct number");
            return enterNumOfPages();
        }
    }

    public static boolean pagesMatchTheRules(String pages){
        if(!pages.matches("^[1-9][0-9]+$")){
            return false;
        }else if(pages.length() > AppMessages.MAX_NUM_OF_PAGES){
            return false;
        }
        return true;
    }

    private static void findBook(){
        int id = enterId();
        try{
            Book book = bookService.read(id);
            System.out.println(book);
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    private static void FindAllBooks(){
        MyArrayListImpl<Book> allBooks = bookService.findAll();
        System.out.println(allBooks.toString());
    }

    private static void updateBook(){
        int id = enterId();
        String title = enterBookTitle();
        String publisher = enterPublisher();
        int pages = Integer.parseInt(enterNumOfPages());
        bookFacade.update(id, title, publisher, pages);
    }

    private static void deleteBook(){
        int id = enterId();
        try{
            bookService.delete(id);
            System.out.println(bookService.findAll());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    private static void createAuthor(){
        Author author = makeAuthor();
        authorService.create(author);
    }

    private static Author makeAuthor(){
        String firstName = enterFirstName();
        String lastName = enterLastName();
        checkFullName(firstName, lastName);
        StringBuilder fullName = new StringBuilder();
        fullName.append(firstName).append(" ").append(lastName);
        return new Author(fullName.toString());
    }

    private static String enterFirstName(){
        System.out.println("Please, enter firs name..");
        String firstName = getScanner().nextLine().trim().replaceAll(" ", "");
        return checkFirstName(firstName);
    }

    private static String enterLastName(){
        System.out.println("Please, enter last name..");
        String lastName = getScanner().nextLine().trim().replaceAll(" ", "");
        return checkLastName(lastName);
    }

    public static void checkFullName(String name, String lastName){
        if(isFullNameFollowRules(name, lastName)){
            return;
        }else{
            System.out.println("Last name can not be like first name!");
            makeAuthor();
        }
    }

    public static boolean isFullNameFollowRules(String name, String lastName){
        return !name.equals(lastName);
    }

    public static String checkFirstName(String name){
        if(isNameFollowRules(name)){
            return name;
        }else{
            System.out.println("Print name correctly!");
            return enterFirstName();
        }
    }

    public static String checkLastName(String lastName){
        if(isLastNameFollowRules(lastName)){
            return lastName;
        }else{
            System.out.println("Print last Name correctly!");
            return enterLastName();
        }
    }

    public static boolean isNameFollowRules(String name){
        if(!name.matches("^[A-Z][a-z]+$")){
            System.out.println("Print in format 'Anton'!");
            return false;
        }else if(name.length() > AppMessages.MAX_SIZE_OF_NAME){
            System.out.println("Out of allowed size for name!");
            return false;
        }
        return true;
    }

    public static boolean isLastNameFollowRules(String name){
        if(!name.matches("^[A-Z][a-z]+$")){
            System.out.println("Print in format 'Sentsov'!");
            return false;
        }else if(name.length() > AppMessages.MAX_SIZE_OF_LAST_NAME){
            System.out.println("Out of allowed size for last name!");
            return false;
        }
        return true;
    }

    private static void findAuthor(){
        int id = enterId();
        try{
            Author author = authorService.read(id);
            System.out.println(author);
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            showMainMenu();
        }
    }

    private static void FindAllAuthors(){
        MyArrayListImpl<Author> allAuthors = authorService.findAll();
        System.out.println(allAuthors.toString());
    }

    private static void updateAuthor(){
        int id = enterId();
        Author author = makeAuthor();
        author.setId(id);
        authorService.update(author);
    }

    private static void deleteAuthor(){
        int id = enterId();
        try{
            authorService.delete(id);
            System.out.println(authorService.findAll());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

}
