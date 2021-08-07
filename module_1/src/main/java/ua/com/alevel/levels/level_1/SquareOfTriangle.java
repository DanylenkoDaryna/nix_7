package ua.com.alevel.levels.level_1;

import java.math.BigDecimal;
import java.util.Scanner;

public class SquareOfTriangle {

    private static final String REGEX_FOR_COORDINATES = "^[-+]?[0-9]+[;][-+]?[0-9]+$";
    private static final String BORDER = "----------------------------\n";
    private static final String COMMANDS = "Input coordinates in format '-1;3'" +
            "or 'q' to exit \n";
    private static final String INCORRECT_INPUT = "Incorrect input. Try Again..";


    public static void startMenu(Scanner scanner) {

        boolean cycleBreaker = true;
        while (cycleBreaker) {
            System.out.println(BORDER + COMMANDS + BORDER);
            System.out.println("Coordinate A: ");

            String inputValue = scanner.nextLine().trim().replaceAll(" ", "");

            if (inputValue.equals("q")) {
                cycleBreaker = false;
            } else {
                String pointA = inputValue.trim().replaceAll(" ", "");
                System.out.println("Coordinate B: ");
                String pointB = scanner.nextLine().trim().replaceAll(" ", "");
                System.out.println("Coordinate C: ");
                String pointC = scanner.nextLine().trim().replaceAll(" ", "");

                if (inputCorrect(pointA, pointB, pointC)) {
                    countSquare(pointA, pointB, pointC);
                } else {
                    System.out.println(INCORRECT_INPUT);
                }
            }
        }
    }

    private static boolean inputCorrect(String pointA, String pointB, String pointC) {
        return pointA.matches(REGEX_FOR_COORDINATES)
                && pointB.matches(REGEX_FOR_COORDINATES)
                && pointC.matches(REGEX_FOR_COORDINATES);
    }

    private static void countSquare(String pointA, String pointB, String pointC) {

        String[] firstCoord = pointA.split(";");
        String[] secondCoord = pointB.split(";");
        String[] thirdCoord = pointC.split(";");

        double x1 = Double.parseDouble(firstCoord[0]);
        double y1 = Double.parseDouble(firstCoord[1]);

        double x2 = Double.parseDouble(secondCoord[0]);
        double y2 = Double.parseDouble(secondCoord[1]);

        double x3 = Double.parseDouble(thirdCoord[0]);
        double y3 = Double.parseDouble(thirdCoord[1]);

        BigDecimal sideACbyX = new BigDecimal(x1 - x3);
        BigDecimal sideACbyY = new BigDecimal(y1 - y3);

        BigDecimal sideBCbyX = new BigDecimal(x2 - x3);
        BigDecimal sideBCbyY = new BigDecimal(y2 - y3);

        BigDecimal halfResult = sideACbyX.multiply(sideBCbyY).subtract(sideBCbyX.multiply(sideACbyY));

        System.out.println("Square is " + Math.abs(halfResult.divide(new BigDecimal(2)).doubleValue()));
    }
}
