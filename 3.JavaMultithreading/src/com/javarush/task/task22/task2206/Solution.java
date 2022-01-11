package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Bender";
        StringBuilder s2 = new StringBuilder(s);
        s2.replace(3, 5, "_DE_");
        System.out.println(s2);
    }//012345
     //Bender
}