package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexLog.
 */
public class ComplexLog implements Function<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber operand, boolean inDegrees) {
        return ComplexNumber.log(operand);
    }
}