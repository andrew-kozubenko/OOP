package org.example;

import org.example.functions.forcomplex.ComplexFunctionFactory;
import org.example.functions.fordouble.DoubleFunctionFactory;
import org.example.interfaces.Function;
import org.example.interfaces.Operator;
import org.example.operators.forcomplex.ComplexOperatorFactory;
import org.example.types.ComplexNumber;

import java.util.Stack;

public class ComplexCalculator extends Calculator{
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
     * applyOperator.
     */
    private static ComplexNumber applyOperatorComplex(String operator, ComplexNumber operand1,ComplexNumber operand2) {
        Operator<ComplexNumber> op = ComplexOperatorFactory.createOperator(operator);
        return op.apply(operand1, operand2);
    }

    /**
     * applyFunction.
     */
    private static ComplexNumber applyFunctionComplex(String function, ComplexNumber operand, boolean inDegrees) {
        Function<ComplexNumber> func = ComplexFunctionFactory.createOperator(function);
        return func.apply(operand, inDegrees);
    }
}
