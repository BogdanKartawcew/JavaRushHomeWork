package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
int[] list = new int[10];
        for (int i = 0; i<list.length; i++) {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
        }
                for (int i = list.length - 1; i >= 0; i--)
                    System.out.println(list[i]);


        //напишите тут ваш код
    }
}
