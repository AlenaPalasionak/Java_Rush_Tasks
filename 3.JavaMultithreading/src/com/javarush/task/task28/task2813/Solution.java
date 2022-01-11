package com.javarush.task.task28.task2813;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* 
FutureTask
*/
public class Solution {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);// экзекьютер с 4 нитями
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);// объект факториалПодсчета

        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);// передаем объект факториалПодсчта в пулПотоков, укладываем его в переменную
        System.out.println("The task was submitted successfully");

        while (!future.isDone()) {// пока мы не выполним эту задачу
            System.out.println("The task is not done yet....");
            Thread.sleep(1);// мэйн будет спать
        }

        System.out.println("The task is done. Let's check the result");//main проснется, когда выполнится таск и напишет
        long factorial = (long) future.get();//резултат

        System.out.println("Factorial of " + n + " is " + factorial);// выводит результат на экран
        threadpool.shutdown();
    }
}
