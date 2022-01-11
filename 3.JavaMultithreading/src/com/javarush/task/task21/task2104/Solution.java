package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {//

        if(!(o instanceof Solution)) return  false;//является ли переданный объект объектом класса Solution
        if(this == o) return true;//равен ли переданный объект текущему(сравнение через ==).

        //нужно сузить обджект до солюшена
            Solution n = (Solution) o;// Solution n равняется объекту о (суженному до типа солюшена)

        if(first != null ? !first.equals(n.first) : n.first != null) return  false;// два поля должны быть одинаковыми, чтобы было тру
        if(last !=null ? !last.equals(n.last) : n.last != null) return  false;
         return true;
    }

    public int hashCode() {
        int result = 17;
        result = result* 31 +(first != null ? first.hashCode() : 0);// если ферст не равно нул, то можно присваивать нормальный
        //хэшкод, если нул, то хэшкод будет 0
        result = result* 31 + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));// получается, когда мы пытаемся добавить новый элемент в сет, сначала идет проверка
        // по хэшкоду потом по иквэлс если требуется, и если такого элемента нет, то добавится

        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
