package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.CalendarController;
import ua.com.alevel.util.CheckerDateFormatUtil;

class TestInputFormat{

    @Order(1)
    @Test
    void checkInputCorrect1(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("dd/mm/yy");
        Assertions.assertEquals(result, true);
    }

    @Order(2)
    @Test
    void checkInputIncorrect1(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("m/d/yyyy");
        Assertions.assertEquals(result, true);
    }

    @Order(3)
    @Test
    void checkByLeapYear(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("mmm-d-yy");
        Assertions.assertEquals(result, true);
    }

    @Order(4)
    @Test
    void checkByFeburaryMonth(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("dd-mmm-yyyy");
        Assertions.assertEquals(result, true);
    }

    @Order(5)
    @Test
    void test5(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("dd-mmm-yyyy00:00:00:000");
        Assertions.assertEquals(result, false);
    }

    @Order(6)
    @Test
    void test6(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("dd-mmm-yyyy 00:00:00:000");
        Assertions.assertEquals(result, true);
    }

    @Order(7)
    @Test
    void test7(){
        boolean result = CheckerDateFormatUtil.checkFormatCorrect("dd-mmm-yyyy 00:00:00");
        Assertions.assertEquals(result, true);
    }

}
