package com.javarush.task.task10.task1009;

/* 
Правильный ответ: d = 5.5
*/

public class Solution {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        int c = 3;
        int e = 2;
        double d = a + b / c /(double) e;//5+0,66666666667
        System.out.println(d);
    }
}
