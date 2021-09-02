package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.controllers.OperationController;
import ua.com.alevel.db.MathSet;

import java.util.TreeSet;

class RemovingTest{

    @Test
    @Order(1)
    void testCut(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        MathSet result = mathSet.cut(1, 5);
        OperationController.showMathSet(result);
        Assertions.assertEquals("[1, 23, 12, 8, 37]", result.toString());
    }

    @Test
    @Order(2)
    void testClear1(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        mathSet.clear();
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(0, mathSet.size());
        Assertions.assertEquals("[]", mathSet.toString());
    }

    @Test
    @Order(3)
    void testClear2(){
        MathSet<Integer> mathSet = new MathSet<>();
        mathSet.add(-100, 1, 23, 12, 8, 37);
        Number[] numbers = {1, 23, 12, 8};
        mathSet.clear(numbers);
        OperationController.showMathSet(mathSet);
        Assertions.assertEquals(2, mathSet.size());
        Assertions.assertEquals("[-100, 37]", mathSet.toString());
    }
}
