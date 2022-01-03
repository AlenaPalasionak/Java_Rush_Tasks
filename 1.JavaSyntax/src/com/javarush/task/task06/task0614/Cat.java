package com.javarush.task.task06.task0614;
import java.util.ArrayList;
/* 
Статические коты
*/
public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            cats.add(new Cat());
        }
        printCats();
    }

    public static void printCats() {
        for(Cat cat : cats){
            System.out.println(cat);
        }
    }
}
//2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
//3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.