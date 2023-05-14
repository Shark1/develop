package org.shark;

import org.shark.Number.ArabicRomanNumbers;

import java.util.Arrays;

import static org.shark.Number.ArabicRomanNumbers.*;
import static org.shark.Operations.ArithmeticSign.PLUS;

public class Operations {

    public enum ArithmeticSign {
        PLUS("+"),
        MINUS("-"),
        DIVISION("/"),
        MULTIPLICATION("*");

        private String sign;

        ArithmeticSign(String sign) {
            this.sign = sign;
        }

        public static ArithmeticSign fromSign(String sign) {
            return Arrays.stream(values())
                    .filter(v -> v.sign.equals(sign) )
                    .findFirst().orElseThrow();
        }
    }

    public static int operate(int a, ArithmeticSign operation, int b) {
        return Integer.parseInt(operate(getRomanByValue(a), operation, getRomanByValue(b)));
    }

    public static String operate(ArabicRomanNumbers a, ArithmeticSign operation, ArabicRomanNumbers b) {
        switch (operation) {
            case PLUS -> {
                return sum(a, b);
            }
            case MINUS -> {
                return difference(a, b);
            }
            case DIVISION -> {
                return division(a, b);
            }
            case MULTIPLICATION -> {
                return multiplication(a, b);
            }
        }
        return null;
    }

    private static String sum(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return String.valueOf(sum(a.getValue(), b.getValue()));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static String difference(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return String.valueOf(difference(a.getValue(), b.getValue()));
    }

    private static int difference(int a, int b) {
        return a - b;
    }

    private static String division(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return String.valueOf(division(a.getValue(), b.getValue()));
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static String multiplication(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return String.valueOf(multiplication(a.getValue(), b.getValue()));
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }
}
