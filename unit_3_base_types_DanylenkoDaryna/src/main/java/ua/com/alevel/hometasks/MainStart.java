package ua.com.alevel.hometasks;

import ua.com.alevel.hometasks.exercises.Ex1SumNumsInString;
import ua.com.alevel.hometasks.exercises.Ex2SortingSymbols;
import ua.com.alevel.hometasks.exercises.Ex3EndOfLessons;

import java.util.Scanner;

public class MainStart{

    private static final String BORDER = "===========================================================\n";

    private static final String MAIN_DESCRIPTION = "Choose an exercise to test by inputting one of this symbols:";
    private static final String EX_1_DESCRIPTION = "1 - ex 1: get sum of numbers in string";
    private static final String EX_2_DESCRIPTION = "2 - ex 2: get sorted list of letters in input with counting entrances";
    private static final String EX_3_DESCRIPTION = "3 - ex 3: get time of the end of the lesson";
    private static final String STOP_PROGRAM = "enter \'stop\' or \'exit\' or \'q\' to stop program";


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in, "UTF-8");

        boolean mainCycleBreaker = true;
        while(mainCycleBreaker) {
            System.out.println(MAIN_DESCRIPTION +"\n"+ EX_1_DESCRIPTION +"\n"+ EX_2_DESCRIPTION
                    +"\n"+ EX_3_DESCRIPTION +"\n"+ STOP_PROGRAM);
            String inputValue = scanner.nextLine().replaceAll(" ", "");


            if (inputValue.matches("[1-3]")) {
                switch (Integer.parseInt(inputValue)){
                    case 1:
                        Ex1SumNumsInString.exercise1();
                        break;
                    case 2:
                        Ex2SortingSymbols.exercise2();
                        break;
                    case 3:
                        doEx3(scanner);
                        break;
                    default:
                        System.out.println("Incorrect number");
                        break;
                }
            }else if(inputValue.equals("exit")||
                    inputValue.equals("stop")||
                    inputValue.equals("q")){
                mainCycleBreaker=false;
            }else {
                System.out.println("Incorrect input. Try Again");
            }
            System.out.println(BORDER);
        }

    }

    private static void doEx3(Scanner scanEx3){

        boolean cycleBreaker = true;
        while(cycleBreaker) {
            System.out.println(Ex3EndOfLessons.EX_3_DESCRIPTION +"\n"+ Ex3EndOfLessons.STOP_EX);
            String inputValue = scanEx3.nextLine().replaceAll(" ","");
            if (inputValue.equals("exit") ||
                    inputValue.equals("stop") ||
                    inputValue.equals("q")) {
                cycleBreaker = false;
            } else if(inputValue.matches("[1-9][0]?")){
                Ex3EndOfLessons.exercise3(Integer.parseInt(inputValue));
            }else {
                System.out.println("Incorrect input. Try Again");
            }
        }
    }
}