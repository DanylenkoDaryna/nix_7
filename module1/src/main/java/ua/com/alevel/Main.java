package ua.com.alevel;

import ua.com.alevel.levels.level_1.FindUniqueSymbols;
import ua.com.alevel.levels.level_1.KnightMovements;
import ua.com.alevel.levels.level_1.SquareOfTriangle;
import ua.com.alevel.levels.level_2.CheckValidInput;
import ua.com.alevel.levels.level_3.GameOfLife;

import java.util.Scanner;

public class Main {

    private static final String BORDER = "===========================================================\n";
    private static final String MAIN_DESCRIPTION = "Choose an exercise to test by inputting one of this symbols:";
    private static final String EX_1_DESCRIPTION = "1 - ex 1: to get unique symbols in string";
    private static final String EX_2_DESCRIPTION = "2 - ex 2: to play knight on chess board";
    private static final String EX_3_DESCRIPTION = "3 - ex 3: to find the square of your triangle";
    private static final String EX_4_DESCRIPTION = "4 - ex 4: to check if input is valid";
    private static final String EX_5_DESCRIPTION = "5 - ex 5: to play the Game of Life";
    private static final String STOP_PROGRAM = "enter \'q\' to stop program";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        boolean mainCycleBreaker = true;
        while (mainCycleBreaker){
            welcoming();
            String inputValue = scanner.nextLine().replaceAll(" ", "");
            if (inputValue.matches("[1-5]")) {
                switch (Integer.parseInt(inputValue)) {
                    case 1 : {
                        String input = scanner.nextLine().replaceAll(" ", "");
                        FindUniqueSymbols.getUniques(input);
                        break;
                    }
                    case 2:
                        KnightMovements.startMenu(scanner);
                        break;
                    case 3:
                        SquareOfTriangle.startMenu(scanner);
                        break;
                    case 4:
                        CheckValidInput.startMenu(scanner);
                        break;
                    case 5:
                        GameOfLife.startMenu(scanner);
                        break;
                    default:
                        System.out.println("Incorrect number");
                        break;
                }
            } else if (inputValue.equals("q")) {
                mainCycleBreaker = false;
            } else {
                System.out.println("Incorrect input. Try Again");
            }
            System.out.println(BORDER);
        }
        scanner.close();
    }

    private static void welcoming() {
        System.out.println(MAIN_DESCRIPTION + "\n" + EX_1_DESCRIPTION
                + "\n" + EX_2_DESCRIPTION  +"\n" + EX_3_DESCRIPTION +
                "\n" + EX_4_DESCRIPTION + "\n" + EX_5_DESCRIPTION + "\n"
                + STOP_PROGRAM + BORDER);
    }
}
