package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream password = new ByteArrayOutputStream();
        try{
            password.toString().matches(".*(A-Z).*")
        }
        catch (Exception e){

        }

        return password;
    }
}
