package com.micorix.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Loops{
    public static void main(String[] args) {
        goldbachConjecture();
    }
    public static void printDistinct() {
        int[] collection = {4, 5, 6, 7, 8, 4, 5};
        Arrays.stream(collection)
                .distinct()
                .forEach((el) -> System.out.println(el+" "));
    }

    public static ArrayList<Integer> getPrimeFactors(int num){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        if (num < 2) return factors;

        for (var i = 2; i <= num; i++){
            while (num % i == 0){
                factors.add(i);
                num /= i;
            }
        }
        return factors;
    }
    public static void goldbachConjecture(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();

        ArrayList<Integer> factors = getPrimeFactors(n);
        int i = 0;
        while (factors.get(i) <= n / 2) {
            int factor = factors.get(i);
            if (factor <= n/2 && factors.contains(n-factor)) {
                System.out.println(factor + " + " + (n-factor) + " = " + n);
                return;
            }
            i++;
        }

        System.out.println(n + " + 0 = " + n);
    }
}
