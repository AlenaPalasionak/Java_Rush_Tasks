package com.javarush.task.task25.task2506;
/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();//создали нить
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);//передаем нить за которой будем следить

        loggingStateThread.start(); //NEW
        Thread.sleep(100);//
        target.start();  //RUNNABLE
        Thread.sleep(100);//
        //TERMINATED
    }
}
