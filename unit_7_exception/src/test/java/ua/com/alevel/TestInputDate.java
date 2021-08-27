package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.util.CheckerDateFormatUtil;

class TestInputDate{

    @Order(1)
    @Test
    void checkInputCorrect1(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1/10/34");
        Assertions.assertEquals(result, true);
    }

    @Order(2)
    @Test
    void checkInputCorrect2(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1/10/34 00:09:065");
        Assertions.assertEquals(result, true);
    }

    @Order(3)
    @Test
    void checkInputCorrect3(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1-10-334 09:065");
        Assertions.assertEquals(result, true);
    }

    @Order(4)
    @Test
    void checkInputCorrect4(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("/5/47 09:09:00:065");
        Assertions.assertEquals(result, true);
    }

    @Order(5)
    @Test
    void checkInputCorrect5(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("/2/ :2");
        Assertions.assertEquals(result, true);
    }

    @Order(6)
    @Test
    void checkInputCorrect6(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1997 14:59");
        Assertions.assertEquals(result, true);
    }

    @Order(7)
    @Test
    void checkInputIncorrect1(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1/10/3400:09:065");
        Assertions.assertEquals(result, false);
    }

    @Order(8)
    @Test
    void checkInputIncorrect2(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("111/10/3400:09:065");
        Assertions.assertEquals(result, false);
    }

    @Order(9)
    @Test
    void checkInputIncorrect3(){
        boolean result = CheckerDateFormatUtil.checkDateCorrect("1/10/3400:09:065");
        Assertions.assertEquals(result, false);
    }
}
