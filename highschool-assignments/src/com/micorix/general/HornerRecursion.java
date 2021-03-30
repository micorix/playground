package com.micorix.general;

import java.util.Arrays;
import java.util.Scanner;

public class HornerRecursion {
    public static double divide(double divisor, Double[] coefficients, int deg){
        if (deg == 0) {
            return coefficients[0];
        }

        return divisor * divide(divisor, coefficients, deg-1) + coefficients[deg];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coefficients of polynomial separated by spaces");
        Double[] coefficients = Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).toArray(Double[]::new);

        System.out.println("Enter divisor");
        double divisor = sc.nextDouble();

        System.out.println(divide(divisor, coefficients, coefficients.length-1));

    }
}
