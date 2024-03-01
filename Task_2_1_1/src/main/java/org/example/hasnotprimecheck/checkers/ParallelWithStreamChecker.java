package org.example.hasnotprimecheck.checkers;

import java.util.Arrays;

/**
 * ParallelWithStreamChecker.
 */
public class ParallelWithStreamChecker extends Checker {
    /**
     * hasNonPrime.
     */
    public static boolean hasNonPrime(int[] nums) {
        return Arrays.stream(nums).parallel().anyMatch(num -> !isPrime(num));
    }

    /**
     * hasNonPrime.
     */
    public static boolean hasNonPrime(int[] nums, int numThreads) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
                String.valueOf(numThreads));
        boolean result = Arrays.stream(nums).parallel().anyMatch(num -> !isPrime(num));
        System.clearProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
        return result;
    }
}
