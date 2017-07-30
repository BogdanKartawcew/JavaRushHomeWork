package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1name = reader.readLine();
        String file2name = reader.readLine();
        FileInputStream File1read = new FileInputStream(file1name);
        FileInputStream File2read = new FileInputStream(file2name);
        reader.close();
        ArrayList<Character> list = new ArrayList<>();
        while (File2read.available() >0)
        {
            int data = File2read.read();
            list.add((char)data);
        }
        while (File1read.available() >0)
        {
            int data = File1read.read();
            list.add((char)data);
        }


        File1read.close();
        File2read.close();


        FileWriter writer = new FileWriter(file1name);
        for(Character str: list) {
            writer.write(str);
        }
        writer.close();
    }
}

/*
C:\Users\MyWORID\Desktop\123456.txt
C:\Users\MyWORID\Desktop\789.txt
*/
