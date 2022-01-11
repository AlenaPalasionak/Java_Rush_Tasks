package com.javarush.task.task21.task2106;
import java.util.Date;
/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//+•	проверить, что мы не сравниваем объект сам с собой
        if (!(o instanceof Solution)) return false;//+ •	проверку, чтобы не сравнивали разные классы
        if(o == null) return  false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;//compare(double d1, double d2)
        //Compares the two specified double values. Используя обертку сравниваем
        //Returns:
        //the value 0 if d1 is numerically equal to d2; a value less than 0 if d1 is numerically less than d2;
        // and a value greater than 0 if d1 is numerically greater than d2.

        // Дальше мы пишем условия при которых объекты НЕРАВНЫ, т.к в конце if - false
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;//
        // дата не равна нул? - тогда не соответствует второй дате, если равна нул то равна нул.
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));//^ - это | битовый опреатор "или", в случае
        // проверки двух одинаковых битов возвратит 0,если же они одинаковые,то 1
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
