package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexSqrt.
 */
public class ComplexSqrt implements Function<ComplexNumber> {
    /**
     * ComplexNumber.
     */
    @Override
    public ComplexNumber apply(ComplexNumber operand, boolean inDegrees) {
        return ComplexNumber.sqrt(operand);
    }
}