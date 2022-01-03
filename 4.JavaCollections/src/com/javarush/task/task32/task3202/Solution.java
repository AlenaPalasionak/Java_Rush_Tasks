package com.javarush.task.task32.task3202;

import java.io.*;
/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\User1\\Desktop\\fileName.txt"));//мы передаем стринграйтеру
        // файловый поток для чтения
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if(is!=null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));//чтец из потока
            while (is.available() > 0) {
                stringWriter.write(br.readLine());
            }
        }
        return stringWriter;
    }
}
