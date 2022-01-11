package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{// следит за состоянием нити
    Thread thread;//

    public LoggingStateThread(Thread thread){//
        this.thread = thread;//
    }

    @Override
    public void run() {
        State currentState = thread.getState();//Сохранить в переменную текущее состояние:
        System.out.println(currentState);// выводим начальное состояние

        State nextState;//
        do {//будем выводить состояние, только если оно отличается от currentState
            if((nextState = thread.getState()) != currentState) {//Получить значение текущего состояния и записать в переменную еще раз
                currentState = nextState;//и записать в переменную еще раз, для того чтобы обновить новым состоянием, ведь мы пво второй раз должны
                //сравнивать не с первоначальным new, а со следующим состоянием

                System.out.println(currentState);//
            }
        }
        while (!nextState.equals(State.TERMINATED));//
    }
}
