package ua.com.alevel.hometasks.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2SortingSymbols {

    private static final String EX_2_DESCRIPTION = "Please, input string to find out the count of repeatable letters and sort them ";
    private static final String STOP_EX = "enter \'stop\' or \'exit\' or \'q\' to stop exercise";

    private Ex2SortingSymbols(){
        throw new IllegalStateException("Utility class");
    }

    public static void exercise2() {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        boolean cycleBreaker = true;
        while(cycleBreaker) {
            System.out.println(EX_2_DESCRIPTION + "\n"+ STOP_EX);
            String inputValue = scanner.nextLine().replaceAll(" ","");

            if (inputValue.equals("")) {
                System.out.println("write something...");
            } else if (inputValue.equals("exit") ||
                    inputValue.equals("stop") ||
                    inputValue.equals("q")) {
                cycleBreaker = false;
            } else {
                char[] inputArr = inputValue.toCharArray();
                Arrays.sort(inputArr);
                for(char symbol:inputArr) {
                    if(Character.isLetter(symbol)) {
                        countLetterAppearance(symbol, inputArr);
                    }
                }
            }
        }
    }

    private static void countLetterAppearance(char symbol, char[] inputArr) {
        int numOfRepeating = 0;
        for(int i=0; i<inputArr.length; i++) {
            if (inputArr[i]==symbol) {
                numOfRepeating+=1;
                inputArr[i]='0';
            }
        }
        System.out.println(symbol + " - " + numOfRepeating);
    }
}
