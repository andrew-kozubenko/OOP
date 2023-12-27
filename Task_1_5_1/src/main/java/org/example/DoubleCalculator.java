package org.example;

import java.util.Stack;
import org.example.functions.fordouble.DoubleFunctionFactory;
import org.example.interfaces.Function;
import org.example.interfaces.Operator;
import org.example.operators.fordouble.DoubleOperatorFactory;

/**
 * DoubleCalculator.
 */
public class DoubleCalculator extends Calculator {
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
     * applyOperator.
     */
    private static double applyOperator(String operator, double operand1, double operand2) {
        Operator<Double> op = DoubleOperatorFactory.createOperator(operator);
        return op.apply(operand1, operand2);
    }

    /**
     * applyFunction.
     */
    private static double applyFunction(String function, double operand, boolean inDegrees) {
        Function<Double> func = DoubleFunctionFactory.createOperator(function);
        return func.apply(operand, inDegrees);
    }
}
