package org.example.functions.fordouble;

import org.example.interfaces.Function;

/**
 * DoubleFunctionFactory.
 */
public class DoubleFunctionFactory {
    /**
     * Function.
     */
    public static Function<Double> createOperator(String function) {
        switch (function) {
            case "log":
                return new DoubleLog();
            case "pow":
                return new DoublePow();
            case "sqrt":
                return new DoubleSqrt();
            case "sin":
                return new DoubleSin();
            case "cos":
                return new DoubleCos();
            default:
                throw new IllegalArgumentException("Недопустимая функция: " + function);
        }
    }
}
