package com.micorix.general;

import java.util.*;
import java.util.stream.IntStream;

public class ConditionalStatements {
    // Basics

    /**
     * Helper method for reading integers from console
     *
     * @param n how many integers are needed to be asked for
     * @return integers fetched from console
     */
    private static int[] getIntsFromInput(int n) {
        System.out.println("Enter "+n+" integers (each in new line)");
        Scanner in = new Scanner(System.in);
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++){
            inputs[i] = in.nextInt();
        }
        return inputs;
    }

    /**
     * Assignment "Conditional Statements - 1a"
     *
     * 1. Get two integers from console.
     * 2. Print them in ascending order. If both are equal, print only one of them.
     */
    public static void sortNumbers() {
        int[] in = getIntsFromInput(2);
        int a = in[0], b = in[1];
        if (a == b) System.out.println(a);
        else System.out.println(a > b ? a+" "+b : b+" "+a);
    }

    /**
     * Assignment "Conditional Statements - 1b"
     *
     * 1. Get three integers from console.
     * 2. Print the greatest of them.
     */
    public static void getGreatestNumber() {
        int[] in = getIntsFromInput(3);
        int a = in[0], b = in[1], c = in[2];
        if(a > b && a > c) System.out.println("The greatest number is:"+a);
        else if (b > c) System.out.println("The greatest number is:"+b);
        else System.out.println("The greatest number is:"+c);
    }

    /**
     * Assignment "Conditional Statements - 1c"
     *
     * 1. Get three integers from console.
     * 2. Print the smallest of them.
     */
    public static void getSmallestNumber() {
        int[] in = getIntsFromInput(3);
        int a = in[0], b = in[1], c = in[2];
        if(a < b && a < c) System.out.println("The smallest number is:"+a);
        else if (b < c) System.out.println("The smallest number is:"+b);
        else System.out.println("The smallest number is:"+c);
    }

    /**
     * Assignment "Conditional Statements - 1d"
     *
     * 1. Get three integers from console.
     * 2. Print unique numbers.
     */
    public static void getUniqueNumbers(){
        int[] in = getIntsFromInput(3);
        Arrays.stream(in).distinct().forEach(item -> System.out.println(item+" "));
    }

    /**
     * Assignment "Conditional Statements - 1e"
     *
     * 1. Get one integer from console.
     * 2. Check if given year is a leap year.
     */
    public static void isLeapYear(){
        int year = getIntsFromInput(1)[0];
        boolean isLeap = year % 100 != 0 && (year % 400 == 0 || year % 4 == 0);
        System.out.println(year+" is "+(!isLeap ? "not" : "")+" a leap year");
    }

    /**
     * Assignment "Conditional Statements - 1f"
     *
     * 1. Get two integers from console.
     * 2. Subtract smaller one from the greater one.
     */
    public static void subtractFromGreater(){
        int[] in = getIntsFromInput(2);
        System.out.println(Math.abs(in[0]-in[1]));
    }

    /**
     * Assignment "Conditional Statements - 1g"
     *
     * 1. Get two integers from console.
     * 2. Subtract one from another using their absolute values.
     */
    public static void subtractUsingAbsoluteValue(){
        int[] in = getIntsFromInput(2);
        System.out.println(Math.abs(in[0])-Math.abs(in[1]));
    }

    /**
     * Assignment "Conditional Statements - 1h"
     *
     * 1. Get three integers from console.
     * 2. Print them in ascending order.
     */
    public static void printInAscendingOrder(){
        int[] in = getIntsFromInput(3);
        Arrays.stream(in)
                .sorted()
                .forEach(item -> System.out.println(item+" "));
    }

    /**
     * Assignment "Conditional Statements - 1i"
     *
     * 1. Get two integers from console (month, date)
     * 2. Check if given date is correct.
     */
    public static void isDateValid(){
        // TODO: Use try/catch with DateTimeFormatter

        int[] in = getIntsFromInput(2);
        int month = in[0], day = in[1];
        List<Integer> monthsWith30Days = Arrays.asList(4, 6, 9, 11);

        if (month < 0 || month > 12 || day < 1 || day > 31){
            System.out.println("Given date is invalid");
        }else {
            if((monthsWith30Days.contains(month) && day > 30) ||
               (month == 2 && (day < 28 || day > 29))) {
                System.out.println("Given date is invalid");
            } else System.out.println("Given date is valid");
        }
    }

    /**
     * Assignment "Conditional Statements - 1j"
     *
     * 1. Get three integers from console.
     * 2. Print median of these three numbers.
     */
    public static void getMedian(){
        int[] in = getIntsFromInput(3);
        System.out.println(Arrays.stream(in).sorted().toArray()[1]);
    }

    /**
     * Assignment "Conditional Statements - 1k"
     *
     * 1. Get two integers from console.
     * 2. Print random number greater than first number but smaller than the second one.
     */
    public static void getRandomInRange(){
        int[] in = getIntsFromInput(3);
        int minBound = in[0], maxBound = in[1];
        System.out.println(Math.random() * (maxBound - minBound + 1) + minBound);
    }

    /**
     * Assignment "Conditional Statements - 1l"
     *
     * 1. Get integer from console (minutes).
     * 2. Print how many hours and minutes it is.
     */
    public static void minutesToHoursAndMinutes(){
        int totalMinutes = getIntsFromInput(1)[0];
        int hours = totalMinutes / 60;
        int minutes = totalMinutes - hours*60;
        System.out.println(totalMinutes+"min equals "+hours+"h and "+minutes+"min");
    }

    /**
     * Assignment "Conditional Statements - 1m"
     *
     * 1. Get three integers from console (minutes).
     * 2. Print sum of integers formatted as HH:MM.
     */
    public static void formatMinutesSum(){
        int[] in = getIntsFromInput(3);
        int totalMinutes = Arrays.stream(in).sum();

        int hours = totalMinutes / 60;
        int minutes = totalMinutes - hours*60;
        System.out.println(String.format("%02d", hours)+":"+String.format("%02d", minutes));
    }

    /**
     * Assignment "Conditional Statements - 1n"
     *
     * 1. Get two integers from console (date, month).
     * 2. Print which season it is.
     */
    private static int calcDateHelper(int date, int month) {
        return date+month*100;
    }

    public static void getSeason(){
        // some kind of experiment
        int[] in = getIntsFromInput(2);
        int date = in[0], month = in[1];

        int helper = calcDateHelper(date, month);
        int springHelper = calcDateHelper(20, 3);
        int summerHelper = calcDateHelper(21, 6);
        int fallHelper = calcDateHelper(22, 9);
        int winterHelper = calcDateHelper(22, 12);

        if (helper < springHelper || helper > winterHelper){
            System.out.println("It's winter!");
        } else if (helper < summerHelper) {
            System.out.println("It's spring!");
        } else if (helper < fallHelper) {
            System.out.println("It's summer!");
        } else {
            System.out.println("It's fall!");
        }
    }

    // Random numbers

    private static int[] generateRandomInts(int n, int minBound, int maxBound){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = (int) (Math.random() * (maxBound - minBound + 1)) + minBound;
        }
        return result;
    }

    /**
     * Assignment "Conditional Statements - 2a"
     *
     * 1. Generate 3 random number (1-6 range).
     * 2. Check for duplicates
     */
    public static void checkForDuplicates(){
        IntStream random = Arrays.stream(generateRandomInts(3, 1, 6));
        random.forEach(item -> System.out.println(item+" "));
        boolean hasDuplicates = random.distinct().toArray().length != 3;
        System.out.println("List has "+(hasDuplicates ? "" : "no")+" duplicates");
    }

    /**
     * Assignment "Conditional Statements - 2b"
     *
     * 1. Self-explanatory I guess haha
     */

    public static void whatDoesTheFortuneCookieSay(){
        String[] fortunes = {
                "A friend's frown is better than a fool's smile",
                "A friend is easier lost than found.",
                "Be slow in choosing, but slower in changing.",
                "If you lose your temper, don't look for it.",
                "As one door closes, another always opens.",
                "Adversity flatters no man."
        };
        int random = generateRandomInts(1, 1, 6)[0];
        System.out.println("Your fortune cookie says...\n\n"+fortunes[random]);
    }





}
