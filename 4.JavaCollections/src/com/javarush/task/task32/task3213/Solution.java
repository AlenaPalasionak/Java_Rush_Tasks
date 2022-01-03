package com.javarush.task.task32.task3213;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");// строка которая передается в параметрах предназначена
        //для чтения в дальнейшем
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter =  new StringWriter();// мы создали стринграйтер
int ch;
if (reader!=null) {
    BufferedReader br = new BufferedReader(reader);
    while ((ch = br.read()) != -1) {
        stringWriter.write(ch +key);
    }
}
        //строка есть теперь нужно ее раскодировать, каждый символ
        return stringWriter.toString();
    }
}
//Реализуй логику метода String decode(StringReader reader, int key).
//Метод получает данные в закодированном виде.
//Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
//Возвращаемый объект ни при каких условиях не должен быть null.
//Метод main не участвует в тестировании.

//2. Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
//3. Возвращаемый объект ни при каких условиях не должен быть null.