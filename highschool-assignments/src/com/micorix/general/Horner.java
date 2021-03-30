package com.micorix.general;

import java.util.Arrays;
import java.util.Scanner;

public class Horner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coefficients of polynomial separated by spaces");
        Double[] coefficients = Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).toArray(Double[]::new);

        System.out.println("Enter divisor");
        double divisor = sc.nextDouble();

        Double[] result = new Double[coefficients.length];
        result[0] = coefficients[0];

        for (int i = 1; i < coefficients.length; i++) {
            result[i] = divisor * result[i-1] + coefficients[i];
        }

        System.out.println(Arrays.toString(result));

    }
}
