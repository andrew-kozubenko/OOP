package org.example.operators.forcomplex;

import org.example.interfaces.Operator;
import org.example.types.ComplexNumber;

/**
 * ComplexMultiplication.
 */
public class ComplexMultiplication implements Operator<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber  operand1, ComplexNumber  operand2) {
        return operand1.multiply(operand2);
    }
}
