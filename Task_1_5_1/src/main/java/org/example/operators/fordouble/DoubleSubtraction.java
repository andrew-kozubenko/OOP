package org.example.operators.fordouble;

import org.example.interfaces.Operator;

/**
 * DoubleSubtraction.
 */
public class DoubleSubtraction implements Operator<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double operand1, Double operand2) {
        return operand1 - operand2;
    }
}

