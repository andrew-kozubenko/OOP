package org.example;

import java.util.Scanner;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в префиксной форме:");
        String expression = scanner.nextLine();

        try {
            double result = Calculator.evaluateExpressionDouble(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Введите комплексное выражение в префиксной форме:");
        String expression1 = scanner.nextLine();

        try {
            ComplexNumber result1 = Calculator.evaluateExpressionComplex(expression1);
            System.out.println("Результат: " + result1.toString());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}