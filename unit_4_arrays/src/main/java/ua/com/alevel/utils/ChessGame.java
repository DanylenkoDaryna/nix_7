package ua.com.alevel.utils;

import ua.com.alevel.data.*;

import java.util.Scanner;

public class ChessGame {

    private static Scanner scanner = getScanner();
    private static final int NUM_OF_CELLS = 8;
    private static final int NUM_OF_ROWS = 8;
    public static Figure[][] board = new Figure[NUM_OF_ROWS][NUM_OF_CELLS];

    public static Side userSide;
    public static Side enemySide;
    public static Side currentSide = Side.WHITES;

    private ChessGame() {
        System.out.println("Start new Chess game...");
    }

    private static Scanner getScanner() {
        if(scanner != null) {
            return scanner;
        } else return new Scanner(System.in, "UTF-8");
    }

    public static void launching() {
        boolean mainCycleBreaker = true;
        while (mainCycleBreaker) {
            System.out.println("----- Welcome to chess! -----");
            System.out.println("----------------------------");
            System.out.println("----- enter one of commands -----");
            System.out.println("----- s to Start New Game -----");
            System.out.println("----- q to Quit -----");
            System.out.println("----------------------------");
            String inputValue = getScanner().nextLine().replaceAll(" ", "");

            switch (inputValue){
                case "q":
                    mainCycleBreaker = false;
                    break;
                case "s":
                    ChessGame.startNewGame(getScanner());
                    break;
                default:
                    System.out.println("Incorrect input. Try Again");
                    break;
            }
        }
    }

    private static void startNewGame(Scanner scanner) {
        ChessGame chessGame = new ChessGame();
        ChessGame.chooseSide(scanner);
        chessGame.start();
        boolean continueGame = true;
        while(continueGame) {
            System.out.println("------------------------------------------------");
            System.out.println("Choose one of commands: 'draw' to draw game ");
            System.out.println("Choose one of commands: 'end' to end game ");
            System.out.println("Choose one of commands: press 'Enter' to continue");
            System.out.println("------------------------------------------------");
            String command = scanner.nextLine();
            if (command.matches("draw")) {
                chessGame.declareDraw();
                continueGame = false;
                scanner.close();

            } else if (command.matches("end")) {
                chessGame.finishGame(userSide, enemySide);
                continueGame = false;
                scanner.close();
            } else if (command.matches("")) {
                chessGame.chooseFigure(scanner);
            } else {
                System.out.println("Incorrect input. try again..");
            }
        }
    }

    private static void chooseSide(Scanner scanner) {
        System.out.println("------------------------------------------------");
        System.out.println("Choose side: BLACKS - input '0'.. ");
        System.out.println("Choose side: WHITES - input '1'.. ");
        System.out.println("------------------------------------------------");
        String chosenSide = reformatUserInput(scanner.nextLine());
        if (chosenSide.matches("^0$")) {
            userSide = Side.BLACKS;
            enemySide = Side.WHITES;
        } else if (chosenSide.matches("^1$")) {
            userSide = Side.WHITES;
            enemySide = Side.BLACKS;
        } else {
            System.out.println("wrong input1");
            chooseSide(scanner);
        }
        System.out.println("user choose his side as.. " + userSide);
    }

    private static String reformatUserInput(String input) {
        return input.trim().replaceAll(" ", "");
    }

    private void start() {
        System.out.println("New game begins...");
        placeFiguresOnBoard();
    }


    private static void placeFiguresOnBoard() {
        System.out.println("placing figures on board...");
        board[0][0]= new Rook("h1",enemySide);
        board[0][1]= new Knight("h2",enemySide);
        board[0][2]= new Bishop("h3",enemySide);
        board[0][3]= new Queen("h4",enemySide);
        board[0][4]= new King("h5",enemySide);
        board[0][5]= new Bishop("h6",enemySide);
        board[0][6]= new Knight("h7",enemySide);
        board[0][7]= new Rook("h8",enemySide);

        board[1][0]= new Pawn("g1",enemySide);
        board[1][1]= new Pawn("g2",enemySide);
        board[1][2]= new Pawn("g3",enemySide);
        board[1][3]= new Pawn("g4",enemySide);
        board[1][4]= new Pawn("g5",enemySide);
        board[1][5]= new Pawn("g6",enemySide);
        board[1][6]= new Pawn("g7",enemySide);
        board[1][7]= new Pawn("g8",enemySide);


        board[6][0]= new Pawn("b1",userSide);
        board[6][1]= new Pawn("b2",userSide);
        board[6][2]= new Pawn("b3",userSide);
        board[6][3]= new Pawn("b4",userSide);
        board[6][4]= new Pawn("b5",userSide);
        board[6][5]= new Pawn("b6",userSide);
        board[6][6]= new Pawn("b7",userSide);
        board[6][7]= new Pawn("b8",userSide);

        board[7][0]= new Rook("a1",userSide);
        board[7][1]= new Knight("a2",userSide);
        board[7][2]= new Bishop("a3",userSide);
        board[7][3]= new Queen("a4",userSide);
        board[7][4]= new King("a5",userSide);
        board[7][5]= new Bishop("a6",userSide);
        board[7][6]= new Knight("a7",userSide);
        board[7][7]= new Rook("a8",userSide);

        drawBoard();
    }

