package com.micorix.algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountingElements {
    public static void main(String[] args) {
        isPermutation();
    }
    public static void isPermutation() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] counters = new int[n];
        AtomicBoolean isSequencePermutation = new AtomicBoolean(true);

        sc.nextLine();  // Consume newline left-over
        Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(num -> {
                    if (counters[num] > n || counters[num] == 1)
                        isSequencePermutation.set(false);
                    else
                        counters[num] = 1;
                });

        System.out.println(isSequencePermutation.get() ? "TAK" : "NIE");
    }

    public static void howManyLeaves() {
        Scanner sc = new Scanner(System.in);
        int desiredPosition = sc.nextInt();
        int totalLeaves = sc.nextInt();

        int[] counters = new int[totalLeaves];

        sc.nextLine();  // Consume newline left-over
        Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(num -> counters[num] += 1);

        int blankSpots = totalLeaves;
        int score = -1;

        for (int i = 0; i < desiredPosition; i++) {
            if (counters[i] == 0)
                blankSpots -= 1;
            if (blankSpots == 0)
                score = i + 1;

            counters[i] = 1;
        }

        System.out.println(score);
    }
}
