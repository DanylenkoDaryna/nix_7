package ua.com.alevel.controllers;

import ua.com.alevel.db.MathSet;

public class OperationController{


    public static <T extends Number> void showMathSet(MathSet<T> mathSet){
        System.out.println(mathSet.toString());
    }
}