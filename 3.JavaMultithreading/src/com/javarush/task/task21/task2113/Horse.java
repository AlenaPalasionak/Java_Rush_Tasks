package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void move(){
     distance +=  speed * Math.random();
// В методе move класса Horse значение поля distance должно увеличиваться на расстояние пройденное за один
// "ход"(значение поля speed) умноженное на случайное число от нуля до единицы полученное с помощью вызова метод Math.random().
    }
    public  void print(){
        int countOfDots = (int) distance;
        for(int i = 0; i<countOfDots; i++){
            System.out.print(".");
        }
        System.out.println(getName());
//1. Метод print должен выводить на экран строку состоящую из точек и имени лошади. Количество точек равно целой части distance.
    }
}
