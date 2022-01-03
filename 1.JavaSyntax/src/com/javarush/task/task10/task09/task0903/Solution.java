package com.javarush.task.task09.task0903;
/* 
Кто меня вызывал?
*/
public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        method2();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method2() {
        method3();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method3() {
        method4();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method4() {//[2]
        method5();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method5() {//[1]
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();//[0]
return stackTraceElement[2].getLineNumber();

    }
}
