package ua.com.alevel;

import java.util.Scanner;

public class JarTesting {

    private static final String BORDER = "===========================================================\n";

    private static final String MAIN_DESCRIPTION = "Choose an exercise to test by inputting one of this symbols:\n";
    private static final String EX_1_DESCRIPTION = "1 - ex 1: get reversed string\n";
    private static final String EX_2_DESCRIPTION = "2 - ex 2: get string with reversed substring\n";
    private static final String EX_3_DESCRIPTION = "3 - ex 3: get string with reversed substring between indexe\ns";

    private static final String EX_1_INSTRUCTIONS = "Please, input string to reverse. As example: 'hello world' \n";
    private static final String EX_2_INSTRUCTIONS = "Please, input string and substring to reverse. As example: " +
            "'hello world, worl' \n";
    private static final String EX_3_INSTRUCTIONS = "Please, input string and two indexes to reverse substring\n" +
            " between them. As example: ' hello world, 3, 7' \n";

    private static final String STOP_PROGRAM = "enter \'q\' to stop program";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in, "UTF-8");

        boolean mainCycleBreaker = true;
        while(mainCycleBreaker){

            System.out.println(MAIN_DESCRIPTION +"\n"+ EX_1_DESCRIPTION +"\n"+ EX_2_DESCRIPTION
                    +"\n"+ EX_3_DESCRIPTION +"\n"+ STOP_PROGRAM +"\n"+ BORDER);
            String inputValue = scanner.nextLine().trim();

            if (inputValue.matches("[1-3]")){

                switch (Integer.parseInt(inputValue)){
                    case 1:
                        testReverseFromEx1(scanner);
                        break;
                    case 2:
                        testReverseFromEx2(scanner);
                        break;
                    case 3:
                        testReverseFromEx3(scanner);
                        break;
                    default:
                        System.out.println("Incorrect number\n");
                        break;
                }
            } else if (inputValue.equals("q")){

                mainCycleBreaker=false;
            } else{

                System.out.println("Incorrect input. Try Again\n");
            }
        }
        scanner.close();
    }

    private static void testReverseFromEx1(Scanner scanner){
        System.out.println(EX_1_INSTRUCTIONS);
        String input = scanner.nextLine().trim();
        System.out.println(StringManipulationUtil.reverse(input));

    }

    private static void testReverseFromEx2(Scanner scanner){

        System.out.println(EX_2_INSTRUCTIONS);
        String input = scanner.nextLine().trim();
        if(input.matches(".+[, ].+")){
            String source = input.split(", ")[0];
            String destination = input.split(", ")[1];
            System.out.println(StringManipulationUtil.reverse(source, destination));
        }else {
            System.out.println("Incorrect input. Try 'hello world, worl' .\n");
        }
    }

    private static void testReverseFromEx3(Scanner scanner){

        System.out.println(EX_3_INSTRUCTIONS);
        String input = scanner.nextLine().trim();
        if(input.matches(".+[, [1-9], [1-9]]")){
            String[]comands = input.split(", ");
            int firstIndex = Integer.parseInt(comands[1]);
            int lastIndex = Integer.parseInt(comands[2]);
            System.out.println(StringManipulationUtil.reverse(comands[0], firstIndex, lastIndex));
        }else {
            System.out.println("Incorrect input.\n");
        }
    }

}
