//Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
// Write time and space complexity of your solution as comments in the source file.
package com.assignment2;

import java.util.Scanner;

public class AlphabetChecker {
    public static boolean containsAllLetters(String input) {
        boolean[] present = new boolean[26];
        for (char i : input.toCharArray()) {
            if (i >= 'a' && i <= 'z')
                present[i - 'a'] = true;
        }
        for (boolean letterPresent : present)
            if (!letterPresent)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (containsAllLetters(input))
            System.out.println("Given input string \"" + input + "\" contains all the letters of the alphabet a-z");
        else
            System.out.println("Given input string \"" + input + "\" doesn't contains all the letters of the alphabet a-z");
    }
    /*
     * Time Complexity: O(n), where n is the length of the input string.
     * We iterate through the input string once, and then through the fixed-size
     * boolean array (26 elements). Both operations are linear, resulting in O(n).
     *
     * Space Complexity: O(1) - constant space.
     * We use a fixed-size boolean array of 26 elements, which doesn't grow with
     * the input size. The space used remains constant regardless of the input length.
     */
}
