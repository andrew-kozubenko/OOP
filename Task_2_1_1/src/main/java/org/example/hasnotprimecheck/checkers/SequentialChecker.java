package org.example.hasnotprimecheck.checkers;

import java.util.Arrays;

/**
 * SequentialChecker.
 */
public class SequentialChecker extends Checker {
    /**
     * hasNonPrime.
     */
    public static boolean hasNonPrime(int[] nums) {
        return Arrays.stream(nums).sequential().anyMatch(num -> !isPrime(num));
    }
}
