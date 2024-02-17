package org.example.hasnotprimecheck.checkers;

public class ParallelWithThreadsChecker extends Checker {
    /**
     * hasNonPrimeParallelWithThreads.
     */
    public static boolean hasNonPrime(int[] nums, int numThreads)
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
}
