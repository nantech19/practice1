package com.nandu.pro.javapractice1.specific;

public class SimpleAggregation {
    private int count;
    private double sum;
    private double average;
    private double min;
    private double max;

    public SimpleAggregation() {
        count = 0;
        sum = 0.0;
        average = 0.0;
        min = Double.POSITIVE_INFINITY;
        max = Double.NEGATIVE_INFINITY;
    }

    public void processNewDataPoint(double newDataPoint) {
        // Update count
        count++;

        // Update sum
        sum += newDataPoint;

        // Update average
        average = sum / count;

        // Update min and max
        min = Math.min(min, newDataPoint);
        max = Math.max(max, newDataPoint);
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public static void main(String[] args) {
        SimpleAggregation aggregator = new SimpleAggregation();

        // Simulate incoming data points
        double[] dataPoints = {10.5, 20.0, 15.3, 12.8, 18.7};

        for (double dataPoint : dataPoints) {
            aggregator.processNewDataPoint(dataPoint);
            System.out.println("Count: " + aggregator.getCount());
            System.out.println("Sum: " + aggregator.getSum());
            System.out.println("Average: " + aggregator.getAverage());
            System.out.println("Min: " + aggregator.getMin());
            System.out.println("Max: " + aggregator.getMax());
            System.out.println();
        }
    }
}

