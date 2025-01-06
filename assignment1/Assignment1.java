// Create a java program to search through the home directory and look for files that match a regular expression.
// The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
package com.assignment1;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Assignment1 {
    private static void searchFiles(File directory, Pattern pattern) {
        File[] files = directory.listFiles();
        if (files != null) {
            for(File file : files){
                if(file.isDirectory())
                    searchFiles(file, pattern);
                else if (pattern.matcher(file.getName()).matches()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
        else System.out.println("Files doesn't exist..");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String homeDir = System.getProperty("user.home");
        while (true) {
            System.out.print("Enter a regular expression to search for (or 'quit' to exit): ");
            String regex = scanner.nextLine();
            System.out.println(regex);
            if (regex.equalsIgnoreCase("quit"))
                break;
            try{
                Pattern pattern = Pattern.compile(regex);
                searchFiles(new File(homeDir), pattern);
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid regular expression: " + e.getDescription());
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Program terminated.");
    }
}
