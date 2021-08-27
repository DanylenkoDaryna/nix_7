package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.CalendarController;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.entity.CalendarDate;
import ua.com.alevel.util.ConverterToDateUtil;
import ua.com.alevel.util.DateFormatterUtil;
import ua.com.alevel.util.DateManipulationUtil;

import java.util.Set;
import java.util.TreeSet;

class TestDateManipulating{

    private static String ascResult;
    private static String descResult;

    @BeforeAll
    static void doBeforeAsc(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("01/09/20 00:00:00:000").append("\n")
                .append("01/09/1996 00:00:00:000").append("\n")
                .append("03/04/2021 00:00:00:000").append("\n");
        ascResult = stringBuilder.toString();
    }

    @BeforeAll
    static void doBeforeDesc(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("03/04/2021 00:00:00:000").append("\n")
                .append("01/09/1996 00:00:00:000").append("\n")
                .append("01/09/20 00:00:00:000").append("\n");
        descResult = stringBuilder.toString();
    }

    @Test
    void testSortByAsc(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate date2 = CalendarController.convertToDate("01/09/20");
        CalendarDate date3 = CalendarController.convertToDate("01/09/1996");
        Set<CalendarDate> dates = new TreeSet<>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        String sortedDates = OperationController.doAscSort(dates);
        Assertions.assertEquals(ascResult, sortedDates);
    }

    @Test
    void testSortByDesc(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate date2 = CalendarController.convertToDate("01/09/20");
        CalendarDate date3 = CalendarController.convertToDate("01/09/1996");
        Set<CalendarDate> dates = new TreeSet<>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        String sortedDates = OperationController.doDescSort(dates);
        Assertions.assertEquals(descResult, sortedDates);
    }

    @Test
    void testDifference1(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018");
        CalendarDate date2 = CalendarController.convertToDate("18/12/2021");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(3, ConverterToDateUtil.toYears(difference));
    }


    @Test
    void testDifference2(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018");
        CalendarDate date2 = CalendarController.convertToDate("15/12/2018");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(3, ConverterToDateUtil.toDays(difference));
    }


    @Test
    void testDifference3(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018 12:02:00:036");
        CalendarDate date2 = CalendarController.convertToDate("18/12/2018 19:02:00:036");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(7, ConverterToDateUtil.toHours(difference));
    }


    @Test
    void testDifference4(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018 12:02:00:036");
        CalendarDate date2 = CalendarController.convertToDate("18/12/2018 12:60:00:036");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(58, ConverterToDateUtil.toMinutes(difference));
    }


    @Test
    void testDifference5(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018 12:03:24:036");
        CalendarDate date2 = CalendarController.convertToDate("18/12/2018 12:04:24:036");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(60, ConverterToDateUtil.toSeconds(difference));
    }


    @Test
    void testDifference6(){
        CalendarDate date1 = CalendarController.convertToDate("18/12/2018 12:03:24:036");
        CalendarDate date2 = CalendarController.convertToDate("20/12/2018 12:04:24:114");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        Assertions.assertEquals(172860078L, difference);
    }


    @Test
    void testAddYears(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusYear(date1, 25);
        Assertions.assertEquals("03/04/2046 00:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));

    }


    @Test
    void test2addDays(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusDay(date1, 29);
        Assertions.assertEquals("02/05/2021 00:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }


    @Test
    void test2addHours(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusHours(date1, 23);
        Assertions.assertEquals("03/04/2021 23:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));

    }

    @Test
    void test2addMinutes(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusMinutes(date1, 60);
        Assertions.assertEquals("03/04/2021 01:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2addSeckonds(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusSeconds(date1, 60);
        Assertions.assertEquals("03/04/2021 00:01:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));

    }

    @Test
    void test2addMiliSeckonds(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusMilliseconds(date1, 1000);
        Assertions.assertEquals("03/04/2021 00:00:01:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2addMiliSeckonds2(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.plusMilliseconds(date1, 45);
        Assertions.assertEquals("03/04/2021 00:00:00:045",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test3minusYears(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.minusYear(date, 25);
        Assertions.assertEquals("03/04/1996 00:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test3minusDays(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021");
        CalendarDate resultDate = DateManipulationUtil.minusDay(date, 29);
        Assertions.assertEquals("05/03/2021 00:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test3minusHours(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021 21:00:00:000");
        CalendarDate resultDate = DateManipulationUtil.minusHours(date, 20);
        Assertions.assertEquals("03/04/2021 01:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2minusMinutes(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021 21:00:00:000");
        CalendarDate resultDate = DateManipulationUtil.minusMinutes(date, 60);
        Assertions.assertEquals("03/04/2021 20:00:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2minusSeckonds(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021 21:00:00:000");
        CalendarDate resultDate = DateManipulationUtil.minusSeconds(date, 60);
        Assertions.assertEquals("03/04/2021 20:59:00:000",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2minusMiliSeckonds(){
        CalendarDate date = CalendarController.convertToDate("03/04/2021 21:00:00:315");
        CalendarDate resultDate = DateManipulationUtil.minusMilliseconds(date, 60);
        Assertions.assertEquals("03/04/2021 21:00:00:255",
                DateFormatterUtil.showInStandardFormat(resultDate));
    }

    @Test
    void test2subtractDate(){
        CalendarDate date1 = CalendarController.convertToDate("03/04/2021");
        CalendarDate date2 = CalendarController.convertToDate("01/09/2021");
        long difference = DateManipulationUtil.findDifference(date1, date2);
        CalendarDate resultDate = DateManipulationUtil.minusMilliseconds(date2, difference);
        Assertions.assertEquals(DateFormatterUtil.showInStandardFormat(resultDate),
                DateFormatterUtil.showInStandardFormat(date1));
    }
}
