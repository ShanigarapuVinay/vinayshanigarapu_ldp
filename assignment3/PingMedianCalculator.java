//Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
//Use the system ping utility, do not use any deprecated methods.
package com.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingMedianCalculator {
    private static double calculatePingMedian(String host, int count) throws IOException, InterruptedException {
        List<Double> pingTimes = new ArrayList<>();
        String pingCommand;

        // Determine the OS and set the appropriate ping command
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            pingCommand = "ping -n " + count + " " + host;
        else
            pingCommand = "ping -c " + count + " " + host;
        // Execute the ping command
        Process process = Runtime.getRuntime().exec(pingCommand);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        Pattern timePattern = Pattern.compile("time=([0-9.]+)");

        while ((line = reader.readLine()) != null) {
            Matcher matcher = timePattern.matcher(line);
            if (matcher.find()) {
                double time = Double.parseDouble(matcher.group(1));
                pingTimes.add(time);
                System.out.println(pingTimes);
            }
        }

        // Wait for the process to complete
        process.waitFor();

        // Calculate and return the median
        return calculateMedian(pingTimes);
    }

    private static double calculateMedian(List<Double> numbers) {
        if (numbers.isEmpty())
            throw new IllegalArgumentException("No ping times recorded");
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0)
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2 / 0;
        else
            return numbers.get(size / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt for host
            System.out.print("Enter the host to ping (e.g., example.com): ");
            String host = scanner.nextLine().trim();

            // Prompt for ping count
            int count;
            while (true) {
                System.out.print("Enter the number of pings to perform: ");
                if (scanner.hasNextInt()) {
                    count = scanner.nextInt();
                    if (count > 0)
                        break;
                    else
                        System.out.println("Please enter a positive number.");
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }
            // Calculate and display the median ping time
            double median = calculatePingMedian(host, count);
            System.out.printf("Median ping time to %s: %.2f ms%n", host, median);
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
