package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import org.junit.jupiter.api.Test;

/**
 * CalculatorTest.
 */
public class CalculatorTest {
    /**
     * testEvaluateExpressionDouble.
     */
    @Test
    void testEvaluateExpressionDouble() {
        Locale.setDefault(Locale.US);
        assertEquals(5.0, Calculator.evaluateExpressionDouble("+ 2 3"));
        assertEquals(4.0, Calculator.evaluateExpressionDouble("* 2 2"));
        assertEquals(25.0, Calculator.evaluateExpressionDouble("pow 5"));
        assertEquals(1.0, Calculator.evaluateExpressionDouble("sqrt 1"));
        assertEquals(0.0, Calculator.evaluateExpressionDouble("sin 0"));
    }

    /**
     * testEvaluateExpressionComplex.
     */
    @Test
    void testEvaluateExpressionComplex() {
        Locale.setDefault(Locale.US);
        assertEquals("5.00",
                Calculator.evaluateExpressionComplex("+ 2 3").toString());
        assertEquals("4.00 + 2.00i",
                Calculator.evaluateExpressionComplex("+ 2 2+2i").toString());
        assertEquals("62.00 + 26.00i",
                Calculator.evaluateExpressionComplex("* 2+6i 7+-8i").toString());
        assertEquals("28.47 - 199.69i",
                Calculator.evaluateExpressionComplex("sin 3+6i").toString());
        assertEquals("2.20 + 1.36i",
                Calculator.evaluateExpressionComplex("sqrt 3+6i").toString());
    }
}