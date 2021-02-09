package com.micorix.general;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Assignment "Static Methods - 31"
 *
 * Write two methods where the first takes the diameter of the circle and the second calculates the area of the circle.
 * Call the second method which gets the parameter using the first. Display the result on the screen.
 */


public class CircleArea {
    public static void main(String[] args) {
        double area = calcArea(getRadius());
        System.out.println("Pole koła jest równe: " + area);
    }

    private static double getRadius() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podane średnicę koła");

        return sc.nextDouble()/2;
    }

    private static double calcArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}
