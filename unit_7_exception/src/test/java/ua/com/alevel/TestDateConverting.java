package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.CalendarController;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.mapper.DateFormatterUtil;

class TestDateConverting{

    @Order(1)
    @Test
    void testConvertIntoDate1(){
        CalendarDate date = CalendarController.convertToDate("1/10/34");
        Assertions.assertEquals("01/10/34 00:00:00:000", DateFormatterUtil.showInStandardFormat(date));
    }

    @Order(2)
    @Test
    void testConvertIntoDate2(){
        CalendarDate date = CalendarController.convertToDate("/5/47 00:24:00:000");
        Assertions.assertEquals("01/05/47 00:24:00:000", DateFormatterUtil.showInStandardFormat(date));
    }

    @Order(3)
    @Test
    void testConvertIntoDate3(){
        CalendarDate date = CalendarController.convertToDate("/2/ :2");
        Assertions.assertEquals("01/02/0 00:02:00:000", DateFormatterUtil.showInStandardFormat(date));
    }

    @Order(4)
    @Test
    void testConvertIntoDate4(){
        CalendarDate date = CalendarController.convertToDate("1256 14:59");
        Assertions.assertEquals("01/01/1256 14:59:00:000", DateFormatterUtil.showInStandardFormat(date));
    }
}
