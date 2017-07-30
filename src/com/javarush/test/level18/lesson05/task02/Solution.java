package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = new FileInputStream(reader.readLine());
        reader.close();


        long sum = 0;
        while (in.available() > 0)
        {
            int data = in.read();
            if ((char) data == 44)
            {sum++;}
        }
        in.close();
        System.out.println(sum);
    }
}
// C:\Users\MyWORID\Desktop\5678.txt   виводитись має число 3.
// Подсказка: нужно сравнивать с ascii-кодом символа ','. https://pl.wikipedia.org/wiki/ASCII