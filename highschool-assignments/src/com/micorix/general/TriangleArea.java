package com.micorix.general;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Assignment "Static Methods - 32"
 *
 * Implement two methods:
 * * first of which takes the length of the three sides of the triangle from the keyboard,
 * * second calculates the area of the triangle based on the length of its sides.
 * Use both methods in your program to calculate the area of the triangle. Display the result on the screen.
 */

public class TriangleArea {
    public static void main(String[] args) {
        double area = calcArea(getInput());
        System.out.println("Pole trójkąta jest równe: " + area);
    }

    private static double[] getInput() {
        Scanner sc = new Scanner(System.in);

        return Arrays.stream(new String[]{"a", "b", "c"}).map(side -> {

            System.out.printf("Wprowadź długość boku %s trójkąta%n", side);
            return sc.nextDouble();

        }).mapToDouble(x -> x).toArray();
    }

    private static double calcArea(double[] sides) {
        double p = Arrays.stream(sides).sum()/2;
        return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
    }
}
