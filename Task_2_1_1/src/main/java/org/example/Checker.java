package org.example;

import java.util.Arrays;

/**
 * Checker.
 */
public class Checker {
    /**
     * isPrime.
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * hasNonPrimeSequential.
     */
    public static boolean hasNonPrimeSequential(int[] nums) {
        for (int num : nums) {
            if (!isPrime(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * hasNonPrimeParallelWithThreads.
     */
    public static boolean hasNonPrimeParallelWithThreads(int[] nums,
                                                         int numThreads)
            throws InterruptedException {
        int chunkSize = nums.length / numThreads;
        CheckerForThread[] threads = new CheckerForThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? nums.length : startIndex + chunkSize;
            threads[i] = new CheckerForThread(nums, startIndex, endIndex);
            threads[i].start();
        }
        for (CheckerForThread thread : threads) {
            thread.join();
            if (thread.hasNonPrime) {
                return true;
            }
        }
        return false;
    }

    /**
     * hasNonPrimeParallelWithStream.
     */
    public static boolean hasNonPrimeParallelWithStream(int[] nums) {
        return Arrays.stream(nums).parallel().anyMatch(num -> !isPrime(num));
    }
}
