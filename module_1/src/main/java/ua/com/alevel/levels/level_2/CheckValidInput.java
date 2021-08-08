package ua.com.alevel.levels.level_2;


import java.util.ArrayList;
import java.util.Scanner;

public class CheckValidInput{


    private static final String REGEX_BRACKETS = "[](){}";
    private static final char[] arrayOfBrackets = REGEX_BRACKETS.toCharArray();
    private static final String BORDER = "----------------------------\n";
    private static final String COMMANDS = "Input line with bracers" +
            "or 'q' to exit \n";
    private static final String INCORRECT_INPUT = "Incorrect input. Try Again..";
    private static final String CORRECT_INPUT = "Input is correct.";


    public static void startMenu(Scanner scanner){

        boolean cycleBreaker = true;
        while (cycleBreaker){
            System.out.println(BORDER + COMMANDS + BORDER);
            String inputValue = scanner.nextLine().trim().replaceAll(" ", "");
            if(inputValue.equals("q")){
                cycleBreaker = false;
            }else if (inputValue.equals("")){
                System.out.println(CORRECT_INPUT);
            }else{
                checkInput(inputValue);
            }
        }
    }


    private static void checkInput(String inputValue){

        char[] symbols = inputValue.toCharArray();
        ArrayList<Character> brackets = new ArrayList<>();

        for (char symbol : symbols){
            for (char bracket : arrayOfBrackets){
                if (bracket == symbol) {
                    brackets.add(symbol);
                }
            }
        }

        if(checkBrackets(brackets)){
            System.out.println(CORRECT_INPUT);
        }else{
            System.out.println(INCORRECT_INPUT);
        }
    }


    private static boolean checkBrackets(ArrayList<Character> brackets){

        if(brackets.size() % 2 != 0){
            return false;
        }
        return checkSequence(brackets) || checkDeep(brackets);
    }

    private static boolean checkDeep(ArrayList<Character> brackets){

        for(int i = 0; i < brackets.size() / 2; i++){

            if(brackets.get(i).equals('[') &&
                    brackets.get(brackets.size() - 1 - i).equals(']')){
                continue;
            }else if (brackets.get(i).equals('{') &&
                    brackets.get(brackets.size() - 1 - i).equals('}')){
                continue;
            }else if (brackets.get(i).equals('(') &&
                    brackets.get(brackets.size() - 1 - i).equals(')')){
                continue;
            }else return false;
        }
        return true;
    }

    private static boolean checkSequence(ArrayList<Character> brackets){

        for(int i = 0; i < brackets.size() - 2; i += 2){

            if(brackets.get(i).equals('[') && brackets.get(i + 1).equals(']')){
                continue;
            }else if (brackets.get(i).equals('{') && brackets.get(i + 1).equals('}')){
                continue;
            }else if (brackets.get(i).equals('(') && brackets.get(i + 1).equals(')')){
                continue;
            }else return false;
        }
        return true;
    }

}
