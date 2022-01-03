package com.javarush.task.task13.task1318;
import java.io.*;
import java.util.Scanner;
/* 
Чтение файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream fileInputStream =  new FileInputStream(name);
while(fileInputStream.available()>0)
            System.out.print(fileInputStream.read());
        fileInputStream.close();
reader.close();




    }
}