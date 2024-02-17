package org.example.hasnotprimecheck.checkers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * ParallelWithStreamCheckerTest.
 */
public class ParallelWithStreamCheckerTest {
    /**
     * testHasNonPrime.
     */
    @Test
    void testHasNonPrime() throws InterruptedException {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        assertTrue(ParallelWithStreamChecker.hasNonPrime(nums1));

        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                       6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        assertFalse(ParallelWithStreamChecker.hasNonPrime(nums2));

        int[] nums3 = {6, 8, 7, 13, 5, 9, 4};
        assertTrue(ParallelWithStreamChecker.hasNonPrime(nums3, 4));

        int[] nums4 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                       6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        assertFalse(ParallelWithStreamChecker.hasNonPrime(nums4, 4));
    }
}
