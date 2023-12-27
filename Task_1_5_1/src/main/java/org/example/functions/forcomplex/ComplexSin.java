package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexSin.
 */
public class ComplexSin implements Function<ComplexNumber> {
    /**
     * ComplexNumber.
     */
    @Override
    public ComplexNumber apply(ComplexNumber operand, boolean inDegrees) {
        return ComplexNumber.sin(operand, inDegrees);
    }
}