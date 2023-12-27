package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoubleLog.
 */
public class DoubleLog implements Function<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double operand, boolean inDegrees) {
        return Math.log(operand);
    }
}