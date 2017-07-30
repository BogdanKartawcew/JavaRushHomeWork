package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
    public static void main(String[] args)
    {
        Integer[] array = {3, 4, 7, -1, 5, 2, 1, -18, 11, 5, 48, 49, -23, 92, 94};
        System.out.println(Arrays.toString(sort(array)));

        /*LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++)
        {
            list.add(array[i]);
        }
        Collections.sort(list);
        List<Integer> linked = new ArrayList<Integer>(list);
        int index = 0;
        double mediana = 0;
        if (array.length % 2 == 1) //непарні
        {
            index = (linked.size() + 1) / 2;
            mediana = linked.get(index - 1);
        } else // парні
        {
            index = linked.size() / 2;
            mediana = (double) (linked.get(index) + linked.get(index - 1)) / 2;
        }

        final double finalMediana = mediana;
        Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double value = Math.abs(o1 - finalMediana) - Math.abs(o2 - finalMediana);
                if (value == 0)
                    value = o1 - o2;
                return (int) value;
            }
        };
        Collections.sort(linked, compareByMedian);*/

    }


    public static Integer[] sort(Integer[] array)
    {

        Arrays.sort(array);
        int index = 0;
        double mediana = 0;
        if (array.length % 2 == 1) //непарні
        {
            index = (array.length + 1) / 2;
            mediana = array[index - 1];
        } else // парні
        {
            index = array.length / 2;
            mediana = (double) (array[index] + array[index - 1]) / 2;
        }

        final double finalMediana = mediana;
        System.out.println(finalMediana);
        System.out.println(Arrays.toString(array));
        /*Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double value = Math.abs(o1 - finalMediana) - Math.abs(o2 - finalMediana); //тут треба собі памятати, що воно вертає -1 або 0 або 1.
                System.out.println(o1 +" " + 02 + " " +value);
                if (value == 0)
                    value = o1 - o2; // ми віднімаємо від значення нашу медіану - так ми находимо відстань
                System.out.println(value);
                return (int) value;
            }
        };
        Arrays.sort(array, compareByMedian);*/

        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double value = Math.abs(o1 - finalMediana) - Math.abs(o2 - finalMediana); //тут треба собі памятати, що воно вертає -1 або 0 або 1.
                System.out.println(o2 +" " + o1 + " " +value);
                if (value == 0)
                    value = o1 - o2; // ми віднімаємо від значення нашу медіану - так ми находимо відстань
                System.out.println(value);
                return (int) value;
            }
        });
        return array;
    }
}
