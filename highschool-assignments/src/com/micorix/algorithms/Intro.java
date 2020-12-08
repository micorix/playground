package com.micorix.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Intro {

    public static void jumps() {
        Scanner sc = new Scanner(System.in);
        double currPos = sc.nextDouble();
        double distance = sc.nextDouble();
        double jumpLength = sc.nextDouble();
        System.out.println(Math.ceil((distance - currPos) / jumpLength));
    }

    public static void missingNumber (){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumOfProvided = Arrays.stream(sc.next().split(" "))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        int sumOfAll = n * (n + 1) / 2;

        System.out.println(sumOfAll - sumOfProvided);
    }
}
