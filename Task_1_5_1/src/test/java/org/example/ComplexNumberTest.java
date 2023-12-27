package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import org.junit.jupiter.api.Test;

/**
 * ComplexNumberTest.
 */
public class ComplexNumberTest {
    /**
     * testAdd.
     */
    @Test
    void testAdd() {
        Locale.setDefault(Locale.US);
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(4, 5);
        ComplexNumber result = num1.add(num2);
        assertEquals("6.00 + 8.00i", result.toString());
    }

    /**
     * testSubtract.
     */
    @Test
    void testSubtract() {
        Locale.setDefault(Locale.US);
        ComplexNumber num1 = new ComplexNumber(5, 7);
        ComplexNumber num2 = new ComplexNumber(2, 3);
        ComplexNumber result = num1.subtract(num2);
        assertEquals("3.00 + 4.00i", result.toString());
    }

    /**
     * testMultiply.
     */
    @Test
    void testMultiply() {
        Locale.setDefault(Locale.US);
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(4, 5);
        ComplexNumber result = num1.multiply(num2);
        assertEquals("-7.00 + 22.00i", result.toString());
    }

    /**
     * testDivide.
     */
    @Test
    void testDivide() {
        Locale.setDefault(Locale.US);
        ComplexNumber num1 = new ComplexNumber(4, 7);
        ComplexNumber num2 = new ComplexNumber(2, 3);
        ComplexNumber result = num1.divide(num2);
        assertEquals("2.23 + 0.15i", result.toString());
    }

    /**
     * testDivideByZero.
     */
    @Test
    void testDivideByZero() {
        Locale.setDefault(Locale.US);
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(0, 0);
        assertThrows(ArithmeticException.class, () -> {
            num1.divide(num2);
        });
    }

    /**
     * testLog.
     */
    @Test
    void testLog() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(3, 4);
        ComplexNumber result = ComplexNumber.log(num);
        assertEquals("1.61 + 0.93i", result.toString());
    }

    /**
     * testPow.
     */
    @Test
    void testPow() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(2, 3);
        ComplexNumber result = ComplexNumber.pow(num, 2);
        assertEquals("-5.00 + 12.00i", result.toString());
    }

    /**
     * testSqrt.
     */
    @Test
    void testSqrt() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(3, 4);
        ComplexNumber result = ComplexNumber.sqrt(num);
        assertEquals("2.00 + 1.00i", result.toString());
    }

    /**
     * testSin.
     */
    @Test
    void testSin() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(1, 2);
        ComplexNumber result = ComplexNumber.sin(num);
        assertEquals("3.17 + 1.96i", result.toString());
    }

    /**
     * testCos.
     */
    @Test
    void testCos() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(1, 2);
        ComplexNumber result = ComplexNumber.cos(num);
        assertEquals("2.03 - 3.05i", result.toString());
    }

    /**
     * testToString.
     */
    @Test
    void testToString() {
        Locale.setDefault(Locale.US);
        ComplexNumber num = new ComplexNumber(2, -3);
        assertEquals("2.00 - 3.00i", num.toString());
    }
}
