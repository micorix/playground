package com.micorix.general;

public class AsymptoticNotationExample {
    public static void main(String[] args) {
        add1(3, 5);
        add2(3, 5);
    }

    public static void add1(int n, int m){
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += 1;
        }
        for (int j = 0; j < m; j++) {
            result += 1;
        }
        System.out.println(result);
    } // O(n)

    public static void add2(int n, int m) {
        int result = n + m;
        System.out.println(result);
    } // O(1)
}
