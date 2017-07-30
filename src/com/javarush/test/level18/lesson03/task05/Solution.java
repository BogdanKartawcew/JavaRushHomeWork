package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        TreeSet<Integer> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = new FileInputStream(reader.readLine());
        reader.close();
        while (in.available() > 0)
        {
            int data = in.read();
            set.add(data);
        }

        in.close();
        for (Integer str : set){
            System.out.print(str+" ");
        }
    }
}

//C:\Users\MyWORID\Desktop\1234.txt

//[70, 77, 212, 193, 192, 219, 49, 50, 51, 51, 52, 50, 51, 52, 50]
