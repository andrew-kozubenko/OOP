package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexPow.
 */
public class ComplexPow implements Function<ComplexNumber> {
    /**
     * ComplexNumber.
     */
    @Override
    public ComplexNumber apply(ComplexNumber operand, boolean inDegrees) {
        return ComplexNumber.pow(operand, 2);
    }
}