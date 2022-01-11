package com.javarush.task.task22.task2210;
import java.util.StringTokenizer;
/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String str[] = new String[tokenizer.countTokens()];
        int i = 0;
        while(tokenizer.hasMoreTokens()){
                str[i] = tokenizer.nextToken();
                i++;
            }
        return str;
    }
}
