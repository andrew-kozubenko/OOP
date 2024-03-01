package org.example.hasnotprimecheck.checkers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * SequentialCheckerTest.
 */
class SequentialCheckerTest {
    /**
     * testHasNonPrime.
     */
    @Test
    void testHasNonPrime() {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        assertTrue(SequentialChecker.hasNonPrime(nums1));

        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                       6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        assertFalse(SequentialChecker.hasNonPrime(nums2));
    }
}