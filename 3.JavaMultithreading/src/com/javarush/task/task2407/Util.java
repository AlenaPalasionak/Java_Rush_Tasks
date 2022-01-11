package com.javarush.task.task24.task2407;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }//берем зверушку с индексом
    }

    public static List<Pet> getPets() {// класс кот и класс мышь дочерние классы родителя Pet
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());//и кот и мышь с помощью полиморфизма укладываются в список с типом Pet(полиморфизм)
        pets.add(new Cat("Томас"));
        return pets;
    }
// этот метод конвертит типы списков
    public static List<Sayable> convertPetToSayable(List<Pet> pets) {//приняли лист с котами и мышью в параметры, будем конвертировать в список с параметрами другого типа Sayble
        List<Sayable> result = new LinkedList<>();//создадим новый список с типом Sayble
        for (Pet pet : pets) {// пройдем по принятому списку животных
            int i = (int) (Math.random() * 7) - 2;// зададим рандомно i
            result.add(pet.toSayable(i));//в новый связной список типа Sayable добавим (сходим в Cat за реализацией toSayable - он возвр. CatPet
        }//pet - это животное в списке с типом Pet(коты и мышь)
        return result;//
    }
}
