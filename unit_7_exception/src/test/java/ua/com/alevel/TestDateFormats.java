package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.CalendarController;

class TestDateFormats{

    @Order(1)
    @Test
    void test1makeDateInFormat1(){
        System.out.println("test 1");
//        String date = CalendarController.convertIntoDate("01/12/2021");
//        String formatDate = CalendarController.makeDateInFormat(date, "dd/mm/yy");
//        Assertions.assertEquals(formatDate,"01/12/21");
    }

    @Order(2)
    @Test
    void test2makeDateInFormat2(){
        System.out.println("test 2");
//        String date = CalendarController.convertIntoDate("03/04/2021");
//        String formatDate = CalendarController.makeDateInFormat(date, "m/d/yyyy");
//        Assertions.assertEquals(formatDate,"3/4/2021");

    }

    @Order(3)
    @Test
    void test3makeDateInFormat3(){
        System.out.println("test 3");
//        String date = CalendarController.convertIntoDate("01/12/2021");
//        String formatDate = CalendarController.makeDateInFormat(date, "mmm-d-yy");
//        Assertions.assertEquals(formatDate,"Март 4 21");

    }

    @Order(4)
    @Test
    void test4makeDateInFormat4(){
        System.out.println("test 3");
//        String date = CalendarController.convertIntoDate("09/04/789 45:23:000");
//        String formatDate = CalendarController.makeDateInFormat(date, "dd-mmm-yyyy 00:00");
//        Assertions.assertEquals(formatDate,"09 Апрель 789 45:23");
    }
}
