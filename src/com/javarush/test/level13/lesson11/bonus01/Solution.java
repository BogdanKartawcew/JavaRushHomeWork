package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        Scanner inStream = new Scanner(new File(filename));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inStream.hasNext()){
            if(inStream.hasNextInt())
                list.add(inStream.nextInt());
            else
                inStream.next();
        }

       // погане. підходять для іншого. :
        /*InputStream inStream = new FileInputStream(filename);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inStream.available()>0)
        {
            list.add(inStream.read());
        }*/
       /* for (Integer str: list)
        {
            if(str%2!=0) list.remove(list.indexOf(str));
        }*/
        ArrayList<Integer> even = new ArrayList<Integer>();
       for (int i = 0; i < list.size(); i++)
        {
            Integer x = list.get(i);
            if (x % 2 == 0)
                even.add(x);}

        Collections.sort(even);

        for (int i = 0; i < even.size(); i++)
        {
            System.out.println(even.get(i));
        }
        inStream.close();
    }
}

// E:\Trip\Sponsors\sponsors.txt