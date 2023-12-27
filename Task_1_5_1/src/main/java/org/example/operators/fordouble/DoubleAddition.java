package org.example.operators.fordouble;

import org.example.interfaces.Operator;

/**
 * DoubleAddition.
 */
public class DoubleAddition implements Operator<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}


