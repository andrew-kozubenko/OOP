package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PolynomialTest {
    /**
     * Test ToString.
     */
    @Test
    public void testToString1() {
        Polynomial p1 = new Polynomial(new int[]{651, 245, 56, -9, 0, -1});

        assertEquals("-x^5 - 9x^3 + 56x^2 + 245x + 651", p1.toString());
    }

    /**
     * Test ToString.
     */
    @Test
    public void testToString2() {
        Polynomial p1 = new Polynomial(new int[]{});

        assertEquals("0", p1.toString());
    }

    /**
     * Test Getter.
     */
    @Test
    public void testGetter() {
        Polynomial polynomial = new Polynomial(new int[]{1, 2, 3});
        int[] coefficients = polynomial.getCoefficients();

        assertArrayEquals(new int[]{1, 2, 3}, coefficients);
    }

    /**
     * Test Plus.
     */
    @Test
    public void testPlus() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 190, 87});
        Polynomial p2 = new Polynomial(new int[]{2, 3, 78, 89, -78, 4});
        Polynomial result = p1.plus(p2);

        assertEquals("4x^5 + 9x^4 + 279x^3 + 81x^2 + 5x + 3", result.toString());
    }

    /**
     * Test Minus.
     */
    @Test
    public void testMinus() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3});
        Polynomial p2 = new Polynomial(new int[]{2, 3, 4});
        Polynomial result = p1.minus(p2);

        assertEquals("-x^2 - x - 1", result.toString());
    }

    /**
     * Test Times.
     */
    @Test
    public void testTimes1() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3});
        Polynomial p2 = new Polynomial(new int[]{2, 3});
        Polynomial result = p1.times(p2);

        assertEquals("9x^3 + 12x^2 + 7x + 2", result.toString());
    }

    /**
     * Test Times.
     */
    @Test
    public void testTimes2() {
        Polynomial p1 = new Polynomial(new int[]{});
        Polynomial p2 = new Polynomial(new int[]{0});
        Polynomial result = p1.times(p2);

        assertEquals("0", result.toString());
    }

    /**
     * Test Evaluate.
     */
    @Test
    public void testEvaluate() {
        Polynomial poly = new Polynomial(new int[]{1, 2, 3}); // 1 + 2x + 3x^2
        int x = 2;
        int result = poly.evaluate(x);

        assertEquals(17, result);
    }

    /**
     * Test Equals.
     */
    @Test
    public void testEquals() {
        Polynomial poly1 = new Polynomial(new int[]{1, 2, 3, 6});
        Polynomial poly2 = new Polynomial(new int[]{1, 2, 3, 6});
        Polynomial poly3 = new Polynomial(new int[]{1, 2, 3, 7});
        Polynomial poly4 = new Polynomial(new int[]{0});
        Polynomial poly5 = new Polynomial(new int[]{});

        boolean cond1 = poly1.equals(poly2);
        boolean cond2 = poly2.equals(poly3);
        boolean cond3 = poly4.equals(poly5);

        assertTrue(cond1);
        assertFalse(cond2);
        assertTrue(cond3);
    }

    /**
     * Test Differentiate.
     */
    @Test
    public void testDifferentiate1() {
        Polynomial poly = new Polynomial(new int[]{1, 2, 3});
        int degree = 1;
        Polynomial result = poly.differentiate(degree);

        assertEquals("6x + 2", result.toString());
    }

    /**
     * Test Differentiate.
     */
    @Test
    public void testDifferentiate2() {
        Polynomial poly = new Polynomial(new int[]{1, 2, 3});
        int degree = 4;
        Polynomial result = poly.differentiate(degree);

        assertEquals("0", result.toString());
    }
}
