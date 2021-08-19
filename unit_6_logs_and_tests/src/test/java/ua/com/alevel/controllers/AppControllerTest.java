package ua.com.alevel.controllers;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppControllerTest{

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    @Test
    @Order(1)
    public void checkScannerNotNull(){
        LOGGER_INFO.info("test 1");
        assert (AppController.takeScanner() != null);
    }

    @Test
    @Order(2)
    public void checkBookTitleIsCorrect(){
        LOGGER_INFO.info("test 2");
        boolean result = AppController.checkTitleNotNums("test sdf");
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

    @Test
    @Order(22)
    public void checkIdIsCorrect(){
        boolean result = AppController.isIdMatchesRules("35");
        assert (result==true);
    }

    @Test
    @Order(23)
    public void checkIdIsIncorrect(){
        boolean result = AppController.isIdMatchesRules("id");
        assert (result==false);
    }
}