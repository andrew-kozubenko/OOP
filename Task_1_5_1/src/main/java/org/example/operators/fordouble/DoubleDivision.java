package org.example.operators.fordouble;

import org.example.interfaces.Operator;

/**
 * DoubleDivision.
 */
public class DoubleDivision implements Operator<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double operand1, Double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return operand1 / operand2;
    }
}
