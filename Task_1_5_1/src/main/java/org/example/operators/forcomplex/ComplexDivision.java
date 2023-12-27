package org.example.operators.forcomplex;

import org.example.types.ComplexNumber;
import org.example.interfaces.Operator;

/**
 * ComplexDivision.
 */
public class ComplexDivision implements Operator<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber  operand1, ComplexNumber  operand2) {
        return operand1.divide(operand2);
    }
}