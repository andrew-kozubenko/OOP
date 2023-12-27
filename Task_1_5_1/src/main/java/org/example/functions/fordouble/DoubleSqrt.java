package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoubleSqrt.
 */
public class DoubleSqrt implements Function<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double  operand, boolean inDegrees) {
        return Math.sqrt(operand);
    }
}