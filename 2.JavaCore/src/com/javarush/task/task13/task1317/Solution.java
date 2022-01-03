package com.javarush.task.task13.task1317;

/* 
The weather is fine
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));//новый объект с параметром
        //(String type) -
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FREEZING));
    }
    //КЛАСС
    static class Today implements Weather{
        private String type;
        //конструктор
        Today(String type) {
            this.type = type;
        }
        public String getWeatherType(){
            return type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());//значение константы интерфейса WeatherType
        }
    }
}

