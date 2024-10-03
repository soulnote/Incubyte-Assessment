package com.incubyte;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {

        String s = "//;\n1;2";
        System.out.println( addTheNumbers(s));
        
    }

    public static int addTheNumbers(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] numArray = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String num : numArray) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                negativeNumbers.add(n);
            }
            sum += n;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}