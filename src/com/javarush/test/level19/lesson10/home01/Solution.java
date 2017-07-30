package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileReader read = new FileReader(args[0]);
        BufferedReader file = new BufferedReader(read);
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
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        read.close();
        file.close();
    }
}
