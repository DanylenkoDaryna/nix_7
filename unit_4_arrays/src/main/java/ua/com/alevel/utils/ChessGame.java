package ua.com.alevel.utils;

import ua.com.alevel.data.*;

import java.util.Scanner;

public class ChessGame{

    static Figure[][] board;
    private static final int NUM_OF_CELLS = 8;
    private static final int NUM_OF_ROWS = 8;

    private static Side userSide;
    private static Side enemySide;
    private Side currentSide;

    public ChessGame(){
        System.out.println("Start new Chess game...");
        board = new Figure[NUM_OF_ROWS][NUM_OF_CELLS];
        currentSide = Side.WHITES;
    }

    public static void chooseSide(Scanner scanner){

        String chosenSide = scanner.nextLine().trim();
        reformatUserInput(chosenSide);
        if(chosenSide.matches("^0$")){
            userSide = Side.BLACKS;
            enemySide = Side.WHITES;
        }else if(chosenSide.matches("^1$")){
            userSide = Side.WHITES;
            enemySide = Side.BLACKS;
        }else{
            System.out.println("wrong input1");
            chooseSide(scanner);
        }

        System.out.println("user choose his side as.. " + userSide);
    }

    private static void reformatUserInput(String input){

        input.trim().replaceAll(" ", "");
    }

    public void start(){
        System.out.println("New game begins...");
        placeFiguresOnBoard();
    }

    //todo auto placing figures on start
    private static void placeFiguresOnBoard(){
        System.out.println("placing figures on board...");

        board[0][0]= new Rook("a8","a8",enemySide);
        board[0][1]= new Knight("b8","b8",enemySide);
        board[0][2]= new Bishop("c8","c8",enemySide);
        board[0][3]= new Queen("d8","d8",enemySide);
        board[0][4]= new King("e8","e8",enemySide);
        board[0][5]= new Bishop("f8","f8",enemySide);
        board[0][6]= new Knight("g8","j8",enemySide);
        board[0][7]= new Rook("h8","h8",enemySide);

        board[1][0]= new Pawn("a7","a7",enemySide);
        board[1][1]= new Pawn("b7","b7",enemySide);
        board[1][2]= new Pawn("c7","c7",enemySide);
        board[1][3]= new Pawn("d7","d7",enemySide);
        board[1][4]= new Pawn("e7","e7",enemySide);
        board[1][5]= new Pawn("f7","f7",enemySide);
        board[1][6]= new Pawn("g7","j7",enemySide);
        board[1][7]= new Pawn("h7","h7",enemySide);


        board[6][0]= new Pawn("a2","a2",userSide);
        board[6][1]= new Pawn("b2","b2",userSide);
        board[6][2]= new Pawn("c2","c2",userSide);
        board[6][3]= new Pawn("d2","d2",userSide);
        board[6][4]= new Pawn("e2","e2",userSide);
        board[6][5]= new Pawn("f2","f2",userSide);
        board[6][6]= new Pawn("g2","j2",userSide);
        board[6][7]= new Pawn("h2","h2",userSide);

        board[7][0]= new Rook("a1","a1",userSide);
        board[7][1]= new Knight("b1","b1",userSide);
        board[7][2]= new Bishop("c1","c1",userSide);
        board[7][3]= new Queen("d1","d1",userSide);
        board[7][4]= new King("e1","e1",userSide);
        board[7][5]= new Bishop("f1","f1",userSide);
        board[7][6]= new Knight("g1","j1",userSide);
        board[7][7]= new Rook("h1","h1",userSide);


        drawBoard();
    }

    //todo drawBoard()
    public static void drawBoard(){

        System.out.println("draving board.. ");
        System.out.print("\t 1\t 2 \t  3\t  4\t   5\t6 \t 7\t 8");
        for (int row = 0; row < NUM_OF_ROWS; row++)
        {
            System.out.println("");
            System.out.println("  --------------------------------------");

            for (int cell = 0; cell < NUM_OF_CELLS; cell++)
            {
                if (cell == 0) {
                    System.out.print(Character.toString((char) (row+97)) + " ");
                }
                if(board[row][cell] != null){
                    System.out.print("| " + board[row][cell].toString() + " ");
                }else{
                    System.out.print("| " + "\u2001" + " ");
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("  --------------------------------------");

    }

    public void chooseFigure(){
        System.out.println("please, choose your figure to move.. ");
        this.chooseDestination();

    }

    public void chooseDestination() {
        System.out.println("please, choose Destination for your figure to move.. ");
        //todo maybe without checking
        if (checkAbilityToMoveTo("b2")) {
            System.out.println("you can move");
            //todo moving for figures
            this.moveTo("b2");
        } else {
            System.out.println("you can`t move");
            this.chooseFigure();
        }
    }

    private boolean checkAbilityToMoveTo(String movingPosition) {
        System.out.println("checking ability to move to position " + movingPosition);
        return true;

    }

    private void moveTo(String movingPosition) {
        System.out.println("moving figure on position.. " + movingPosition);
        //to do - beating other figures, adding points, remowing figures
        this.changeSide();
    }

    private void changeSide() {

        System.out.println("changing side..");
        if (currentSide == Side.BLACKS) {
            currentSide = Side.WHITES;
        } else {
            currentSide = Side.BLACKS;
        }
        //todo should be here this.chooseFigure(); ???
        this.drawBoard();
    }

    //todo finish of Game
    public void finishGame() {

        if (userSide == Side.BLACKS) {
            this.declareLooseTo(Side.WHITES);
            this.declareWinTo(Side.BLACKS);
        } else {
            this.declareLooseTo(Side.BLACKS);
            this.declareWinTo(Side.WHITES);
        }

        this.drawBoard();

        System.out.println("End Chess game...");
    }

    public void declareDraw() {

        System.out.println("it`s a draw..");
        System.out.println("End Chess game...");

    }

    private void declareWinTo(Side winner) {

        System.out.println(winner + " wins!!!!!");

    }

    private void declareLooseTo(Side loser) {

        this.check(loser);
        this.mate(loser);

    }

    private void check(Side enemySide) {

        System.out.println("check to " + enemySide);

    }

    private void mate(Side enemySide) {

        System.out.println("mate to " + enemySide);

    }

    public Figure[][] getBoard() {
        return board;
    }

    public void setBoard(Figure[][] board) {
        this.board = board;
    }

    public Side getUserSide() {
        return userSide;
    }

    public void setUserSide(Side userSide) {
        this.userSide = userSide;
    }

    public Side getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(Side currentSide) {
        this.currentSide = currentSide;
    }
}
