package com.micorix.general;

import java.util.Scanner;

public class Root {

    public static void main(String[] args) {
        final int ITERATIONS = 5;

        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();

        double x = estimateRoot(n);

        for (int i = 0; i < ITERATIONS; i++) {
            x = (x+n/x)/2;
        }

        System.out.println(x);
    }
    public static double estimateRoot(double n) {
        return n/2;
    }
}
