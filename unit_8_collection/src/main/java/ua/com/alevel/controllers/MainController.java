package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.AppMessages;
import ua.com.alevel.cmd.Menu;
import ua.com.alevel.db.MathSet;
import ua.com.alevel.exceptions.NullMathSetException;

import java.util.Arrays;
import java.util.Scanner;

public class MainController{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");
    private static Scanner scanner;

    private static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }else
            return scanner;
    }

    private static Scanner takeScanner(){
        return getScanner();
    }

    public static void startApp(){
        MenuController.startAppMenu();
    }

    public static String getUsersPreEditedCommand(){
        return takeScanner().nextLine().trim().toLowerCase().replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
    }

    private static String getUsersPreEditedInput(){
        return takeScanner().nextLine().trim();
    }

    public static void clearMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        OperationController.showMathSet(mathSet);
        mathSet.clear();
        OperationController.showMathSet(mathSet);
    }

    private static MathSet<Number> makeNewMathSet(){
        MathSet<Number> mathSet = null;
        try{
            System.out.println("Create your mathSet..");
            mathSet = MenuController.createMathSetMenu();
        }catch(NoSuchMethodException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println("no such method! Try again..");
            makeNewMathSet();
        }
        return mathSet;
    }

    public static void clearNumsInMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        Number[] numbers = getNumbersFromInput();
        if(!mathSet.isEmpty() && checkNumbersExist(numbers, mathSet)){
            mathSet.clear(numbers);
            OperationController.showMathSet(mathSet);
        }else{
            Menu.notifyOfIncorrectInput();
            clearNumsInMathSet();
        }
    }

    private static boolean checkNumbersExist(Number[] numbers, MathSet<Number> mathSet){
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < mathSet.size(); j++){
                if(mathSet.get(j).equals(numbers[i])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void cutMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        int firstIndex = getIndex();
        int lastIndex = getIndex();
        if(!mathSet.isEmpty() && checkIndexes(firstIndex, lastIndex, mathSet)){
            OperationController.showMathSet(mathSet.cut(firstIndex, lastIndex));
        }
    }

    public static void toFullArray(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println(Arrays.toString(mathSet.toArray()));
    }

    public static void toPartArray(){
        MathSet<Number> mathSet = makeNewMathSet();
        int firstIndex = getIndex();
        int lastIndex = getIndex();
        if(checkIndexes(firstIndex, lastIndex, mathSet)){
            System.out.println(Arrays.toString(mathSet.toArray(firstIndex, lastIndex)));
        }else{
            Menu.notifyOfIncorrectInput();
            toPartArray();
        }
    }

    public static void getFromMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        int index = getIndex();
        if(checkIndex(index, mathSet)){
            System.out.println("Element is " + mathSet.get(index));
        }
    }

    private static boolean checkIndex(int index, MathSet<Number> mathSet){
        return index < mathSet.size() && 0 <= index;
    }

    public static void getMaxFromMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("Max is " + mathSet.getMax());
    }

    public static void getMinFromMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("Min is " + mathSet.getMin());
    }

    public static void getAverageFromMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("Average is " + mathSet.getAverage());
    }

    public static void getMedianFromMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("Median is " + mathSet.getMedian());
    }

    public static void sortDescMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        mathSet.sortDesc();
        OperationController.showMathSet(mathSet);
    }

    public static void sortDescBetweenMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        int firstIndex = getIndex();
        int lastIndex = getIndex();
        if(checkIndexes(firstIndex, lastIndex, mathSet)){
            mathSet.sortDesc(firstIndex, lastIndex);
        }
        OperationController.showMathSet(mathSet);
    }

    public static void sortDescMathSetByValue(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("input your number ..");
        String input = getUsersPreEditedInput();
        if(checkInputNumber(input) && checkNumberExistInSet(input, mathSet)){
            mathSet.sortDesc(Integer.parseInt(input));
        }
        OperationController.showMathSet(mathSet);
    }

    public static void sortAscMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        mathSet.sortAsc();
        OperationController.showMathSet(mathSet);
    }

    public static void sortAscBetweenMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        int firstIndex = getIndex();
        int lastIndex = getIndex();
        if(checkIndexes(firstIndex, lastIndex, mathSet)){
            mathSet.sortAsc(firstIndex, lastIndex);
        }
        OperationController.showMathSet(mathSet);
    }

    private static boolean checkIndexes(int firstIndex, int lastIndex, MathSet<Number> mathSet){
        return (firstIndex < mathSet.size() && 0 <= firstIndex)
                && (lastIndex < mathSet.size() && 0 <= lastIndex)
                && firstIndex < lastIndex;
    }

    private static int getIndex(){
        System.out.println("input your index ..");
        String input = getUsersPreEditedInput();
        if(checkInputNumber(input)){
            return Integer.parseInt(input);
        }else
            return getIndex();
    }

    public static void sortAscMathSetByValue(){
        MathSet<Number> mathSet = makeNewMathSet();
        System.out.println("input your number ..");
        String input = getUsersPreEditedInput();
        if(checkInputNumber(input) && checkNumberExistInSet(input, mathSet)){
            mathSet.sortAsc(Integer.parseInt(input));
        }
        OperationController.showMathSet(mathSet);
    }

    private static boolean checkNumberExistInSet(String input, MathSet<Number> mathSet){
        Integer number = Integer.parseInt(input);
        for(int i = 0; i < mathSet.size(); i++){
            if(mathSet.get(i).equals(number)){
                return true;
            }
        }
        return false;
    }

    public static void addNumToMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        Number num = getNumberFromInput();
        mathSet.add(num);
        OperationController.showMathSet(mathSet);
    }

    private static Number getNumberFromInput(){
        System.out.println("Please, input your number to add...");
        String input = getUsersPreEditedInput();
        if(checkInputNumber(input)){
            return Integer.parseInt(input);
        }else{
            Menu.notifyOfIncorrectInput();
            return getNumberFromInput();
        }
    }

    private static boolean checkInputNumber(String input){
        return input.matches(AppMessages.REGEX_FOR_INPUT_NUMBER);
    }

    public static void addNumsToMathSet(){
        MathSet<Number> mathSet = makeNewMathSet();
        Number[] nums = getNumbersFromInput();
        mathSet.add(nums);
        OperationController.showMathSet(mathSet);
    }

    private static Number[] getNumbersFromInput(){
        System.out.println(AppMessages.INSTRUCTION_TO_INPUT_ARRAY);
        String input = getUsersPreEditedInput();
        if(checkInputNumbers(input)){
            String[] symbols = input.split(",");
            Number[] nums = new Number[symbols.length];
            for(int i = 0; i < symbols.length; i++){
                nums[i] = Integer.parseInt(symbols[i]);
            }
            return nums;
        }else{
            Menu.notifyOfIncorrectInput();
            return getNumbersFromInput();
        }
    }

    public static void joinMathSet(){
        System.out.println(AppMessages.CREATE_FIRST_MATHSET);
        MathSet<Number> resultMathSet = makeNewMathSet();
        System.out.println(AppMessages.CREATE_SECOND_MATHSET);
        MathSet<Number> mathSetToJoin = makeNewMathSet();
        resultMathSet.join(mathSetToJoin);
        OperationController.showMathSet(resultMathSet);
    }

    public static void joinMathSets(){
        createMathSetWithMathSets();
    }

    public static void intersectionMathSet(){
        System.out.println(AppMessages.CREATE_FIRST_MATHSET);
        MathSet<Number> resultMathSet = makeNewMathSet();
        System.out.println(AppMessages.CREATE_MATHSET_TO_INTERSECT);
        MathSet<Number> intersectMathSet = makeNewMathSet();
        resultMathSet.intersection(intersectMathSet);
        OperationController.showMathSet(resultMathSet);
    }

    public static void intersectionMathSets(){
        System.out.println(AppMessages.CREATE_FIRST_MATHSET);
        MathSet<Number> resultMathSet = makeNewMathSet();
        System.out.println(AppMessages.CREATE_SECOND_MATHSET);
        MathSet<Number> secondMathSet = makeNewMathSet();
        System.out.println(AppMessages.CREATE_THIRD_MATHSET);
        MathSet<Number> thirdMathSet = makeNewMathSet();
        resultMathSet.intersection(secondMathSet, thirdMathSet);
        System.out.print("Result is - ");
        OperationController.showMathSet(resultMathSet);
    }

    public static MathSet<Number> createMathSet(){
        return new MathSet<>();
    }

    public static MathSet<Number> createMathSetCapacity(){
        System.out.println(AppMessages.INSTRUCTION_TO_INPUT_CAPACITY);
        String input = getUsersPreEditedInput();
        MathSet<Number> mathSet = null;
        if(checkInputCapacity(input)){
            mathSet = new MathSet<>(Integer.parseInt(input));
        }
        try{
            return checkMathSetEmpty(mathSet);
        }catch(NullMathSetException e){
            System.out.println(e.getMessage());
            return createMathSetCapacity();
        }
    }

    private static boolean checkInputCapacity(String input){
        return input.matches(AppMessages.REGEX_FOR_INPUT_CAPACITY);
    }

    public static MathSet<Number> createMathSetWithArray(){
        System.out.println(AppMessages.INSTRUCTION_TO_INPUT_ARRAY);
        String input = getUsersPreEditedInput();
        MathSet<Number> mathSet = null;
        if(checkInputNumbers(input)){
            mathSet = addNumsFromInput(input);
        }else{
            Menu.notifyOfIncorrectInput();
            createMathSetWithArray();
        }
        try{
            return checkMathSetEmpty(mathSet);
        }catch(NullMathSetException e){
            System.out.println(e.getMessage());
            return createMathSetWithArray();
        }
    }

    private static MathSet<Number> addNumsFromInput(String input){
        MathSet<Number> mathSet = new MathSet<>();
        String[] nums = input.split(",");
        for(String num : nums){
            mathSet.add(Integer.parseInt(num));
        }
        return mathSet;
    }

    private static boolean checkInputNumbers(String input){
        return input.matches(AppMessages.REGEX_FOR_ONE_EL_ARRAY)
                || input.matches(AppMessages.REGEX_FOR_ARRAY);
    }

    private static MathSet<Number> checkMathSetEmpty(MathSet<Number> mathSet) throws NullMathSetException{
        if(mathSet == null){
            throw new NullMathSetException(AppMessages.NULL_MATHSET_EXCEPTION);
        }else{
            OperationController.showMathSet(mathSet);
            return mathSet;
        }
    }

    public static MathSet<Number> createMathSetWithArrays(){
        MathSet<Number> mathSet = new MathSet<>();
        boolean cycle = true;
        while(cycle){
            mathSet.join(createMathSetWithArray());
            System.out.println(AppMessages.CHOOSE_TO_CONTINUE_OR_EXIT);
            String input = getUsersPreEditedInput();
            if(input.equals("1")){
                getArrays(mathSet);
                cycle = false;
            }else if(input.equals("0")){
                OperationController.showMathSet(mathSet);
                return mathSet;
            }
        }
        try{
            return checkMathSetEmpty(mathSet);
        }catch(NullMathSetException e){
            System.out.println(e.getMessage());
            return createMathSetWithArrays();
        }
    }

    private static MathSet<Number> getArrays(MathSet<Number> mathSet){
        mathSet.join(createMathSetWithArray());
        System.out.println(AppMessages.CHOOSE_TO_CONTINUE_OR_EXIT);
        String input = getUsersPreEditedInput();
        if(input.equals("1")){
            return getArrays(mathSet);
        }else if(input.equals("0")){
            OperationController.showMathSet(mathSet);
            return mathSet;
        }
        OperationController.showMathSet(mathSet);
        return mathSet;
    }

    public static MathSet<Number> createMathSetWithMathSet(){
        MathSet<Number> result = new MathSet<>();
        MathSet<Number> mathSet = createMathSetWithArray();
        result.join(mathSet);
        return result;
    }

    public static MathSet<Number> createMathSetWithMathSets(){
        MathSet<Number> result = new MathSet<>();
        MathSet<Number> mathSet = createMathSetWithArrays();
        result.join(mathSet);
        return result;
    }
}