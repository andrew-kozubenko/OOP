package org.example.operators.forcomplex;

import org.example.types.ComplexNumber;
import org.example.interfaces.Operator;

/**
 * ComplexAddition.
 */
public class ComplexAddition implements Operator<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber  operand1, ComplexNumber  operand2) {
        return operand1.add(operand2);
    }
}
