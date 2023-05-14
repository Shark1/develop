package org.shark;

import java.util.Arrays;

public class Number {
    public enum ArabicRomanNumbers {//зачем вложенный если по сути класс Number не юзается

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
        C(100);//есть еще M=1000 и D=500

        private int arabicNumber;//final

        ArabicRomanNumbers(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public int getValue() {
            return arabicNumber;
        }

        public static ArabicRomanNumbers getRomanByValue(int arabicNumber) {
            //каждый раз перебираем массив из значений o(n), лучше собрать статический Map<Integer, ArabicRomanNumbers> чтобы при запуске один раз собрать и полчать значение за o(1)
            return Arrays.stream(values())
                    .filter(v -> v.arabicNumber == arabicNumber)
                    .findFirst().orElseThrow();
        }
    }
}
