package ua.com.alevel;


public class StringManipulationUtil{

    public static String reverse(String input){

        StringBuilder reversed = new StringBuilder();
        String[] words = input.split(" ");

        for(String word:words){

            for(int i=word.length()-1; i>=0; i--){

                reversed.append(word.charAt(i));
            }
            reversed.append(" ");
        }
        return reversed.toString().trim();
    }

    public static String reverse(String input, String dest){

        return input.replaceAll(dest, reverse(dest));
    }

    public static String reverse(String source, int firstIndex, int lastIndex){

        int lastIndexForSubstring = lastIndex + 1;
        return source.replaceAll(source.substring(firstIndex, lastIndexForSubstring),
                reverse(source.substring(firstIndex, lastIndexForSubstring)));
    }

}
