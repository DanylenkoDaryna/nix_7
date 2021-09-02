package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.MainController;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.db.MathSet;

import java.util.*;

class ConstructorsTest{


    @Test
    @Order(1)
    void testConstructor1(){
        //ArrayList list1;
        TreeSet treeset;
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(23);
        mathSet.add(34);
        mathSet.add(-1);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(2)
    void testConstructor2(){
        int capacity = 2;
        MathSet<Long> mathSet = new MathSet<>(capacity);
        mathSet.add(23333L);
        mathSet.add(34444L);
        mathSet.add(-15555L);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(3)
    void testConstructor3(){
        Number[] numbers = {1, 3, 4};
        MathSet<Number> mathSet = new MathSet<>(numbers);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(4)
    void testConstructor4(){
        Number[] numbers = {1, 3, 4};
        Number[] numbers2 = {-11, -3, -4};
        Number[] numbers3 = {11, 31, 14};
        MathSet<Number> mathSet = new MathSet<>(numbers, numbers2, numbers3);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(9, mathSet.size());
    }

    @Test
    @Order(5)
    void testConstructor5(){
        MathSet<Number> mathSet1 = new MathSet<>();
        mathSet1.add(23);
        mathSet1.add(34);
        mathSet1.add(-1);
        MathSet<Number> result = new MathSet<>(mathSet1);
        OperationController.showMathSet(result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    @Order(6)
    void testConstructor6(){
        MathSet<Number> mathSet1 = new MathSet<>();
        mathSet1.add(23);
        mathSet1.add(34);
        mathSet1.add(-1);
        MathSet<Number> mathSet2 = new MathSet<>();
        mathSet2.add(23);
        mathSet2.add(34);
        mathSet2.add(-1);
        MathSet<Number> result = new MathSet<>(mathSet1, mathSet2);
        OperationController.showMathSet(result);
        Assertions.assertEquals(3, result.size());
    }
}
