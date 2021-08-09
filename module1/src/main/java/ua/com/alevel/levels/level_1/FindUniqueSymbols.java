package ua.com.alevel.levels.level_1;

public class FindUniqueSymbols {

    public static void getUniques(String input) {
        System.out.println("FindUniqueSymbols");
        StringBuilder result = new StringBuilder();
        if (input.matches("[0-9]*")) {
            char[] symbols = input.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                int count = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(i) == input.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    result.append(input.charAt(i)).append(" ");
                }
            }
            System.out.println("Unique Symbols: " + result);
        } else {
            System.out.println("Wrong input. Try again..");
        }
    }
}
