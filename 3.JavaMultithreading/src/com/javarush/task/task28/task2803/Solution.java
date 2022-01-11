package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {//с помощью ThreadLocalRandom должен возвращать случайный int [from..to].
       int randomInt = ThreadLocalRandom.current().nextInt(from,to);
        return randomInt;
    }

    public static double getRandomDouble() {//с помощью ThreadLocalRandom должен возвращать случайный double [0..1).
        double randomDouble = ThreadLocalRandom.current().nextDouble();
        return randomDouble;
    }

    public static long getRandomLongBetween0AndN(long n) {//с помощью ThreadLocalRandom должен возвращать случайный long [0..n].
        long randomLong = ThreadLocalRandom.current().nextLong(n);
        return randomLong;
    }

    public static void main(String[] args) {
    }
}
