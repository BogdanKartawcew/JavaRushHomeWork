package com.javarush.test.level26.lesson08.task02;

/* Мудрый человек думает раз, прежде чем два раза сказать.
Все методы класса Solution должны быть потоково-безопасными.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными трэдами.
synchronized(this) для этого не подходит, используйте другой объект для лока.
*/
public class Solution
{
    int var1;
    int var2;
    int var3;
    int var4;


    public Solution(int var1, int var2, int var3, int var4, Integer lock, Integer lock2)
    {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;

        this.lock = lock;
        this.lock2 = lock2;
    }

    private final Integer lock;
    private final Integer lock2;

    public int getSumOfVar1AndVar2()
    {
        synchronized (lock)
        {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4()
    {
        synchronized (lock2)
        {
            return var3 + var4;
        }
    }
}
