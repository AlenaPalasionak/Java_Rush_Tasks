package com.javarush.task.task19.task1909;
import java.io.*;
import java.util.ArrayList;
/* 
Замена знаков
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
       StringBuilder stringBuilder = new StringBuilder();
       FileReader fileReader = new FileReader(fileName1);
       FileWriter fileWriter = new FileWriter(fileName2);
           while(fileReader.ready()) {
             stringBuilder.append((char)fileReader.read());// сделали строку

           }
        String string = stringBuilder.toString();
           String  endString = string.replaceAll("!", ".");
           fileWriter.write(endString);
           fileReader.close();
           fileWriter.close();
       }
    }

/*C:\\Users\\ALEX\\Desktop\\Test.txt
C:\\Users\\ALEX\\Desktop\\Test2.txt*/
