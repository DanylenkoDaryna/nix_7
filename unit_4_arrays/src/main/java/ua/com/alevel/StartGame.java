package ua.com.alevel;

import ua.com.alevel.utils.ChessGame;
import java.util.Scanner;


public class StartGame{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in, "UTF-8");

        boolean mainCycleBreaker = true;
        while (mainCycleBreaker) {
            System.out.println("----- Welcome to chess! -----");
            System.out.println("----------------------------");
            System.out.println("----- enter one of commands -----");
            System.out.println("----- s to Start New Game -----");
            System.out.println("----- q to Quit -----");
            System.out.println("----------------------------");
            String inputValue = scanner.nextLine().replaceAll(" ", "");

            if (inputValue.equals("q")){

                 mainCycleBreaker = false;
             } else if(inputValue.equals("s")){

                ChessGame.startNewGame(scanner);
            }else{

                System.out.println("Incorrect input. Try Again");
            }
        }
    }
}
