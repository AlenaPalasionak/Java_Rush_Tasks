package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws InterruptedException {
        return factorial(number);

    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        else if (number == 0||number== 1){
            return 1;
        }
        return number*factorial(number-1);
    }
}
