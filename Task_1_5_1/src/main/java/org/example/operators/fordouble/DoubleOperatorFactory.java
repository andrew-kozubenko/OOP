package org.example.operators.fordouble;

import org.example.interfaces.Operator;

/**
 * DoubleOperatorFactory.
 */
public class DoubleOperatorFactory {
    /**
     * createOperator.
     */
    public static Operator<Double> createOperator(String operator) {
        switch (operator) {
            case "+":
                return new DoubleAddition();
            case "-":
                return new DoubleSubtraction();
            case "*":
                return new DoubleMultiplication();
            case "/":
                return new DoubleDivision();
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }
}
