package org.example;

import java.util.Stack;

/**
 * Calculator.
 */
public class Calculator <T> {
    /**
     * evaluateExpressionDouble.
     */
    public static double evaluateExpressionDouble(String expression, boolean inDegrees) {
        Stack<Double> operands = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumber(token)) {
                operands.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double operand1 = operands.pop();
                double operand2 = operands.pop();
                double result = applyOperator(token, operand1, operand2);
                operands.push(result);
            } else if (isFunction(token)) {
                double operand = operands.pop();
                double result = applyFunction(token, operand, inDegrees);
                operands.push(result);
            } else {
                throw new IllegalArgumentException("Недопустимый токен: " + token);
            }
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        return operands.pop();
    }

    /**
     * evaluateExpressionComplex.
     */
    public static ComplexNumber evaluateExpressionComplex(String expression, boolean inDegrees) {
        Stack<ComplexNumber> operands = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumber(token)) {
                operands.push(new ComplexNumber(Double.parseDouble(token), 0));
            } else if (isComplexNumber(token)) {
                String[] parts = token.split("\\+");
                double realPart = Double.parseDouble(parts[0]);
                double imagPart = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
                operands.push(new ComplexNumber(realPart, imagPart));
            } else if (isOperator(token)) {
                ComplexNumber operand1 = operands.pop();
                ComplexNumber operand2 = operands.pop();
                ComplexNumber result = applyOperatorComplex(token, operand1, operand2);
                operands.push(result);
            } else if (isFunction(token)) {
                ComplexNumber operand = operands.pop();
                ComplexNumber result = applyFunctionComplex(token, operand, inDegrees);
                operands.push(result);
            } else {
                throw new IllegalArgumentException("Недопустимый токен: " + token);
            }
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        return operands.pop();
    }

    /**
     * isNumber.
     */
    private static boolean isNumber(String token) {
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
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * isFunction.
     */
    private static boolean isFunction(String token) {
        return token.equals("log") || token.equals("pow") || token.equals("sqrt") || token.equals("sin") || token.equals("cos");
    }

    /**
     * isComplexNumber.
     */
    private static boolean isComplexNumber(String token) {
        return token.matches("-?\\d+\\.?\\d*\\+(-?\\d+\\.?\\d*)?i");
    }

    /**
     * applyOperator.
     */
    private static double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }

    /**
     * applyOperator.
     */
    private static ComplexNumber applyOperatorComplex(String operator, ComplexNumber operand1,ComplexNumber operand2) {
        switch (operator) {
            case "+":
                return operand1.add(operand2);
            case "-":
                return operand1.subtract(operand2);
            case "*":
                return operand1.multiply(operand2);
            case "/":
                if (operand2.isZero()) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return operand1.divide(operand2);
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }

    /**
     * applyFunction.
     */
    private static double applyFunction(String function, double operand, boolean inDegrees) {
        switch (function) {
            case "log":
                return Math.log(operand);
            case "pow":
                return Math.pow(operand, 2);
            case "sqrt":
                return Math.sqrt(operand);
            case "sin":
                if (inDegrees) {
                    return Math.sin(Math.toRadians(operand));
                } else {
                    return Math.sin(Math.toDegrees(operand));
                }
            case "cos":
                if (inDegrees) {
                    return Math.cos(Math.toRadians(operand));
                } else {
                    return Math.cos(Math.toDegrees(operand));
                }
            default:
                throw new IllegalArgumentException("Недопустимая функция: " + function);
        }
    }

    /**
     * applyFunction.
     */
    private static ComplexNumber applyFunctionComplex(String function, ComplexNumber operand, boolean inDegrees) {
        switch (function) {
            case "log":
                return ComplexNumber.log(operand);
            case "pow":
                return ComplexNumber.pow(operand, 2);
            case "sqrt":
                return ComplexNumber.sqrt(operand);
            case "sin":
                return ComplexNumber.sin(operand, inDegrees);
            case "cos":
                return ComplexNumber.cos(operand, inDegrees);
            default:
                throw new IllegalArgumentException("Недопустимая функция: " + function);
        }
    }
}
