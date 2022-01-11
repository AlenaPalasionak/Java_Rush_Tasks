package com.javarush.task.task25.task2511;
import java.util.TimerTask;
/*
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            String result = "";

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                result = t.getName().replaceAll(".","\\*");
                System.out.println(e.getMessage().replace(t.getName(), result));

            }
        };
//the name of the class of this object
//": " (a colon and a space)
//the result of invoking this object's getLocalizedMessage method

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1/0);
            }
        });
        Thread thread = new Thread(solution);
        thread.start();
    }
}
