package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoublePow.
 */
public class DoublePow implements Function<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double  operand, boolean inDegrees) {
        return Math.pow(operand, 2);
    }
}