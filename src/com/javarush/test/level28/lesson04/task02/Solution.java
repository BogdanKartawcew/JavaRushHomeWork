package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.

// !!!!!! для цього я використав current(). Якщо б не було нитей - то можна і без нього. ссилка -
https://docs.oracle.com/javase/tutorial/essential/concurrency/threadlocalrandom.html


Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {
    static ThreadLocalRandom generator;
    public static int getRandomIntegerBetweenNumbers(int from, int to)
    {
        return generator.current().nextInt(from, to);
    }

    public static double getRandomDouble()
    {
        return generator.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n)
    {
        return generator.current().nextLong(n);
    }
}
