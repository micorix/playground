package com.micorix.general;

import java.util.Random;

import static com.micorix.general.StdDraw.*;

public class Drawings {
    final static int canvasSize = 1000;
    final static int iterations = 10000;

    public static void main(String[] args) {
        setupCanvas();
        Random random = new Random();

        double[][] vertices = generateTriangle(canvasSize / 15);
        double[] randPoint = generateRandomPointInTriangle(vertices);

        polygon(vertices[0], vertices[1]);
        setPenRadius(.01);
        point(randPoint[0], randPoint[1]);

        double[] lastPoint = randPoint;
        for (int i = 0; i < iterations; i += 1) {
            int vertexIndex = random.nextInt(3);
            double[] midPoint = getMidpoint(
                    new double[]{vertices[0][vertexIndex], lastPoint[0]},
                    new double[]{vertices[1][vertexIndex], lastPoint[1]}
            );
            point(midPoint[0], midPoint[1]);
            lastPoint = midPoint;
        }
    }

    private static void setupCanvas() {
        setCanvasSize(canvasSize, canvasSize);
        setScale(-100, 100);
        setPenRadius(.001);
        setPenColor(BLACK);
        text(0, 90, "Sierpinski triangle");
        setPenColor(RED);
    }

    private static double[][] generateTriangle(double size) {
        double[] x = new double[3];
        double[] y = new double[3];
        for (int i = 0; i < 3; i += 1) {
            x[i] = size * Math.cos((i * 2 * Math.PI) / 3);
            y[i] = size * Math.sin((i * 2 * Math.PI) / 3);
        }
        return new double[][]{x, y};
    }

    private static double[] generateRandomPointInTriangle(double[][] vertices) {
        double[] x = vertices[0];
        double[] y = vertices[1];
        double[] randPoint = new double[2];

        double rand = Math.random();
        double sq = Math.sqrt(Math.random());

        randPoint[0] = x[0] * (1.0 - sq) + x[1] * (1.0 - rand) * sq + x[2] * rand * sq;
        randPoint[1] = y[0] * (1.0 - sq) + y[1] * (1.0 - rand) * sq + y[2] * rand * sq;

        return randPoint;
    }

    private static double[] getMidpoint(double[] x, double[] y) {
        return new double[]{(x[0] + x[1]) / 2, (y[0] + y[1]) / 2};
    }
}