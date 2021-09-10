package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.facade.BookFacade;
import ua.com.alevel.facade.Facade;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.AuthorServiceImpl;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class App9Controller{

    private static Scanner scanner;
    private final Facade bookFacade = ObjectFactory.getInstance().getImplClass(Facade.class);
    private final BookService bookService = ObjectFactory.getInstance().getImplClass(BookService.class);
    private final AuthorService authorService = ObjectFactory.getInstance().getImplClass(AuthorService.class);
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    private static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }else
            return scanner;
    }

    private static BufferedReader getReader(){
        BufferedReader mainReader = null;
        try{
            mainReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }catch(UnsupportedEncodingException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return mainReader;
    }

    public static String getUsersPreEditedCommand(){
        //return getScanner().nextLine().trim().toLowerCase().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        try{
            return getReader().readLine().trim().toLowerCase().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return getUsersPreEditedCommand();
        }
    }

    public static String getUsersPreEditedInput(){
        try{
            return getReader().readLine().trim();
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return getUsersPreEditedInput();
        }
    }

    public void startApp(){
        MenuController.startAppMenu(this);
    }

    void checkMenuInput(){
        MenuController.chooseOption(this);
    }


    void createBook(){
        String title = enterBookTitle();
        MyArrayListImpl<Author> authors = enterAuthors();
        String publisher = enterPublisher();
        int pages = Integer.parseInt(enterNumOfPages());
        bookFacade.register(title, authors, publisher, pages);
    }

    private static int enterId(){
        System.out.println(AppMessages.ASK_TO_ENTER_ID);
        String id = getScanner().nextLine().trim().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        return checkId(id);
    }

    private static int checkId(String id){
        if(isIdMatchesRules(id)){
            return Integer.parseInt(id);
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_ID);
            return enterId();
        }
    }

    public static boolean isIdMatchesRules(String id){

        return id.matches(AppMessages.REGEX_FOR_ID);
    }

    private static String enterBookTitle(){
        System.out.println(AppMessages.ASK_TO_ENTER_TITLE);
        String title = getScanner().nextLine().trim();
        return checkBookTitle(title);
    }

    private static String checkBookTitle(String title){
        if(checkTitleNotNums(title)){
            return title;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_TITLE);
            return enterBookTitle();
        }
    }

    public static boolean checkTitleNotNums(String title){
        if(titleMatchesRules(title)){
            return true;
        }
        return false;
    }

    private static boolean titleMatchesRules(String title){
        return !title.matches(AppMessages.REGEX_IT_IS_NOT_A_TITLE);
    }

    private static MyArrayListImpl<Author> enterAuthors(){
        MyArrayListImpl<Author> authors = new MyArrayListImpl<>();
        System.out.println(AppMessages.ASK_TO_ENTER_AUTHOR);
        boolean cyclebreaker = true;
        while(cyclebreaker){
            Author author = makeAuthor();
            authors.add(author);
            System.out.println(AppMessages.ASK_TO_ENTER_ANOTHER_AUTHOR_OR_QUIT);
            String input = getScanner().nextLine().trim();
            if(input.equals(AppMessages.EXIT_BY_Q)){
                cyclebreaker = false;
            }
        }
        return authors;
    }

    private static String enterPublisher(){
        System.out.println(AppMessages.ASK_TO_ENTER_PUBLISHER);
        String publisher = getScanner().nextLine().trim();
        return checkPublisher(publisher);
    }

    private static String checkPublisher(String publisher){
        if(checkPublisherNotNums(publisher)){
            return publisher;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_PUBLISHER);
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
        return !publisher.matches(AppMessages.REGEX_IT_IS_NOT_A_PUBLISHER);
    }

    private static String enterNumOfPages(){
        System.out.println(AppMessages.ASK_TO_ENTER_PAGES);
        String pages = getScanner().nextLine().trim().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        return checkNumOfPages(pages);
    }

    private static String checkNumOfPages(String pages){
        if(pagesMatchTheRules(pages)){
            return pages;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_PAGES);
            return enterNumOfPages();
        }
    }

    public static boolean pagesMatchTheRules(String pages){
        if(!pages.matches(AppMessages.REGEX_FOR_PAGES)){
            return false;
        }else if(pages.length() > AppMessages.MAX_NUM_OF_PAGES){
            return false;
        }
        return true;
    }

    void findBook(){
        int id = enterId();
        try{
            Book book = bookService.read(id);
            System.out.println(book);
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    void FindAllBooks(){
        MyArrayListImpl<Book> allBooks = bookService.findAll();
        System.out.println(allBooks.toString());
    }

    void updateBook(){
        int id = enterId();
        String title = enterBookTitle();
        String publisher = enterPublisher();
        int pages = Integer.parseInt(enterNumOfPages());
        bookFacade.update(id, title, publisher, pages);
    }

    void deleteBook(){
        int id = enterId();
        try{
            bookService.delete(id);
            System.out.println(bookService.findAll());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    void createAuthor(){
        Author author = makeAuthor();
        authorService.create(author);
    }

    private static Author makeAuthor(){
        String firstName = enterFirstName();
        String lastName = enterLastName();
        checkFullName(firstName, lastName);
        StringBuilder fullName = new StringBuilder();
        fullName.append(firstName).append(AppMessages.SPACE).append(lastName);
        return new Author(fullName.toString());
    }

    private static String enterFirstName(){
        System.out.println(AppMessages.ASK_TO_ENTER_FIRST_NAME);
        String firstName = getScanner().nextLine().trim().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        return checkFirstName(firstName);
    }

    private static String enterLastName(){
        System.out.println(AppMessages.ASK_TO_ENTER_LAST_NAME);
        String lastName = getScanner().nextLine().trim().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        return checkLastName(lastName);
    }

    private static void checkFullName(String name, String lastName){
        if(isFullNameFollowRules(name, lastName)){
            return;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_FIRST_LAST_NAME);
            makeAuthor();
        }
    }

    public static boolean isFullNameFollowRules(String name, String lastName){
        return !name.equals(lastName);
    }

    private static String checkFirstName(String name){
        if(isNameFollowRules(name)){
            return name;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_FIRST_NAME);
            return enterFirstName();
        }
    }

    private static String checkLastName(String lastName){
        if(isLastNameFollowRules(lastName)){
            return lastName;
        }else{
            System.out.println(AppMessages.WARN_INCORRECT_LAST_NAME);
            return enterLastName();
        }
    }

    public static boolean isNameFollowRules(String name){
        if(!name.matches(AppMessages.REGEX_FOR_NAME)){
            System.out.println(AppMessages.WARN_INCORRECT_FIRST_NAME);
            return false;
        }else if(name.length() > AppMessages.MAX_SIZE_OF_NAME ||
                name.length() < AppMessages.MIN_SIZE_OF_NAME){
            System.out.println(AppMessages.WARN_INCORRECT_FIRST_NAME_SIZE);
            return false;
        }
        return true;
    }

    public static boolean isLastNameFollowRules(String name){
        if(!name.matches(AppMessages.REGEX_FOR_NAME)){
            System.out.println(AppMessages.WARN_INCORRECT_LAST_NAME);
            return false;
        }else if(name.length() > AppMessages.MAX_SIZE_OF_LAST_NAME ||
                name.length() < AppMessages.MIN_SIZE_OF_NAME){
            System.out.println(AppMessages.WARN_INCORRECT_LAST_NAME_SIZE);
            return false;
        }
        return true;
    }

    void findAuthor(){
        int id = enterId();
        try{
            Author author = authorService.read(id);
            System.out.println(author);
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            //MenuController.startAppMenu();
        }
    }

    void FindAllAuthors(){
        MyArrayListImpl<Author> allAuthors = authorService.findAll();
        System.out.println(allAuthors.toString());
    }

    void updateAuthor(){
        int id = enterId();
        Author author = makeAuthor();
        author.setId(id);
        authorService.update(author);
    }

    void deleteAuthor(){
        int id = enterId();
        try{
            authorService.delete(id);
            System.out.println(authorService.findAll());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }
}
