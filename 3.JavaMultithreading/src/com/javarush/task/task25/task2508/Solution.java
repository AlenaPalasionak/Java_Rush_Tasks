package com.javarush.task.task25.task2508;

/* 
Не валять дурака
*/

public class Solution {
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {// нить main
        CustomThreadManipulator manipulator = new TaskManipulator();// чтобы запустить этот объект нужно создать Thread, т.к. он не является нитью(не унаследован
        //от класса Thread, а только реализует Runnable

        manipulator.start("first");//тут мы вызываем обычный метод объета( а вот внутри действительно стартуем нить с именем "first", но поскольку
        //manipulator не является нитью, в параметрах конструктора Thread
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
         manipulator.stop();
    }
}
