package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));

        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(13));
    }

    public static boolean checkForPalindrome(String text) {

        if (text == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        StringBuilder cleanedText = new StringBuilder();

        for (char character : text.toCharArray()) {

            if (Character.isLetterOrDigit(character)) {
                cleanedText.append(Character.toLowerCase(character));
            }
        }

        for (int i = 0; i < cleanedText.length(); i++) {
            stack.push(cleanedText.charAt(i));
        }

        for (int i = 0; i < cleanedText.length(); i++) {

            if (cleanedText.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static String convertDecimalToBinary(int number) {

        if (number == 0) {
            return "0";
        }

        Deque<Integer> stack = new ArrayDeque<>();

        while (number > 0) {

            int remainder = number % 2;

            stack.push(remainder);

            number = number / 2;
        }

        StringBuilder binary = new StringBuilder();

        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}