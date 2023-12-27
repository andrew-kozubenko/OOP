package org.example;

/**
 * Calculator.
 */
public abstract class Calculator {
    /**
     * isNumber.
     */
    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * isOperator.
     */
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    /**
     * isFunction.
     */
    public static boolean isFunction(String token) {
        return token.equals("log") || token.equals("pow") || token.equals("sqrt")
                || token.equals("sin") || token.equals("cos");
    }

    /**
     * isComplexNumber.
     */
    public static boolean isComplexNumber(String token) {
        return token.matches("-?\\d+\\.?\\d*\\+(-?\\d+\\.?\\d*)?i");
    }
}
