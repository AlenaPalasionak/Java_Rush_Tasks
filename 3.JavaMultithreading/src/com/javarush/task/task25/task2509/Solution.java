package com.javarush.task.task25.task2509;
import java.util.concurrent.*;
/* 
Все не так легко, как кажется
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//1.number of threads,2.maximum number of threads to allow in, 3.when the number of threads is greater than the core,
// this is the maximum time that excess idle threads will wait for new tasks before terminating, 4.unit - единица времени для keepAliveTimeаргумента
//5.очередь для хранения задач перед их выполнением.
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }//КОНСТРУКТОР

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
//
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
