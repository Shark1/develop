package org.shark;

import static org.shark.Number.ArabicRomanNumbers.*;
import static org.shark.Number.ArabicRomanNumbers.getRomanByValue;
import static org.shark.Operations.operate;
import static org.shark.Operations.ArithmeticSign;

public class CalculateOperation {

    public static int getResult(int a, String operation, int b) {
        return operate(a, ArithmeticSign.fromSign(operation), b);
    }

    public static String getResult(Number.ArabicRomanNumbers a, String operation, Number.ArabicRomanNumbers b) {
        int arabicOperation;
        String result = "";
        arabicOperation = operate(a.getValue(), ArithmeticSign.fromSign(operation), b.getValue());

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
                result += getRomanByValue(arabicOperation);
                break;
            }
        }
        return result;
    }
}
