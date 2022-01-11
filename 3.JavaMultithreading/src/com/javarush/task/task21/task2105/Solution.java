package com.javarush.task.task21.task2105;
import java.util.HashSet;
import java.util.Set;
/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == null || getClass()!= o.getClass()) return  false;// не равен ли нулю объект, проверка не сравниваем ли мы разные классы, прервется тут и вернется фолс,
//если один класс не равен другому  то false.

        if (this == o) return true;//если объект на котором вызываем метод иквэлс равен тому, который пишем в параметры - то мы
//сравниваем один и тот же объект, поэтому и остановится на тру, дальше тратить время на проверку не стоит

        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;
        return n.first == first && n.last == last;
    }
public int hashCode(){
        int result = 17;
        result = result * 31 * ( first!= null ? first.hashCode() : 0);
        result = result * 31 * (last != null ? last.hashCode() : 0);
        return result;
}

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
