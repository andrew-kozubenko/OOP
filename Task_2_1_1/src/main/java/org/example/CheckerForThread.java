package org.example;

/**
 * CheckerForThread.
 */
class CheckerForThread extends Thread {
    private int[] nums;
    private int start, end;

    public boolean hasNonPrime = false;

    /**
     * CheckerForThread.
     */
    public CheckerForThread(int[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (!Checker.isPrime(nums[i])) {
                hasNonPrime = true;
                return;
            }
        }
    }
}
