package org.shark;

import java.util.HashMap;
import java.util.Map;

import static org.shark.ArabicRomanNumbers.fromValue;

public class Operations {

    private enum ArithmeticSign {
        PLUS("+"),
        MINUS("-"),
        DIVISION("/"),
        MULTIPLICATION("*");

        private final String SIGN;

        ArithmeticSign(String sign) {
            this.SIGN = sign;
        }

        public String getValue() {
            return SIGN;
        }

        private static final Map<String, ArithmeticSign> MAP = new HashMap<>();

        static {
            for (ArithmeticSign sign : values()) {
                MAP.put(sign.getValue(), sign);
            }
        }

        public static ArithmeticSign fromSign(String sign) {
            return MAP.get(sign);
        }
    }

    public static int operate(int a, String operation, int b) {
        return operate(fromValue(a), operation, fromValue(b));
    }

    public static int operate(ArabicRomanNumbers a, String operation, ArabicRomanNumbers b) {
        switch (ArithmeticSign.fromSign(operation)) {
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
            default -> {
                throw new IllegalArgumentException("Слышб такого знака нет");
            }
        }
    }

    private static int sum(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return sum(a.getValue(), b.getValue());
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int difference(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return difference(a.getValue(), b.getValue());
    }

    private static int difference(int a, int b) {
        return a - b;
    }

    private static int division(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return division(a.getValue(), b.getValue());
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int multiplication(ArabicRomanNumbers a, ArabicRomanNumbers b) {
        return multiplication(a.getValue(), b.getValue());
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }
}
