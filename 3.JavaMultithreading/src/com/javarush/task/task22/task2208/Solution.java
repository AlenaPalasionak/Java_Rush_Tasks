package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("name", "Ivanov");
        paramsMap.put("country", "Ukraine");
        paramsMap.put("city", "Kiev");
        paramsMap.put("age", null);
// имеем мапу с 4 ячейками
        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();// строка для запроса
        for (String s : params.keySet()) {//пройдемся по ключам: name, country, city, age
            String value = params.get(s);//получаем значение по ключу
            if (value == null) {// если значение нул - продолжаем
                continue;
            }
            if (queryBuilder.toString().length() != 0) {//если длина строки запроса не равна 0
                queryBuilder.append(" and "); //билдим энд
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }
}
//name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'