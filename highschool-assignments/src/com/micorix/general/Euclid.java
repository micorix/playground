package com.micorix.general;

public class Euclid {
    public static void main(String[] args) {
        System.out.println(euclid(42, 0));
    }

    public static int euclid(int a, int b) {
        if (a == 0) return b;
        if(b == 0) return a;

        if (a > b) a = a % b;

        else b = b % a;

        return euclid(a, b);
    }
}
