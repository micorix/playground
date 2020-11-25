package com.micorix.general;

import java.util.Arrays;


public class Loops{
    public static void main(String[] args) {
        int[] collection = {4, 5, 6, 7, 8, 4, 5};
        Arrays.stream(collection)
                .distinct()
                .forEach((el) -> System.out.println(el+" "));
    }
}
