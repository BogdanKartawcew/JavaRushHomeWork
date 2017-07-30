package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution
{
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        //BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "windows-1251"));
        //це завжди використовувати тільки для провірки. валідатор такої строки не приймає
        String line;
        while ((line= file.readLine())!=null)
        {String newLine = "";
            String[] result = line.split(" ");
            for (String s : result)
            {   String textToChange = "";
                if (s.matches("[0-9]*")) {
                    int textInt = Integer.parseInt(s);
                    if ((0 <= textInt) && (textInt < 13))
                    {
                        for (Map.Entry<Integer, String> entry : map.entrySet())
                        {
                            if (textInt == entry.getKey())
                            {
                                textToChange = entry.getValue();
                            }
                        }
                        s = s.replaceAll(s, textToChange);
                    }
                    else
                    {
                        s= Integer.toString(textInt);
                    }
                }
                newLine = newLine+s+" ";
            }
            System.out.println(newLine);
        }
        reader.close();
        file.close();
    }
}
// C:\Users\MyWORID\Desktop\1.txt