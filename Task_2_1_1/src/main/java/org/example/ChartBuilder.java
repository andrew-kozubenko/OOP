package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

/**
 * ChartBuilder.
 */
public class ChartBuilder extends JFrame {
    long[] executionTimes;

    /**
     * ChartBuilder.
     */
    public ChartBuilder(long[] executionTimes) {
        this.executionTimes = executionTimes;
        initUI();
    }

    /**
     * initUI.
     */
    private void initUI() {
        setTitle("Execution Time Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        ChartPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * ChartPanel.
     */
    private ChartPanel createChartPanel() {
        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(
                "Execution Time",
                "Method",
                "Time (milliseconds)",
                dataset
        );

        return new ChartPanel(chart);
    }

    /**
     * DefaultCategoryDataset.
     */
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(executionTimes[0], "Time", "Sequential");
        dataset.addValue(executionTimes[1], "Time", "Parallel (2 threads)");
        dataset.addValue(executionTimes[2], "Time", "Parallel (4 threads)");
        dataset.addValue(executionTimes[3], "Time", "Parallel (8 threads)");
        dataset.addValue(executionTimes[4], "Time", "Parallel (parallelStream)");

        return dataset;
    }
}
