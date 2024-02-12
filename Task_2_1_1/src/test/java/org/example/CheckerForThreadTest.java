package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * CheckerForThreadTest.
 */
public class CheckerForThreadTest {
    /**
     * testRun.
     */
    @Test
    void testRun() {
        int[] nums1 = {6, 8, 7, 13, 5, 9, 4};
        var checker1 = new CheckerForThread(nums1, 0, nums1.length);
        checker1.run();
        assertTrue(checker1.hasNonPrime);

        int[] nums2 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        var checker2 = new CheckerForThread(nums2, 0, nums2.length);
        checker2.run();
        assertFalse(checker2.hasNonPrime);
    }
}
