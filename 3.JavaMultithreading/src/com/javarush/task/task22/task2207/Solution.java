package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();// создаи связной список для слов
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));//
            // 1.читаем строку
            //2. делим на местах пробела на слова
            //3.массив этих слов превращаем в список
            //4.добавляем список в список words
            // ТЕПЕРЬ в words -список всех слов из файла
        }
        fileReader.close();

        for (int i = 0; i < words.size(); i++) {//переменная i
            for (int j = 0; j < words.size(); ) {//переменная j не имплементируем ее
                if (i >= words.size()) {// если i станет больше или равно разера списка слов
                    break;
                }
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                 //будем сравнивать одно слово из words со всеми совами из words, а именно с:
                    //StringBuilder(String str) -Создает стрингбилдер, инициализированный содержимым указанной строки, т.е:
                    //1. стрингбилдер здесь - строка, перевернутая реверсом одного из слов из массива всех слов из файла
                    //2. т.е., если слово из списка совпадает с реверсированным словом и при этом это н одно и тоже слово j != i(тут
                    // мы исключаем сравнивание самого слова с самим собой, ТО:
                    Pair pair = new Pair();// создаем объект класса пара
                    pair.first = words.get(j);// инициализируем переменные
                    pair.second = words.get(i);// инициализируем переменные
                    result.add(pair);//добавлем пару в  public static List<Pair> result = new LinkedList<>();
                    words.remove(j);//чтобы не сравнивать то что уже сравнили
                    words.remove(i);// удаляем пару, которая уже сраслась
                    j = 0; // обнуляем j, на нулевой позиции уже другое слово
                } else
                    j++;// а если пара не сложилась инкрементируем j и ищем пару для следющего слова в следующей ячейке
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

//C:\\Users\\User1\\Desktop\\Test1.txt