package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexCos.
 */
public class ComplexCos implements Function<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber operand, boolean inDegrees) {
        return ComplexNumber.cos(operand, inDegrees);
    }
}