package com.javarush.task.task32.task3211;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
/* 
Целостность информации
*/
public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
//получать MD5 хеш из переданного ByteArrayOutputStream и сравнивать с эталонным MD5 переданным вторым параметром.
//Метод main не участвует в тестировании.
//строка переданная
        MessageDigest md = MessageDigest.getInstance("MD5");//объект для храниения дайджеста сообщений из параметров
        md.update(byteArrayOutputStream.toByteArray());//передаем данные в объект md
        byte[] digest = md.digest();// в массив его
        //Converting the byte array in to HexString format
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            stringBuilder.append(String.format("%02x",digest[i]));//то есть нужно взять масив байт и через
            // стринг формат добавлять по одному конвертируя их в 16 тиричную
            //если написать append(digest[i]) - будет  не тот формат
            System.out.println();
        }
        return stringBuilder.toString().equals(md5);
    }
}
