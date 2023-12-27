package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoubleCos.
 */
public class DoubleCos implements Function<Double> {
    /**
     * apply.
     */
    @Override
    public Double apply(Double  operand, boolean inDegrees) {
        if (inDegrees) {
            return Math.cos(Math.toRadians(operand));
        } else {
            return Math.cos(Math.toDegrees(operand));
        }
    }
}