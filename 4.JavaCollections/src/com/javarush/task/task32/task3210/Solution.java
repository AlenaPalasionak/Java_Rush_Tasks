package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
try(RandomAccessFile raf= new RandomAccessFile(args[0], "rw")){
    int number = Integer.parseInt(args[1]);// позиция намбэ
    long length = raf.length();//длина файла
    raf.seek(number);
    byte [] b = new byte[args[2].length()];
    raf.read(b,0, args[2].length());

    String bString = new String(b);
    raf.seek(length);
    if (bString.equals(args[2])){
        raf.write("true".getBytes(StandardCharsets.UTF_8));
    }
    else {
        raf.write("false".getBytes(StandardCharsets.UTF_8));
    }

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
    }
}//Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
   // Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
     //   Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
     //   Используй один из конструкторов класса String для конвертации считанной строчки в текст.
//C:\\Users\\User1\\Desktop\\fileName.txt 0 This is the text for the task in Java Collection second level