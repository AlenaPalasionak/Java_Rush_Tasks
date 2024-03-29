package com.javarush.task.task25.task2504;
/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {//произвольное число аргументов указанного типа
       for(Thread thread : threads ){

           switch (thread.getState()) {// будем свитчить состояние и делать действия
               case NEW:
                   thread.start();
                   break;
               case WAITING:
               case TIMED_WAITING:
               case BLOCKED:
                   thread.interrupt();
                   break;
               case RUNNABLE:
                   thread.isInterrupted();
                   break;
               case TERMINATED:
                   System.out.println(thread.getPriority());
       }
        }
    }

    public static void main(String[] args) {
    }
}
