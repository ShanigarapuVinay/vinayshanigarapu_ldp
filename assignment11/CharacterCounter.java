package com.assignment11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CharacterCounter <input_file_name>");
            return;
        }
        String inputFile = args[0];
        String outputFile = "char_count_result.txt";
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Read the input file and count characters
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                charCountMap.put(character, charCountMap.getOrDefault(character, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Write results to output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet())
                writer.write(String.format("'%s': %d%n", entry.getKey(), entry.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}