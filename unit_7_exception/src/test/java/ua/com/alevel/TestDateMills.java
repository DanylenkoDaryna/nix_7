package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.CalendarController;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.mapper.ConverterToMsUtill;


class TestDateMills{

    @Test
    void test1(){
        CalendarDate date1 = CalendarController.convertToDate("1/10/34");
        CalendarDate date2 = CalendarController.convertToDate("1/10/34 00:00:00:000");
        Assertions.assertEquals(ConverterToMsUtill.countAverageMills(date1), ConverterToMsUtill.countAverageMills(date2));
    }

    @Test
    void test2(){
        CalendarDate date = CalendarController.convertToDate("1/10/34 00:00:00:100");
        Assertions.assertEquals(1096675200100L, ConverterToMsUtill.countAverageMills(date));
    }

    @Test
    void test3(){
        CalendarDate date = CalendarController.convertToDate("/5/47 00:24:00:000");
        Assertions.assertEquals(1493598240000L, ConverterToMsUtill.countAverageMills(date));
    }

    @Test
    void test4(){
        CalendarDate date = CalendarController.convertToDate("/2/ :2");
        Assertions.assertEquals(2764920000L, ConverterToMsUtill.countAverageMills(date));
    }
}
