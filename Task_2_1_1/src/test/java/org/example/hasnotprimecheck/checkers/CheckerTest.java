package org.example.hasnotprimecheck.checkers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CheckerTest.
 */
public class CheckerTest {
    /**
     * testIsPrime.
     */
    @Test
    void testIsPrime() {
        Assertions.assertTrue(Checker.isPrime(2));
        assertTrue(Checker.isPrime(3));
        assertTrue(Checker.isPrime(7));
        assertTrue(Checker.isPrime(6998053));
        assertFalse(Checker.isPrime(1));
        assertFalse(Checker.isPrime(4));
        assertFalse(Checker.isPrime(9));
        assertFalse(Checker.isPrime(6998057));
    }
}
