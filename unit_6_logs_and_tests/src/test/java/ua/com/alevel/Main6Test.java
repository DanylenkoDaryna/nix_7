package ua.com.alevel;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import ua.com.alevel.controllers.AppController;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.AuthorServiceImpl;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.BookServiceImpl;

public class Main6Test{

    private static MyArrayListImpl<Book> bookShelf;
    private static MyArrayListImpl<Author> authorCatalogue;
    private static BookService bookService;
    private static AuthorService authorService;

    @BeforeAll
    public void startApp(){
       bookShelf = new MyArrayListImpl<>();
       authorCatalogue = new MyArrayListImpl<>();
       bookService = new BookServiceImpl();
       AuthorService authorService = new AuthorServiceImpl();
    }

    @Test
    @Order(1)
    public void checkScannerNotNull(){
        assert (AppController.takeScanner() != null);
    }

    @Test
    @Order(2)
    public void checkBookTitleIsCorrect(){
        boolean result = AppController.checkTitleNotNums("derril sdf");
        assert (result==true);
    }

    @Test
    @Order(3)
    public void checkBookTitleIsNotCorrect(){
        boolean result = AppController.checkTitleNotNums("1222345");
        assert (result==false);

    }

    @Test
    @Order(4)
    public void checkPublisherIsCorrect(){
        boolean result = AppController.checkPublisherNotNums("Vivat");
        assert (result==true);
    }

    @Test
    @Order(5)
    public void checkPublisherIsCorrect2(){
        boolean result = AppController.checkPublisherNotNums("Vivat-500");
        assert (result==true);
    }

    @Test
    @Order(6)
    public void checkPublisherIsNotCorrect(){
        boolean result = AppController.checkPublisherNotNums("1222345");
        assert (result==false);

    }

    @Test
    @Order(7)
    public void checkPagesAreCorrect(){
        boolean result = AppController.pagesMatchTheRules("344");
        assert (result==true);
    }

    @Test
    @Order(8)
    public void checkPagesAreNotCorrect(){
        boolean result = AppController.pagesMatchTheRules("abs");
        assert (result==false);

    }

    @Test
    @Order(12)
    public void checkPagesAreNotCorrect2(){
        boolean result = AppController.pagesMatchTheRules("22a");
        assert (result==false);

    }

    @Test
    @Order(9)
    public void checkifPagesAreZero(){
        boolean result = AppController.pagesMatchTheRules("0");
        assert (result==false);

    }

    @Test
    @Order(10)
    public void checkIfPagesLessZero(){
        boolean result = AppController.pagesMatchTheRules("-76");
        assert (result==false);

    }

    @Test
    @Order(11)
    public void checkIfPagesMoreThen1000(){
        boolean result = AppController.pagesMatchTheRules(String.valueOf(Integer.MAX_VALUE));
        assert (result==false);

    }

    @Test
    @Order(12)
    public void checkFirstNameIsCorrect(){
        boolean result = AppController.isNameFollowRules("Loki");
        assert (result==true);
    }

    @Test
    @Order(13)
    public void checkFirstNameIsIncorrectWhenNumber(){
        boolean result = AppController.isNameFollowRules("112244");
        assert (result==false);
    }

    @Test
    @Order(14)
    public void checkFirstNameIsIncorrectWhenLong(){
        boolean result = AppController.isNameFollowRules("Seddfyvbhdbfbfhasdfbhba");
        assert (result==false);
    }

    @Test
    @Order(15)
    public void checkFirstNameIsIncorrectWhenFirstLetterSmall(){
        boolean result = AppController.isNameFollowRules("loki");
        assert (result==false);
    }

    @Test
    @Order(16)
    public void checkLastNameIsCorrect(){
        boolean result = AppController.isLastNameFollowRules("Lafeison");
        assert (result==true);
    }

    @Test
    @Order(17)
    public void checkLastNameIsIncorrectWhenNumber(){
        boolean result = AppController.isLastNameFollowRules("112244");
        assert (result==false);
    }

    @Test
    @Order(18)
    public void checkLastNameIsIncorrectWhenLong(){
        boolean result = AppController.isLastNameFollowRules("Seddfyvbhdbfbfhasdferrtwertsdafbhba");
        assert (result==false);
    }

    @Test
    @Order(19)
    public void checkLastNameIsIncorrectWhenFirstLetterSmall(){
        boolean result = AppController.isLastNameFollowRules("lafeison");
        assert (result==false);
    }

    @Test
    @Order(20)
    public void checkIfNameNotEqualsSurname(){
        boolean result = AppController.isFullNameFollowRules("Loki","Lafeison");
        assert (result==true);
    }

    @Test
    @Order(21)
    public void checkIfNameEqualsSurname(){
        boolean result = AppController.isFullNameFollowRules("Loki","Loki");
        assert (result==false);
    }

}