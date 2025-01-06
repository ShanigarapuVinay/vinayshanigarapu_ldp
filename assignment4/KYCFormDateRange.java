package com.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KYCFormDateRange {

    public static String calculateKYCRange(String signupDateStr, String currentDateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date signupDate = sdf.parse(signupDateStr);
        Date currentDate = sdf.parse(currentDateStr);

        Calendar signup = Calendar.getInstance();
        Calendar current = Calendar.getInstance();
        Calendar anniversary = Calendar.getInstance();

        signup.setTime(signupDate);
        current.setTime(currentDate);

        // Find the closest anniversary
        anniversary.set(current.get(Calendar.YEAR), signup.get(Calendar.MONTH), signup.get(Calendar.DATE));

        // If the anniversary is more than 30 days in the future, use last year's anniversary
        if (anniversary.getTimeInMillis() - current.getTimeInMillis() > 30L * 24 * 60 * 60 * 1000) {
            anniversary.add(Calendar.YEAR, -1);
        }

        if (signup.after(current))
            return "No range";

        // Calculate the KYC range
        Calendar startDate = (Calendar) anniversary.clone();
        startDate.add(Calendar.DATE, -30);
        Calendar endDate = (Calendar) anniversary.clone();
        endDate.add(Calendar.DATE, 30);

        // Adjust endDate if it's later than the current date
        if (endDate.after(current)) {
            endDate = (Calendar) current.clone();
        }

        // Format the output
        return sdf.format(startDate.getTime()) + " " + sdf.format(endDate.getTime());
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
             String[] dates = scanner.nextLine().split(" ");
            System.out.println(calculateKYCRange(dates[0], dates[1]));
        }

        scanner.close();
    }
}