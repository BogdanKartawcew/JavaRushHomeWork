package com.javarush.test.level05.lesson12.bonus03;



/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int j = Integer.parseInt(reader.readLine());

        int maximum = Integer.MIN_VALUE;

            for(int i=0;i<j;i++)
            {
                int a = Integer.parseInt(reader.readLine());
                if (a >= maximum) maximum=a;
            }

        System.out.println(maximum);
    }
}


