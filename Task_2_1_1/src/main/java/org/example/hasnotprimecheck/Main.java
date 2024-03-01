package org.example.hasnotprimecheck;

import javax.swing.*;
import org.example.hasnotprimecheck.checkers.ParallelWithStreamChecker;
import org.example.hasnotprimecheck.checkers.ParallelWithThreadsChecker;
import org.example.hasnotprimecheck.checkers.SequentialChecker;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        int[] testData = generateTestData(1000000);
        long[] executionTimes = new long[8];

        testSequential(testData, executionTimes);
        testParallelWithThreads(testData, executionTimes);
        testParallelWithStream(testData, executionTimes);

        printTimes(executionTimes);
        buildChart(executionTimes);
    }

    /**
     * printTimes.
     */
    public static void printTimes(long[] executionTimes) {
        for (int i = 0; i < executionTimes.length; i++) {
            System.out.println("Execution time for method " + (i + 1) + ": "
                    + executionTimes[i] + " milliseconds");
        }
    }

    /**
     * buildChart.
     */
    public static void buildChart(long[] executionTimes) {
        SwingUtilities.invokeLater(() -> {
            ChartBuilder ex = new ChartBuilder(executionTimes);
            ex.setVisible(true);
        });
    }

    /**
     * testSequential.
     */
    public static void testSequential(int[] testData, long[] executionTimes) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        SequentialChecker.hasNonPrime(testData);
        endTime = System.currentTimeMillis();

        executionTimes[0] = endTime - startTime;
        System.out.println("1: Sequential method finished");
    }

    /**
     * testParallelWithThreads.
     */
    public static void testParallelWithThreads(int[] testData, long[] executionTimes) {
        long startTime;
        long endTime;
        int[] threadCounts = {1, 2, 4, 8, 16, 32};
        for (int i = 0; i < threadCounts.length; i++) {
            try {
                startTime = System.currentTimeMillis();
                ParallelWithThreadsChecker.hasNonPrime(testData, threadCounts[i]);
                endTime = System.currentTimeMillis();
                executionTimes[i + 1] = endTime - startTime;
                System.out.println((i + 2) + ": Parallel method with "
                        + threadCounts[i] + " threads finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * testParallelWithStream.
     */
    public static void testParallelWithStream(int[] testData, long[] executionTimes) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        ParallelWithStreamChecker.hasNonPrime(testData);
        endTime = System.currentTimeMillis();
        executionTimes[7] = endTime - startTime;
        System.out.println("8: Parallel stream method finished");
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

