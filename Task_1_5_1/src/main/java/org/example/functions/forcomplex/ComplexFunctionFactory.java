package org.example.functions.forcomplex;

import org.example.interfaces.Function;
import org.example.types.ComplexNumber;

/**
 * ComplexFunctionFactory.
 */
public class ComplexFunctionFactory {
    /**
     * createOperator.
     */
    public static Function<ComplexNumber> createOperator(String function) {
        switch (function) {
            case "log":
                return new ComplexLog();
            case "pow":
                return new ComplexPow();
            case "sqrt":
                return new ComplexSqrt();
            case "sin":
                return new ComplexSin();
            case "cos":
                return new ComplexCos();
            default:
                throw new IllegalArgumentException("Недопустимая функция: " + function);
        }
    }
}
