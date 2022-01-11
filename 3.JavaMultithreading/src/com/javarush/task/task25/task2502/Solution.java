package com.javarush.task.task25.task2502;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();
            if(loadWheelNamesFromDB().length < 4||loadWheelNamesFromDB().length > 4 ||loadWheelNamesFromDB() == null) {
                throw new Exception();
            }
                String str[] = loadWheelNamesFromDB();//теперь тут данные для инициализации

                for (int i = 0; i < str.length; i++) {
                    Wheel wheel = Wheel.valueOf(str[i]);
                    wheels.add(wheel);

            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
