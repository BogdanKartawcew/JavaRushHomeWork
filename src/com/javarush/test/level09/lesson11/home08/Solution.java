package com.javarush.test.level09.lesson11.home08;


/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {ArrayList<int[]> list = new ArrayList<int[]>();
    int[] array1 = {5, 5, 5, 5, 5};
    int[] array2 = {2, 2};
    int[] array3 = {4, 4, 4, 4};
    int[] array4 = {7, 7, 7, 7, 7, 7, 7};
    int[] array5 = {};
        list.add(array1);
        list.add(array2);
        list.add(array3);
        list.add(array4);
        list.add(array5);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
