package com.assignment9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceChecker {
    public static void main(String[] args) {
        String regex = "^[A-Z].*\\.$";
        Pattern pattern = Pattern.compile(regex);
        String[] sentences = {
                "Vinay Shanigarapu lives in Beeramguda.",
                "this is invalid sentence.",
                "This is valid sentence.",
                "This doesn't end with period",
                "Lahari and Vinay.",
                "VL.",
                "v",
                "L"
        };
        for (String sentence : sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.matches())
                System.out.println("Valid: \"" + sentence + "\"");
            else
                System.out.println("Invalid: \"" + sentence + "\"");
        }
    }
}
