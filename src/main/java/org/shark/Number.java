package org.shark;

import java.util.Arrays;

public class Number {
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

        private int arabicNumber;

        ArabicRomanNumbers(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public int getValue() {
            return arabicNumber;
        }

        public static ArabicRomanNumbers getRomanByValue(int arabicNumber) {
            return Arrays.stream(values())
                    .filter(v -> v.arabicNumber == arabicNumber)
                    .findFirst().orElseThrow();
        }
    }
}
