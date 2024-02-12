package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * CheckerTest.
 */
class CheckerTest {
    /**
     * testIsPrime.
     */
    @Test
    void testIsPrime() {
        assertTrue(Checker.isPrime(2));
        assertTrue(Checker.isPrime(3));
        assertTrue(Checker.isPrime(7));
        assertTrue(Checker.isPrime(6998053));
        assertFalse(Checker.isPrime(4));
        assertFalse(Checker.isPrime(9));
        assertFalse(Checker.isPrime(6998057));
    }

    /**
     * testHasNonPrimeSequential.
     */
    @Test
    void testHasNonPrimeSequential() {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};

        assertTrue(Checker.hasNonPrimeSequential(nums1));
        assertFalse(Checker.hasNonPrimeSequential(nums2));
    }

    /**
     * testHasNonPrimeParallelWithThreads.
     */
    @Test
    void testHasNonPrimeParallelWithThreads() throws InterruptedException {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};

        assertTrue(Checker.hasNonPrimeParallelWithThreads(nums1, 4));
        assertFalse(Checker.hasNonPrimeParallelWithThreads(nums2, 4));
    }

    /**
     * testHasNonPrimeParallelWithSteam.
     */
    @Test
    void testHasNonPrimeParallelWithSteam() throws InterruptedException {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};

        assertTrue(Checker.hasNonPrimeParallelWithStream(nums1));
        assertFalse(Checker.hasNonPrimeParallelWithStream(nums2));
    }
}