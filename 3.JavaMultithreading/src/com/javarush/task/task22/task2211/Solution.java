package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //получается, что InputStreamReader имеет конструктор с 2мя парамерами:   java.io.InputStream in,        String charsetName)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             //из чаров строки                          из байтов чары            байты
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            while (reader.ready()) {
                writer.write(reader.readLine());
            }


        }
    }
}
//в который необходимо записать содержимое первого файла в кодировке UTF-8.