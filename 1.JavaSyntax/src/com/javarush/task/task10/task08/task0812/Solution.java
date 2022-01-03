package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/* 
Cамая длинная последовательность
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String string = reader.readLine();
            list.add(Integer.parseInt(string));
        }

        int count = 1;// сюда мы будем сохранять максимальное колво повторений
        int max = 1;// это значение будем возвращать чтобы использовать переменную
        for (int i = 0; i < 9; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                max++;
            } else if (max > count) {
                count = max;
                max = 1;
            } else {
                max = 1;
            }
        }

        if (max > count) {
            count = max;
        }

        System.out.println(count);
    }
}
