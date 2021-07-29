package ua.com.alevel;

import ua.com.alevel.data.Side;
import ua.com.alevel.utils.ChessGame;

import java.util.Scanner;

public class StartGame{

    public static void main(String[] args){

        ChessGame chessGame = new ChessGame();
        //todo start menu

        System.out.println("Choose side: BLACKS - input '0', WHITES - input '1'.. ");
        Scanner scanner = new Scanner(System.in);

        ChessGame.chooseSide(scanner);
        chessGame.start();

        boolean continueGame = true;
        while (continueGame) {
            System.out.println("Choose command: draw, end, _ ");
            String command = scanner.nextLine();

            if (command.matches("draw")) {
                chessGame.declareDraw();
                continueGame = false;

            } else if (command.matches("end")) {
                chessGame.finishGame();
                continueGame = false;
            } else if (command.matches("")) {
                chessGame.chooseFigure();

            } else {
                System.out.println("Incorrect input. try again..");
            }
        }

    }
}
