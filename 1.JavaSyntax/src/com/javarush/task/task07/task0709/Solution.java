package com.javarush.task.task07.task0709;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 
Выражаемся покороче
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minStringLength = Integer.MAX_VALUE;
        String min = null;

        for(int i = 0; i<5;i++) {
            strings.add(reader.readLine());

            if(strings.get(i).length()<minStringLength){
                minStringLength = strings.get(i).length();
                min = strings.get(i);
            }
        }
        System.out.println(min);

        for(String str : strings){
            if(str.length() == min.length()&& !(str.equals(min))){
                System.out.println(str);
            }
        }
    }
}
