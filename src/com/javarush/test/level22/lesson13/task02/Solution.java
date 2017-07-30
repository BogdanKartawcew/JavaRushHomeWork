package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset UTF8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        //String filename1 = "C:\\Users\\MyWORID\\Desktop\\1.txt";
        //String filename2 = "C:\\Users\\MyWORID\\Desktop\\2.txt";
        FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(args[1]);

        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        String s = new String(buffer, UTF8);
        System.out.println(s);
        buffer = s.getBytes(windows1251);
        output.write(buffer);
        input.close();
        output.close();
    }
}
