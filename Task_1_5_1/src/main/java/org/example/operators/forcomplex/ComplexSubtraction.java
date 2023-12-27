package org.example.operators.forcomplex;

import org.example.interfaces.Operator;
import org.example.types.ComplexNumber;

/**
 * ComplexSubtraction.
 */
public class ComplexSubtraction  implements Operator<ComplexNumber> {
    /**
     * apply.
     */
    @Override
    public ComplexNumber apply(ComplexNumber  operand1, ComplexNumber  operand2) {
        return operand1.subtract(operand2);
    }
}
