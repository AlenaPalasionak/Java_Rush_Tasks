package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;// 0
        int b = (byte) a + 46;//0+46в интах-> перевод в byte
        byte c = (byte) (a * b);
        double f = (char) 1234.15;//
        long d = (int) (a + f / c + b);//деление на ноль вещественного f дает infinity
        //при приведении infinity(бесконечность) к байт или шорт получаем -1(лекция типизация)
        System.out.println(d);
    }
}//d > 0.
//Для преобразования больших чисел из doble  (больше чем 2^64)  в byte например, сначала происходит преобразование
// в int - при этом значение устанавливается в Integrer.MAX =2147483647.
//И уже после преобразуется в byte путем отбрасывания не помещающихся разрядов.
//Число Integrer.MAX = 2147483647