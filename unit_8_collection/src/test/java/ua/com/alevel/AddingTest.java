package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.db.MathSet;

class AddingTest{

    @Test
    @Order(1)
    void testAddAllNumberTypes(){
        MathSet<Number> mathSet = new MathSet<>();
        mathSet.add(23);
        mathSet.add(23000L);
        mathSet.add(34.4f);
        mathSet.add(34.4);
        mathSet.add(0);
        mathSet.add(-1);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(5, mathSet.size());
    }

    @Test
    @Order(2)
    void testAddUniqueNumber(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(23);
        mathSet.add(23);
        mathSet.add(34);
        mathSet.add(34);
        mathSet.add(34);
        mathSet.add(-1);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(3)
    void testAddNumbers(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(23, -1, -10);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(4)
    void testAddUniqueNumbers(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(23, 23, -1, 23, -10, -1, -10, 23);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(3, mathSet.size());
    }

    @Test
    @Order(5)
    void testJoin1(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(23, 23, -1, 23, -10, -1, -10, 23);
        MathSet<Integer> result = new MathSet<>();
        result.add(1, 4, 5, 7);
        result.join(mathSet);
        OperationController.showMathSet(result);
        Assertions.assertEquals(7, result.size());
    }

    @Test
    @Order(6)
    void testJoin2(){
        MathSet<Number> mathSet1 = new MathSet<>();
        mathSet1.add(23, 23, -1);
        MathSet<Number> mathSet2 = new MathSet<>();
        mathSet2.add(0, 100, 1);
        MathSet<Number> mathSet3 = new MathSet<>();
        mathSet3.add(5.0, 9, 4);
        MathSet<Number> result = new MathSet<>();
        result.add(16, 4, 5, 7);
        result.join(mathSet1, mathSet2, mathSet3);
        OperationController.showMathSet(result);
        Assertions.assertEquals(10, result.size());
    }

    @Test
    @Order(7)
    void testIntersection(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(1, 2, 3, 4);
        MathSet<Integer> result = new MathSet<>();
        result.add(2, 3, 4, 5, 6);
        result.intersection(mathSet);
        OperationController.showMathSet(result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    @Order(8)
    void testIntersections(){
        MathSet<Number> mathSet1 = new MathSet<>();
        mathSet1.add(1, 2, 3);
        MathSet<Number> mathSet2 = new MathSet<>();
        mathSet2.add(3, 4, 5);
        MathSet<Number> mathSet3 = new MathSet<>();
        mathSet3.add(5, 6, 3);
        MathSet<Number> result = new MathSet<>();
        result.add(3, 6, 7, 8);
        result.intersection(mathSet1, mathSet2, mathSet3);
        OperationController.showMathSet(result);
        Assertions.assertEquals(1, result.size());
    }
}
