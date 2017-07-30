package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int min = inputStream.read();
        while (0<inputStream.available()){
            int x = inputStream.read();
            if(x<min)

            { min = x; }    // ми прочитали перший байт відповідно у нас він є найменший. тоді порівнюємо його з кожним наступним.
            // відповідно, якщо якийсь буде менший, то він стає найменшим і порівнюватимемо наступні байти вже з ним.

        }
        inputStream.close();
        System.out.println(min);
    }
}

//C:\Users\MyWORID\Desktop\1234.txt