package org.shark;

import java.util.HashMap;
import java.util.Map;

public enum ArabicRomanNumbers {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    L(50),
    C(100);

    private final int ARABIC_NUMBER;

    ArabicRomanNumbers(int arabicNumber) {
        this.ARABIC_NUMBER = arabicNumber;
    }

    public int getValue() {
        return ARABIC_NUMBER;
    }

    private static final Map<Integer, ArabicRomanNumbers> MAP = new HashMap<>();

    static {
        for (ArabicRomanNumbers number : values()) {
            MAP.put(number.getValue(), number);
        }
    }

    public static ArabicRomanNumbers fromValue(int number) {
        return MAP.get(number);
    }
}
