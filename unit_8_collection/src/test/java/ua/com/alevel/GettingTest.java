package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.db.MathSet;

import java.util.Arrays;
import java.util.TreeSet;

class GettingTest{

    @Test
    @Order(1)
    void testGet1(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        Number result = mathSet.get(2);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(23, result);
    }

    @Test
    @Order(2)
    void testGet2(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        Number result = mathSet.getMax();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(37, result);
    }

    @Test
    @Order(3)
    void testGet3(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        Number result = mathSet.getMin();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(-100, result);
    }

    @Test
    @Order(4)
    void testGet4(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(1, 3, 12, 8, 4);
        Number result = mathSet.getAverage();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(14, result);
    }

    @Test
    @Order(5)
    void testGet5(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(1, 3, 12, 8, 4);
        Number result = mathSet.getMedian();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(12, result);
    }

    @Test
    @Order(6)
    void testGet6(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(1, 3, 8, 4);
        Number result = mathSet.getMedian();
        OperationController.showMathSet(mathSet);
        System.out.println(result);
        Assertions.assertEquals(3.5, result);
    }

    @Test
    @Order(7)
    void testToArray7(){
        MathSet<Integer> mathSet = new MathSet<>(7);
        mathSet.add(1, 3, 8, 24, -7, 91, 4);
        System.out.println(Arrays.toString(mathSet.toArray()));
        Assertions.assertEquals("[1, 3, 8, 24, -7, 91, 4]", Arrays.toString(mathSet.toArray()));
    }

    @Test
    @Order(8)
    void testToArray8(){
        MathSet<Integer> mathSet = new MathSet<>(7);
        mathSet.add(1, 3, 8, 24, -7, 91, 4);
        System.out.println(Arrays.toString(mathSet.toArray(1, 4)));
        Assertions.assertEquals("[3, 8, 24, -7]", Arrays.toString(mathSet.toArray(1, 4)));
    }


}
