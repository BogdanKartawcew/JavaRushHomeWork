package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

import java.util.Collection;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public int min(int a, int b) {if (a<b)
        return a;
    else
        return b;}
    public long min (long a, long b) {if (a<b)
        return a;
    else
        return b;}
    public double min (double a, double b) {
        if (a<b)
            return a;
        else
            return b;
    }
}
