package com.micorix.general;

public class MonteCarlo {
    public static void main(String[] args) {
        calcPi();
    }
    public static double[] getRandomCoords(double minBound, double maxBound) {
        return new double[]{
                Math.random() * (maxBound - minBound + 1) + minBound,
                Math.random() * (maxBound - minBound + 1) + minBound
        };
    }
    public static boolean isInCircle (double r, double[] point) {
        return Math.hypot(point[0], point[1]) <= r;
    }
   public static void calcPi() {
        final int iterations = 1000;
        final double squareSide = 2;
        final double minBound = 0;
        final double maxBound = squareSide / 2;
        int pointsInCircleCounter = 0;

        for (int i = 0; i < iterations; i++) {
            double[] randomPoint = getRandomCoords(minBound, maxBound);
            if (isInCircle(squareSide, randomPoint)) {
                pointsInCircleCounter++;
            }
        }
        double estimatedPi = (pointsInCircleCounter / (float) iterations) * 4;
        System.out.println(estimatedPi);
   }
}
