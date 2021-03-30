package com.micorix.general;

public class NumberSystems {
    public static void main(String[] args) {
        System.out.println(toRadixString(64));
    }

    public static String toRadixString(int decimal) {
        return toRadixString(decimal, 2);
    }

    public static String toRadixString(int decimal, int radix) {
        StringBuilder result = new StringBuilder();

        int temporaryResult = decimal;
        while(temporaryResult > 0) {
            result.append(temporaryResult % radix);
            temporaryResult = temporaryResult / radix;
        }

        result.reverse();
        return result.toString();
    }
}
