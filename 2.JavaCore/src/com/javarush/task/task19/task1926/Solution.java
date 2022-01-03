package com.javarush.task.task19.task1926;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
Перевертыши
*/
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){
            while(fileReader.ready()) {
                String readString = fileReader.readLine();
                char[] chars = readString.toCharArray();

                    for(int i = 0; i<chars.length;i++){
                        System.out.print(chars[chars.length -1- i]);

                    }
                System.out.print("\n");
            }
        }
        catch (IOException e){
        }
    }
}
//  C:\\Users\\User1\\Desktop\\Test1.txt