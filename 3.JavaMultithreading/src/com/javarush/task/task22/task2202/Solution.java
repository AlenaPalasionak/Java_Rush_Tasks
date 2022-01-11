package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int spaceCounter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (string==null){
            throw new TooShortStringException();
        }
        char array [] = string.toCharArray();// символы в массиве
        for(int i = 0; i<array.length;i++){
            if(array[i] == 32) {
                spaceCounter++;
            }

            if (spaceCounter >= 1 && spaceCounter < 5) {
                stringBuilder.append(array[i]);
            }
        }
        if(spaceCounter<4){
            throw  new TooShortStringException();
        }
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends  RuntimeException{
    }
}
//Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
//которое следует после 4-го пробела.