package com.javarush.task.task27.task2703;

/* 
Создаем deadlock
*/

public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
//1) Нить Alphonce заходит в метод bow() по мьютексу this (в данном случае это объект alphonce).
//2)Нить  Gaston заходит в метод bow() по мьютексу this (в данном случае это объект gaston).
//3) В итоге оба ключа/мьютекса заняты - alphonce и gaston.
//4) В методе bow() есть еще метод bowBack(), но он вызывается у другого объекта. Т.е. в нити Альфонса метод вызывается для объекта
// gaston, а у нити Гастона  - для объекта alphonce.
//5) Метод bowBack() тоже объявлен как synchronized, т.е. блокируется по this. Когда Альфонс в методе bow() уже поклонился, и далее
// в коде идет вызов метода bowBack() у объекта gaston, т.е. метод пытается использовать мьютекс gaston, то тут происходит ДЕДЛОК. Потому что мьютекс gaston уже занят (см. пункт 3).
//6) Аналогичная ситуация в нити Гастона.