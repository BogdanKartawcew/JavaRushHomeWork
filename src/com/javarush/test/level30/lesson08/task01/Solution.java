package com.javarush.test.level30.lesson08.task01;

/* Найдем число 2 в максимальной степени
Реализуйте логику метода maxPowerOf2,
который должен возвращать число 2 в максимальной степени, которое получается поместить в переданное число
Аргументом maxPowerOf2 может быть только положительное число
Используйте только операции: 1)побитовые сдвиги, 2) присваивание, 3) побитовое ИЛИ
Не оставляйте комментарии
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        /*int result = 2;
        while(result*2 < x)
        {
            result*=2;
        }
        return result;*/ // мій робочий варіант - не пройшов

        /*x = x|x>>1;
        x = x|x>>2;
        x = x|x>>4;
        return Math.round(x/2);*/

        /*int t = 1 << 30;
        while (x < t) t >>= 1;
        return t;*/

        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x - (x >> 1);

    }
}
