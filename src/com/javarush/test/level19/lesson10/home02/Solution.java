package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\MyWORID\\Desktop\\1.txt"),"windows-1251"));
        TreeMap<String, Double> map = new TreeMap<>();
        String line = null;
        while ((line = file.readLine()) != null) {
            String[] result = line.split(" ");
            if (map.containsKey(result[0]))
            {
                double sal = map.get(result[0]) + Double.parseDouble(result[1]);
                map.put(result[0], sal);
            }
            else map.put(result[0], Double.parseDouble(result[1]));
        }
        double maxSalary=0;
        for (int i =0; i<1; i++){
            for (Map.Entry<String, Double> entry : map.entrySet())
            {
                maxSalary = entry.getValue();
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if (entry.getValue() == maxSalary)
            {
                System.out.println(entry.getKey());
            }
        }
        file.close();*/ // мій робочий код не приймає

        HashMap<String, Double> map = new HashMap<>();

        String name;
        Double value;
        Double max = Double.MIN_VALUE;
        Scanner sc = new Scanner(new File(args[0]));
        while (sc.hasNext())
        {
            name = sc.next().replaceAll("\\uFEFF", "");
            value = Double.parseDouble(sc.next());
            if (map.containsKey(name))
                map.put(name, map.get(name) + value);
            else map.put(name, value);
        }
        sc.close();

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            max = Math.max(max, pair.getValue());
        }

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
            {
                System.out.println(pair.getKey());
            }
        }

    }
}
//C:\Users\MyWORID\Desktop\1.txt