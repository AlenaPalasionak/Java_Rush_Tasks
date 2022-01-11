package com.javarush.task.task24.task2404;

/* 
Рефакторинг Rectangle
*/

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
       //System.out.println(getHeight(rectangle));//тут rectangle работает по полиморфизму в первом варианте кода(когда ректангл
//реализовывал интерфейсы.Без реализации ректангл перестал проходить, т.к. он больше не момжет быть объектом типа HasHeight
        //System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));// тут метод rectangle.castToHasHeight() - возвращает объект типа
//HasHeight
       System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {//если у нас ректангл унасследован от интерфейса HasHeight, мы можем
//создать объект HasHeight rectangle - полиморфизм
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }

    public static class Rectangle {//наследование нам теперь не надо, т.к. логика перенесена в метод в анонимный класс
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public HasHeight castToHasHeight() {
            HasHeight hasHeight = new HasHeight() {//Создается безымянный Java-класс, реализующий интерфейс  HasHeight
                public double getHeight() {//имплементируем этот метод, т.к. создали анонимный класс, а он должен имплементить его меоды
                    return Math.abs(point1.getY() - point2.getY());// Math.abs(2-4) = 2 высота 2
                }
            };
            return hasHeight;
        }

        public  HasWidth  castToHasWidth() {
            HasWidth hasWidth = new HasWidth() { //Создается безымянный Java-класс, реализующий интерфейс  HasHeight
                @Override
                public double getWidth() { //имплементируем этот метод, т.к. создали анонимный класс, а он является наследником
//интерфейса  значит должен имплементить его методы
                    return Math.abs(point1.getX() - point2.getX());//Math.abs(1-3) = 2
                }
            };
            return hasWidth;
        }
    }
}
