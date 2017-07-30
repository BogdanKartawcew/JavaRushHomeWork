package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/

import java.util.Vector;

public class Solution {
    public static void main (String [] args){

        long a=System.currentTimeMillis();
        int[] y = getNumbers(Integer.MAX_VALUE);
        long b=System.currentTimeMillis();
        System.out.println("time seconds "+(b-a)/1000);
        System.out.println("memory "+(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory())/1024/1024 + " mb");
        for(int i : y){
            System.out.println(i);
        }
    }

    public static int[] getNumbers(int N) {
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i < N; i++) {
            if (checkFormula(i)) v.add(i);
        }
        int[] result = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
        }
        return result;
    }

    public static boolean checkFormula(int number) {
        if (number == 0) return false;
        else if (number >= 1 && number < 10) return true;
        int     result = number, sum = 0, czyslo = 0,
                digitCount = 1 + (int) Math.log10(number);
        for (int i = 0; i < digitCount; i++) {
            czyslo = result % 10;
            result = result / 10;
            int prod = czyslo;
            for (int j = 1; j < digitCount; j++) {
                prod *= czyslo;
            }
            sum += prod;
        }
        if (sum == number)
            return true;
        else
            return false;
    }
}
