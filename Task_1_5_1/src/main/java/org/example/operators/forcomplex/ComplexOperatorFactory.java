package org.example.operators.forcomplex;

import org.example.types.ComplexNumber;
import org.example.interfaces.Operator;

/**
 * ComplexOperatorFactory.
 */
public class ComplexOperatorFactory {
    /**
     * createOperator.
     */
    public static Operator<ComplexNumber> createOperator(String operator) {
        switch (operator) {
            case "+":
                return new ComplexAddition();
            case "-":
                return new ComplexSubtraction();
            case "*":
                return new ComplexMultiplication();
            case "/":
                return new ComplexDivision();
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }
}
