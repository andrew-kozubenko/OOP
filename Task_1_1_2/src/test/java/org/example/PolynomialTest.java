package org.example;

import org.junit.jupiter.api.Test;
import org.example.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomialTest {
    @Test
    public void testToString() {
        Polynomial p1 = new Polynomial(new int[]{651, 245, 56, -9, 0, -1});

        assertEquals("-x^5 - 9x^3 + 56x^2 + 245x + 651", p1.toString());
    }
    @Test
    public void testPlus() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 190, 87});
        Polynomial p2 = new Polynomial(new int[]{2, 3, 78, 89, -78, 4});
        Polynomial result = p1.plus(p2);

        assertEquals("4x^5 + 9x^4 + 279x^3 + 81x^2 + 5x + 3", result.toString());
    }

    @Test
    public void testMinus() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3});
        Polynomial p2 = new Polynomial(new int[]{2, 3, 4});
        Polynomial result = p1.minus(p2);

        assertEquals("-x^2 - x - 1", result.toString());
    }

    @Test
    public void testTimes() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3});
        Polynomial p2 = new Polynomial(new int[]{2, 3});
        Polynomial result = p1.times(p2);

        assertEquals("9x^3 + 12x^2 + 7x + 2", result.toString());
    }

    @Test
    public void testEvaluate() {
        Polynomial poly = new Polynomial(new int[]{1, 2, 3}); // 1 + 2x + 3x^2
        int x = 2;
        int result = poly.evaluate(x);

        assertEquals(17, result);
    }

    @Test
    public void testDifferentiate() {
        Polynomial poly = new Polynomial(new int[]{1, 2, 3});
        int degree = 1;
        Polynomial result = poly.differentiate(degree);

        assertEquals("6x + 2", result.toString());
    }
}
