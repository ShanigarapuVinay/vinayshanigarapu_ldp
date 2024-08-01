package com.assignment6;

import java.util.ArrayList;

public class VampireNumbers {

    public static void main(String[] args) {
        final int LIMIT = 100;
        ArrayList<Integer> vampireNumbers = new ArrayList<>();

        for (int num = 10; vampireNumbers.size() < LIMIT; num++) {
            if (isVampireNumber(num)) {
                vampireNumbers.add(num);
            }
        }

        System.out.println("First 100 Vampire Numbers:");
        for (int number : vampireNumbers) {
            System.out.println(number);
        }
    }

    private static boolean isVampireNumber(int number) {
        String numStr = Integer.toString(number);
        int length = numStr.length();
        if (length % 2 != 0) return false; // Must have an even number of digits
        int halfLength = length / 2;
        for (int i = (int) Math.pow(10, halfLength - 1); i < Math.pow(10, halfLength); i++) {
            if (number % i == 0) {
                int j = number / i;
                if (j < Math.pow(10, halfLength - 1) || j >= Math.pow(10, halfLength)) continue;
                if (!hasTrailingZeros(i, j) && containsAllDigits(numStr, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasTrailingZeros(int x, int y) {
        return (x % 10 == 0 && y % 10 == 0);
    }

    private static boolean containsAllDigits(String numStr, int x, int y) {
        String xyStr = Integer.toString(x) + Integer.toString(y);
        char[] numChars = numStr.toCharArray();
        char[] xyChars = xyStr.toCharArray();
        java.util.Arrays.sort(numChars);
        java.util.Arrays.sort(xyChars);

        return java.util.Arrays.equals(numChars, xyChars);
    }
}
