package ua.com.alevel.levels.level_1;


import java.util.Scanner;

public class KnightMovements {

    private static final int CELLS_IN_L_FIGURE_BODY = 2;
    private static final int CELLS_IN_L_FIGURE_TOP = 1;
    private static final int LETTER_DISPLACEMENT = 64;
    private static final int LENGTH_FOR_MAX_INT_VALUE = 10;
    private static final String REGULAR_EXPR_FOR_CHESS_MOVE = "^[a-z]+[0-9]+$";
    private static final String WELCOMING = "----- Welcome to chess board! -----\n";
    private static final String BORDER = "----------------------------\n";
    private static final String COMMANDS = "----- enter your command -----\n";
    private static final String COMMAND_ONE = "----- s to Start New Game -----\n";
    private static final String COMMAND_TWO = "----- q to Quit -----\n";
    private static final String CHOOSE_START = "Please, choose start position for your knight.. ";
    private static final String CHOOSE_DESTINATION = "Please, choose destination to move.. ";
    private static final String INCORRECT_MOVE = "Knight doesn`t move like that..";
    private static final String POSSIBLE_MOVE = "This move is possible for knight! ";
    private static final String IMPOSSIBLE_MOVE = "This move impossible for knight. Try again...";
    private static final String INCORRECT_INPUT = "Incorrect input. Try Again..";

    public static void startMenu(Scanner scanner) {
        boolean cycleBreaker = true;
        while (cycleBreaker) {
            System.out.println(WELCOMING + BORDER + COMMANDS + COMMAND_ONE + COMMAND_TWO + BORDER);
            String inputValue = scanner.nextLine().replaceAll(" ", "");
            switch (inputValue) {
                case "q":
                    cycleBreaker = false;
                    break;
                case "s":
                    tryToMakeMove(scanner);
                    break;
                default:
                    System.out.println(INCORRECT_INPUT);
                    break;
            }
        }
    }

    private static void tryToMakeMove(Scanner scanner) {
        System.out.println(CHOOSE_START);
        String sourcePosition = correctInput(scanner.nextLine());

        System.out.println(CHOOSE_DESTINATION);
        String destPosition = correctInput(scanner.nextLine());
        if (checkInput(sourcePosition) && checkInput(destPosition)) {
            int srcRow = getRowFrom(sourcePosition);
            int srcCol = getColFrom(sourcePosition);
            int destRow = getRowFrom(destPosition);
            int destCol = getColFrom(destPosition);
            if (isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol)) {
                System.out.println(POSSIBLE_MOVE);
            } else {
                System.out.println(IMPOSSIBLE_MOVE);
            }
        } else {
            System.out.println(INCORRECT_INPUT);
        }
    }

    private static int getRowFrom(String movingPosition) {
        return LETTER_DISPLACEMENT - movingPosition.charAt(0);
    }

    private static int getColFrom(String movingPosition) {
        return Integer.parseInt(movingPosition.substring(1, movingPosition.length()));
    }

    private static String correctInput(String input) {
        return input.trim().replaceAll(" ", "");
    }

    private static boolean checkInput(String input){
        return input.matches(REGULAR_EXPR_FOR_CHESS_MOVE)
                && input.length() < LENGTH_FOR_MAX_INT_VALUE;
    }

    private static boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        int difRow = Math.abs(destRow - srcRow);
        int difCol = Math.abs(destCol - srcCol);
        if((difRow == CELLS_IN_L_FIGURE_BODY && difCol == CELLS_IN_L_FIGURE_TOP) ||
                (difRow == CELLS_IN_L_FIGURE_TOP && difCol == CELLS_IN_L_FIGURE_BODY)){
            return true;
        }else{
            System.out.println(INCORRECT_MOVE);
            return false;
        }
    }
}
