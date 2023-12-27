package org.example;

import org.example.types.ComplexNumber;

import java.util.Locale;
import java.util.Scanner;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        boolean isComplex = false;
        
        while(true) {
            System.out.println("Введите выражение в префиксной форме:");
            String expression = scanner.nextLine();

            if (expression.equals("stop")) {
                break;
            } else if (expression.equals("switch")) {
                isComplex = !isComplex;
                System.out.println("Режим успешно изменен на:");
                if (isComplex) {
                    System.out.println("Комплексные числа");
                } else {
                    System.out.println("Вещественные числа");
                }
                continue;
            }

            try {
                if (isComplex) {
                    ComplexNumber result = ComplexCalculator.evaluateExpressionComplex(expression, false);
                    System.out.println("Результат: " + result);
                } else {
                    double result = DoubleCalculator.evaluateExpressionDouble(expression, false);
                    System.out.println("Результат: " + result);
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage() +
                        "\nДля смены режима введите \"switch\", для завершения введите \"stop\"");
            }
        }
    }
}