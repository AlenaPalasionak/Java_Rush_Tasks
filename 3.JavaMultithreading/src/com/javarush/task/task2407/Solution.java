package com.javarush.task.task24.task2407;
import java.util.List;
/* 
Реализация интерфейса используя локальный класс
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();// заполнили объетами типа
        List<Sayable> pets = Util.convertPetToSayable(pet);// конвертировали тип листа
        Util.printDialog(pets);
    }
}
