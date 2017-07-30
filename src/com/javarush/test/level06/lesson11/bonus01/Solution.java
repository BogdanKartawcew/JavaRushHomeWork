package com.javarush.test.level06.lesson11.bonus01;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их максимум в виде «Max is 25»
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        String B = reader.readLine();
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        String max = "Max is ";
int max1 = max(a, b);
        System.out.println(max + max1);
    }

public static int max(int a, int b) {return a>b ? a:b; }
}
