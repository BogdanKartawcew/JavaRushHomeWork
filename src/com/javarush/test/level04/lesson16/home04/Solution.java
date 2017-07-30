package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String Y = reader.readLine();
        String M = reader.readLine();
        String D = reader.readLine();
        int y = Integer.parseInt(Y);
        int m = Integer.parseInt(M);
        int d = Integer.parseInt(D);
        System.out.println("Меня зовут "+name);
        System.out.print("Я родился "+d+"."+m+"."+y);

    }
}
