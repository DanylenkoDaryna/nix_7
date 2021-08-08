package ua.com.alevel.levels.level_3;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife{

    private static final String WELCOMING = "----- Welcome to Game of life! -----\n";
    private static final String BORDER = "-------------------------------------------\n";
    private static final String COMMANDS = "Input s to start or 'q' to exit \n";
    private static final String INCORRECT_INPUT = "Incorrect input. Try Again..";
    private static final int MIN_SIZE_OF_BOARD = 2;
    private static int ROWS;
    private static int COLS;
    private static int[][] board;

    public static void startMenu(Scanner scanner){

        boolean cycleBreaker = true;
        while (cycleBreaker){
            System.out.println(WELCOMING + BORDER + COMMANDS + BORDER);
            String inputValue = scanner.nextLine().replaceAll(" ", "");

            if (inputValue.equalsIgnoreCase("q")){
                cycleBreaker = false;
                scanner.close();
            }else if (inputValue.equalsIgnoreCase("s")){
                startNewGame(scanner);
            }
        }
    }

    private static void startNewGame(Scanner scanner){

        System.out.print("Enter num of iterations: ");
        String iterations = scanner.nextLine().trim().replaceAll(" ", "");
        System.out.println("Enter rows in the board..");
        String rows = scanner.nextLine().trim().replaceAll(" ", "");
        System.out.println("Enter columns in the board..");
        String cols = scanner.nextLine().trim().replaceAll(" ", "");

        if(checkIterations(iterations) && checkRowCol(rows, cols)){
            int iterationNum = Integer.parseInt(iterations);
            int rowNum = Integer.parseInt(rows);
            int colNum = Integer.parseInt(cols);
            doZeroIteration(iterationNum, rowNum, colNum);
        }else System.out.println(INCORRECT_INPUT);

    }

    private static boolean checkIterations(String iterations){
        return iterations.matches("^[1-9]+$");
    }

    private static boolean checkRowCol(String rows, String cols){

        if(rows.matches("^[0-9]+$") && cols.matches("^[0-9]+$")){
            int x = Integer.parseInt(rows);
            int y = Integer.parseInt(cols);
            if (x < MIN_SIZE_OF_BOARD || y < MIN_SIZE_OF_BOARD){
                System.out.println("This board is too small!");
                return false;
            }else if(x > Integer.MAX_VALUE || y > Integer.MAX_VALUE){
                System.out.println("This board is too big!");
                return false;
            }else{
                return true;
            }
        }else return false;
    }

    private static void doZeroIteration(int iterations, int rows, int cols){

        fillBoardByRandom(rows, cols);
        showBoard();
        doAllIterations(iterations);
    }

    private static void fillBoardByRandom(int rows, int cols){

        ROWS=rows;
        COLS=cols;
        board = new int[ROWS][COLS];

        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = rand.nextInt(2);
            }
        }
    }

    private static void showBoard(){

        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLS; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.print("|\n");
        }
        System.out.println();
    }

    private static void doAllIterations(int numOfIterations){

        while (numOfIterations != 0) {
            nextState();
            numOfIterations--;
        }
        showBoard();
    }

    private static void nextState(){

        int[][] temp = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int countAliveNeighbors = getAliveNeighbors(i, j);
                if (board[i][j] == 1) {
                    if (countAliveNeighbors == 2 || countAliveNeighbors == 3) {
                        temp[i][j] = 1;
                    } else if (countAliveNeighbors < 2) {
                        temp[i][j] = 0;
                    } else {
                        temp[i][j] = 0;
                    }
                }else{
                    if (countAliveNeighbors == 3) {
                        temp[i][j] = 1;
                    }else {
                        temp[i][j] = 0;
                    }
                }
            }
        }
        board = temp;
    }

    private static int getAliveNeighbors(int row, int column){

        int count = 0;
        for(int i=row-1; i<=row+1; i++){
            for(int j=column-1; j<=column+1; j++){

                if((i==row & j==column) || i>=ROWS || j>=COLS || i<0 || j<0){
                    continue;
                }else if(board[i][j]==1){
                    count=count+1;
                }
            }
        }
        return count;
    }
}
