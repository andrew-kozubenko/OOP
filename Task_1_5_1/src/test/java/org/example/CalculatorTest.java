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
        assertEquals(5.0, Calculator.evaluateExpressionDouble("+ 2 3", false));
        assertEquals(-1.0, Calculator.evaluateExpressionDouble("- 2 3", false));
        assertEquals(4.0, Calculator.evaluateExpressionDouble("* 2 2", false));
        assertEquals(1.0, Calculator.evaluateExpressionDouble("/ 2 2", false));
        assertEquals(25.0, Calculator.evaluateExpressionDouble("pow 5", false));
        assertEquals(0.0, Calculator.evaluateExpressionDouble("log 1", false));
        assertEquals(5.0, Calculator.evaluateExpressionDouble("sqrt 25", false));
        assertEquals(1.0, Calculator.evaluateExpressionDouble("sqrt 1", false));
        assertEquals(0.0, Calculator.evaluateExpressionDouble("sin 0", false));
        assertEquals(1.0, Calculator.evaluateExpressionDouble("cos 0", false));
    }

    /**
     * testEvaluateExpressionComplex.
     */
    @Test
    void testEvaluateExpressionComplex() {
        Locale.setDefault(Locale.US);
        assertEquals("5.00",
                Calculator.evaluateExpressionComplex("+ 2 3", false).toString());
        assertEquals("-2.00i",
                Calculator.evaluateExpressionComplex("- 2 2+2i", false).toString());
        assertEquals("62.00 + 26.00i",
                Calculator.evaluateExpressionComplex("* 2+6i 7+-8i", false).toString());
        assertEquals("-0.30 + 0.51i",
                Calculator.evaluateExpressionComplex("/ 2+6i 7+-8i", false).toString());
        assertEquals("28.47 - 199.69i",
                Calculator.evaluateExpressionComplex("sin 3+6i", false).toString());
        assertEquals("-199.70 - 28.47i",
                Calculator.evaluateExpressionComplex("cos 3+6i", false).toString());
        assertEquals("1.04 + 0.79i",
                Calculator.evaluateExpressionComplex("log 2+2i", false).toString());
        assertEquals("2.20 + 1.36i",
                Calculator.evaluateExpressionComplex("sqrt 3+6i", false).toString());
        assertEquals("36.00",
                Calculator.evaluateExpressionComplex("pow 6", false).toString());
    }
}