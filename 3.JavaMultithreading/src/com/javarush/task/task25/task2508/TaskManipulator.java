package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator{//Класс TaskManipulator является одновременно и способом создания потока,
    // и способом манипулирования потоками.
    Thread t;
    @Override
    public void run() {// реализация метода интерфейса
        try {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
        }
    }
// Реализация методов interface CustomThreadManipulator
    @Override//4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем, которое передано через аргумент метода.
    public void start(String threadName) {
       t = new Thread(threadName);// благодаря this мы запускаем нить(run) объекта new TaskManipulator()
       t.start();//вот здесь запускаем run объекта new TaskManipulator()
    }

    @Override//5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
    public void stop() {
        t.interrupt();

    }
}
