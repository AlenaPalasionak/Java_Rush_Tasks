package com.javarush.task.task19.task1924;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* 
Замена чисел
*/
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {

            String fileLine;
            while((fileLine = fileReader.readLine()) != null){
                for(Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                    //                             граница слова+число+граница слова

                }
                System.out.println(fileLine);
            }
        }
        catch (IOException ignore) {
            /* NOP */
        }

    }
    }
//C:\\Users\\User1\\Desktop\\Test1.txt
//        int nextNumber = 0;
//String result = null;
//ArrayList <String> array = new ArrayList<>();
//        int counter = 0;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
//
//            while(fileReader.ready()){
//                     String readLineFromFile = fileReader.readLine();
//                     String [] splitDigitsAndWords = readLineFromFile.split(" ");// отдельные слова
//                result = readLineFromFile;
//                     for(int i = 0; i<splitDigitsAndWords.length; i++){//делаем пока в первой строчке не заменим все числа
//                        try {
//
//                            int digit = Integer.parseInt(splitDigitsAndWords[i]);//если получаем число идем дальше
//                            if(digit<=map.size()) {
//                                String one = String.valueOf(digit) + " ";
//                                result = readLineFromFile.replace(one, map.get(digit) + " ");
//                            }
//                            if (array.isEmpty()) {
//                                //result = readLineFromFile.replace(one, map.get(digit) + " ");
//                                array.add(result);//попробуем добавить в динамМассив
//                            }
//                                 //                   получаем 1            получаем слово "один"
//                            else if(array.size()==(counter+1)){//если уже что-то появилось
//
//                                result = (array.get(counter)).replaceAll(String.valueOf(digit), map.get(digit) + " ");
//                                counter++;
//                            }
//                        }
//
//                     catch (NumberFormatException IO){
//                            //Ignore
//                     }
//                     }
//                System.out.println(result);
//                     result = null;
//                 }
//        }
//        catch (IOException e){
//
//        }
//    }
//    }
