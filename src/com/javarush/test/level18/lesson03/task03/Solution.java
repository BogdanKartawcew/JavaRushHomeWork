package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int[] massyv = new int[256];
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            massyv[data]++;
        }
        inputStream.close();
        int max = massyv[0];
        int ourbyte = 0;
        for (int i = 1; i < massyv.length; i++){
            if(massyv[i] > max) {
                max = massyv[i];
                ourbyte = i;
            }
        }
        System.out.print(ourbyte + " ");
    }
}
//     C:\Users\MyWORID\Desktop\1234.txt
// massyv[massyv.length-1]
//Arrays.sort(massyv);