package org.shark;

import static org.shark.ArabicRomanNumbers.*;
import static org.shark.Operations.operate;

public class CalculateOperation {

    public static int getResult(int a, String operation, int b) {
        return operate(a, operation, b);
    }

    public static String getResult(ArabicRomanNumbers a, String operation, ArabicRomanNumbers b) {
        int arabicOperation;
        String result = "";
        arabicOperation = operate(a.getValue(), operation, b.getValue());

        if ((a.getValue() == L.getValue()) || (a.getValue() == C.getValue()) ||
                (b.getValue() == L.getValue()) || (b.getValue() == C.getValue())) {
            throw new NumberFormatException();
        }

        if (arabicOperation <= 0) {
            throw new RuntimeException("Лееее римские цифры положительные тока ты чё брат");
        }

        while (arabicOperation > 0) {
            if (arabicOperation > 10 && arabicOperation != 50 && arabicOperation != 100) {
                arabicOperation -= 10;
                result += (X);
            } else {
                result += fromValue(arabicOperation);
                break;
            }
        }
        return result;
    }
}
