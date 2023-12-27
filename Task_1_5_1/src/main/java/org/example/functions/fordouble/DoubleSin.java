package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoubleSin.
 */
public class DoubleSin implements Function<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double  operand, boolean inDegrees) {
        if (inDegrees) {
            return Math.sin(Math.toRadians(operand));
        } else {
            return Math.sin(Math.toDegrees(operand));
        }
    }
}