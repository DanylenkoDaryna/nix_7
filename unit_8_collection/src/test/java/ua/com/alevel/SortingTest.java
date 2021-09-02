package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.db.MathSet;

import java.util.TreeSet;

class SortingTest{

    @Test
    @Order(1)
    void testSortAsc1(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        mathSet.sortAsc();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[-100, 1, 8, 12, 23, 37]", mathSet.toString());
    }

    @Test
    @Order(2)
    void testSortAsc2(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37, -15, 6, 90, 2, -7, 42);
        mathSet.sortAsc(2, 10);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[-100, 1, -7, -15, 2, 6, 8, 12, 23, 37, 90, 42]", mathSet.toString());
    }

    @Test
    @Order(3)
    void testSortAsc3(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37, 4);
        mathSet.sortAsc(23);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[-100, 1, 4, 8, 12, 23, 37]", mathSet.toString());

    }

    @Test
    @Order(4)
    void testSortDesc1(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        mathSet.sortDesc();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[37, 23, 12, 8, 1, -100]", mathSet.toString());
    }

    @Test
    @Order(5)
    void testSortDesc2(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37, -15, 6, 90, 2, -7, 42);
        mathSet.sortDesc(2, 10);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[-100, 1, -7, 90, 37, 23, 12, 8, 6, 2, -15, 42]", mathSet.toString());
    }

    @Test
    @Order(6)
    void testSortDesc3(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37, 4);
        mathSet.sortDesc(23);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals("[-100, 1, 37, 23, 12, 8, 4]", mathSet.toString());
    }
}
