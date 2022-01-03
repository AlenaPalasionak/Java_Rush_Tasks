package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);// позиция в файле
            long length = raf.length();// длина файла
            number = number > length ? length : number;// если позиция в файле больше длины файла, то записывть будем с конца файла, иначе с данной позиции
            raf.seek(number);
            raf.write(args[2].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//C:\\Users\\User1\\Desktop\\fileName.txt 0 This is the text for the task in Java Collection second level
//0
//This is the text for the task in Java Collection second level