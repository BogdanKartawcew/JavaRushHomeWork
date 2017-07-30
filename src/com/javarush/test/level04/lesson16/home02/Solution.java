package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String A=r.readLine();
        String B=r.readLine();
        String C=r.readLine();
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);
        int x;
        int mid;

        if (a<=b)
            x=b;
        else
            x=a;
        if (x<=c)
            mid=x;
        else
            mid=c;


        System.out.println(mid);

    }
}
