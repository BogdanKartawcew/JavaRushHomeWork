package com.javarush.test.level34.lesson02.task02;

/* Факториал с помощью рекурсии
Почитать про вычисление факториала.
Реализовать логику метода factorial, где n - это число, факториал которого нужно вычислить.
Не создавайте статические переменные и поля класса.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n)
    {
       /* int result = 1;
        for (int i = 1; i<=n; i++)
        {
            result *=i;
        }
        return result;*/ //елементарно, але не проходить, бо тут нема рекурсії

        if (n == 1 || n == 0) return 1;
        else
        {
            return n * factorial(n - 1);
        }
    }
}
