package com.javarush.task.task22.task2203;
/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) {
            throw new TooShortStringException();
        }
        char array [] = string.toCharArray();
        int counter = 0;
        for(int i = 0; i<array.length;i++){
            if(array[i] == 9){
                counter++;
            }
        }
        if(counter<2){
            throw  new TooShortStringException();
        }
        int indexOfTab1 = string.indexOf("\t");// получаем индекс первой табуляции
        int indexOfTab2 = string.indexOf("\t", indexOfTab1+1);// получаем индекс второй табуляции
        String s = string.substring(indexOfTab1+1, indexOfTab2);// находим подстроку от места после табуляции ДО до таб
        return s;
        //("JavaRush - \tлучший сервис \tобучения Java\t."
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
//В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
//4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.