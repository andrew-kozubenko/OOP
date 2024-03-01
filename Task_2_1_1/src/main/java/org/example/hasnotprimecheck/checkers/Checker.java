package org.example.hasnotprimecheck.checkers;

/**
 * Checker.
 */
public abstract class Checker {
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
}
