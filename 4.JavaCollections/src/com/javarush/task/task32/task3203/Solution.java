package com.javarush.task.task32.task3203;
import java.io.PrintWriter;
import java.io.StringWriter;
/* 
Пишем стек-трейс
*/

public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);// принтер печатает в stringWriter

        throwable.printStackTrace(printWriter);//записали в объект printWriter стэк исключений

        return stringWriter.toString();
    }
    // StringWriter writer = new StringWriter();
    //        throwable.printStackTrace(new PrintWriter(writer));
    //        return writer.toString();
}

//printStackTrace(PrintWriter s) - Prints this throwable and its backtrace to the specified print writer.

//++2. В методе getStackTrace необходимо создать объект типа StringWriter.
//3. В методе getStackTrace (Throwable) необходимо использовать метод класса Throwable, который принимает объект типа PrintWriter.
//4. Метод getStackTrace (Throwable) должен возвращать весь стек-трейс переданного исключения.