package ua.com.alevel.hometasks.exercises;

import java.util.Scanner;

public class Ex1SumNumsInString{

    private static final String EX_1_DESCRIPTION = "To find out the sum of numbers in string, please, input your string:";
    private static final String STOP_EX = "enter \'stop\' or \'exit\' or \'q\' to stop exercise";

    // если класс утилитный, то ему не делают приват конструктор
    private Ex1SumNumsInString(){

        throw new IllegalStateException("Utility class");
    }

    public static void exercise1(){

        boolean cycleBreaker = true;
        Scanner scanner = new Scanner(System.in,"utf-8");
        while(cycleBreaker) {
            System.out.println(EX_1_DESCRIPTION + "\n"+ STOP_EX);
            String inputValue = scanner.nextLine().toLowerCase().replaceAll(" ","");

            if (inputValue.equals("")) {
                System.out.println("write something...");
            } else if (inputValue.equals("exit") ||
                    inputValue.equals("stop") ||
                    inputValue.equals("q")) {
                cycleBreaker=false;
            } else {
                char[] inputArr = inputValue.toCharArray();
                int sumResult = 0;
                for(char symbol:inputArr) {
                    if(Character.isDigit(symbol)) {
                        sumResult+= Character.getNumericValue(symbol);
                    }
                }
                System.out.println(sumResult);
            }
        }
        scanner.close();
    }
}
