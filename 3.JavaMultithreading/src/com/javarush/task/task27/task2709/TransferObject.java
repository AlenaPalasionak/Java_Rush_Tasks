package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {// не буде получать если нет
            try {
                wait();// спит, когда нет, а если есть идет ниже
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
        System.out.println("Got: " + value);
        isValuePresent = false;// сбрасываем, чтобы работало дальше
        notify();//будим поток, который не ждет гогда пусто
        return value;
    }


    public synchronized void put(int value) {
        while(isValuePresent) {//если есть не будем класть
            try {
                wait();//спит, когда есть
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();// будим нить, она проснется и сможет зайти в поток, который не спит(по условию есть +)
       
    }
}