    private static void drawBoard() {
        System.out.println("draving board.. ");
        System.out.println();

        for (int row = 0; row < NUM_OF_ROWS; row++) {
            System.out.println("");
            System.out.println("  --------------------------------------");
            for (int cell = 0; cell < NUM_OF_CELLS; cell++) {
                if (cell == 0) {
                    System.out.print(Character.toString((char) (97+NUM_OF_CELLS-1-row)) + " ");
                }
                if (board[row][cell] != null) {
                    System.out.print("| " + board[row][cell].toString() + " ");
                } else {
                    System.out.print("| " + "\u2001" + " ");
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("  --------------------------------------");
        System.out.print("\t 1\t 2 \t  3\t  4\t   5\t6 \t 7\t 8");
        System.out.println("");
    }

    private void chooseFigure(Scanner scanner) {
        System.out.println("Please, choose your figure to move.. ");
        String figurePos = scanner.nextLine();
        reformatUserInput(figurePos);
        if (figurePos.matches("^[a-h][1-8]$")) {
            int srcRow = getRowFrom(figurePos);
            int srcCol = getColFrom(figurePos);
            if (board[srcRow][srcCol]==null) {
                System.out.println("empty cell");
            } else if (board[srcRow][srcCol].getSide() != this.currentSide) {
                System.out.println("It's not your turn to move");
                chooseFigure(scanner);
            } else {
                System.out.println("You choose figure.. " +
                        board[srcRow][srcCol].toString());
            }
            this.chooseDestination(scanner, board[srcRow][srcCol]);
        } else {
            System.out.println("!Wrong figure input!");
            chooseFigure(scanner);
        }
    }

    private void chooseDestination(Scanner scanner, Figure figure) {
        System.out.println("please, choose destination to move.. ");
        String destPos = scanner.nextLine();
        reformatUserInput(destPos);
        if (destPos.matches("^[a-h][1-8]$")) {
            if (checkAbilityToMoveTo(figure.getCurrentPosition(), destPos)) {
                this.moveTo(destPos, figure);
            } else {
                this.chooseFigure(scanner);
            }
        } else {
            System.out.println("wrong figure input");
            chooseFigure(scanner);
        }
    }

    public static int getRowFrom(String movingPosition) {
        return 'h' - movingPosition.charAt(0) ;
    }

    public static int getColFrom(String movingPosition) {
        return Character.getNumericValue(movingPosition.charAt(1)) - 1;
    }

    private boolean checkAbilityToMoveTo(String sourcePosition, String movingPosition) {
        System.out.println("checking ability to move to position " + movingPosition);

        int srcRow = getRowFrom(sourcePosition);
        int srcCol = getColFrom(sourcePosition);

        int destRow = getRowFrom(movingPosition);
        int destCol = getColFrom(movingPosition);

        if (board[destRow][destCol] == null) {
            return board[srcRow][srcCol].isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol);
        }

        if (board[srcRow][srcCol].getSide() != this.currentSide) {
            System.out.println("It's not your turn to move");
            return false;
        }

        if (board[srcRow][srcCol].getSide() == board[destRow][destCol].getSide()) {
            System.out.println("Figure cannot beat another figure with the same colour");
            return false;
        }

//        ???
        if (isEnemyKingInMateDanger(movingPosition)) {

        }

        return board[srcRow][srcCol].isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol);
    }

    private boolean isEnemyKingInCheckDanger(int srcRow, int srcCol, int destRow, int destCol) {
       if (board[srcRow][srcCol].isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol)) {
           System.out.println("Enemy King In Danger");
           checkTo(enemySide);
           return true;
       }
        return false;
    }

    private boolean isEnemyKingInMateDanger(String movingPosition) {
        int destRow = getRowFrom(movingPosition);
        int destCol = getColFrom(movingPosition);
        if (currentSide.equals(Side.WHITES) && board[destRow][destCol].getChessman().equals(Chessman.BLACK_KING)) {
            System.out.println("King of " + Side.BLACKS + " defeated!!!");
            checkTo(Side.BLACKS);
            mateTo(Side.BLACKS);
            return true;
        } else if (currentSide.equals(Side.BLACKS) && board[destRow][destCol].getChessman().equals(Chessman.WHITE_KING)) {
            System.out.println("King of " + Side.WHITES + " defeated!!!");
            checkTo(Side.WHITES);
            mateTo(Side.WHITES);
            return true;
        }
        return false;
    }

    private void moveTo(String nextPosition, Figure figure) {
        System.out.println("moving figure on position.. " + nextPosition);
        int srcRow = getRowFrom(figure.getCurrentPosition());
        int srcCol = getColFrom(figure.getCurrentPosition());
        int destRow = getRowFrom(nextPosition);
        int destCol = getColFrom(nextPosition);
        figure.setCurrentPosition(nextPosition);
        board[destRow][destCol] = board[srcRow][srcCol];
        board[srcRow][srcCol] = null;
        this.changeSide();
        drawBoard();
    }

    private void changeSide() {
        System.out.println("changing side..");
        if (currentSide == Side.BLACKS) {
            currentSide = Side.WHITES;
        } else {
            currentSide = Side.BLACKS;
        }
    }

    private static void checkTo(Side looser) {
        System.out.println("check to " + looser);
    }

    private static void mateTo(Side looser) {
        finishGame(looser, currentSide);
    }

    public static void finishGame() {
        declareLooseTo(enemySide);
        declareWinTo(userSide);
        System.out.println("End Chess game...\n");
    }

    private static void finishGame(Side loser, Side winner) {
        declareLooseTo(loser);
        declareWinTo(winner);
        System.out.println("End Chess game...\n");
        launching();
    }

    private static void declareDraw() {
        System.out.println("it`s a draw..");
        System.out.println("End Chess game...\n");
        launching();
    }

    private static void declareWinTo(Side winner) {
        System.out.println(winner + " wins!!!");
    }

    private static void declareLooseTo(Side loser) {
        System.out.println(loser + " lose!!!");
    }
}
