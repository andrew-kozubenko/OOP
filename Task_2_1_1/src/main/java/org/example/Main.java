package org.example;

import javax.swing.*;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        int[] testData = generateTestData(1000000);

        long startTime, endTime;
        long[] executionTimes = new long[5];

        startTime = System.currentTimeMillis();
        Checker.hasNonPrimeSequential(testData);
        endTime = System.currentTimeMillis();
        executionTimes[0] = endTime - startTime;
        System.out.println("1: Sequential method finished");

        int[] threadCounts = {2, 4, 8};
        for (int i = 0; i < threadCounts.length; i++) {
            try {
                startTime = System.currentTimeMillis();
                Checker.hasNonPrimeParallelWithThreads(testData, threadCounts[i]);
                endTime = System.currentTimeMillis();
                executionTimes[i + 1] = endTime - startTime;
                System.out.println((i + 2) + ": Parallel method with "
                        + threadCounts[i] + " threads finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        startTime = System.currentTimeMillis();
        Checker.hasNonPrimeParallelWithStream(testData);
        endTime = System.currentTimeMillis();
        executionTimes[4] = endTime - startTime;
        System.out.println("5: Parallel stream method finished");

        for (int i = 0; i < executionTimes.length; i++) {
            System.out.println("Execution time for method " + (i + 1) + ": "
                    + executionTimes[i] + " milliseconds");
        }

        SwingUtilities.invokeLater(() -> {
            ChartBuilder ex = new ChartBuilder(executionTimes);
            ex.setVisible(true);
        });
    }

    /**
     * generateTestData.
     */
    public static int[] generateTestData(int size) {
        int[] testData = new int[size];
        int[] testData1 = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        for (int i = 0; i < size; i++) {
            testData[i] = testData1[i % 12];
        }
        return testData;
    }
}

