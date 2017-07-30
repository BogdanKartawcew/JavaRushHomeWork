package com.javarush.test.level34.lesson02.task01;

/* Числа Фибоначчи с помощью рекурсии
Почитать про числа Фибоначчи.
Реализовать логику метода fibonacci, где n - это номер элемента в последовательности Фибоначчи.
Не создавайте статические переменные и поля класса.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        //System.out.println("result = " + solution.fibonacci(0));     //0
        System.out.println("result = " + solution.fibonacci(9));     //34
        //System.out.println("result = " + solution.fibonacci(5));     //5
        //System.out.println("result = " + solution.fibonacci(2));     //1
        //System.out.println("result = " + solution.fibonacci(1));     //1
    }

    public int fibonacci(int n)
    {
        /*if(n==0) return 0;
        else
        {
            int i1 = 0;
            int i2 = 1;
            int result = 1;
            for (int i = 1; i < n; i++)
            {
                result = i1+i2;
                i1 = i2;
                i2 = result;
            }
            return result;
        }*/ //все окі, але це без рекурсії

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            //System.out.println(fibonacci(n - 1) + fibonacci(n - 2));
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        /*але вапшєто це надто заплутано. це не найкразий варіант - використовувати тут рекурсію. мій варіант значно логічніший і прозоріший. та і швидший певно*/
    }
}
