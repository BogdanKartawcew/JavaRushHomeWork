package com.javarush.test.level19.lesson10.home04;


import java.io.*;
import java.util.*;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    /*public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "windows-1251"));
        String line;
        while ((line = file.readLine()) != null)
        {   Map<String, String> map = new HashMap<>();
            String resultString="";
            int k = 0;
            String[] result = line.split(" ");

            for (String s1 : result)
            {
                map.put(s1, "");
            }
            for (Map.Entry entry : map.entrySet())
            {
                resultString = resultString+entry.getKey() + " ";
            }
            String[] resultEnd = resultString.split(" ");
            for (String s2 : resultEnd)
            {
                for (String s3: words)
                {
                    if (s3.equals(s2))
                    {
                       k++;
                    }
                }
            }
            if (k == 2) System.out.println(line);
        }
        reader.close();
        file.close();
    }*/ //цей код не враховує повторювання слів. не проходить
    /*public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "windows-1251"));
        String line;
        while ((line = file.readLine()) != null)
        {
            int k = 0;
            String[] result = line.split(" ");
            for (String s2 : result)
            {
                for (String s3: words)
                {
                    if (s3.equals(s2))
                    {
                        k++;
                    }
                }
            }
            if (k == 2) System.out.println(line);
        }
        reader.close();
        file.close();
    }*/ //цей мій варіант рахує навіть повторення, але не проходить
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine())); //різниця тільки в цьому оО

        while (fileReader.ready())
        {
            int count = 0;
            String s = fileReader.readLine();
            String[] array = s.split(" ");
            for (String x : words)
            {
                for (String y : array)
                {
                    if (y.contains(x))
                    {
                        count++;
                    }
                }
            }
            if (count == 2) System.out.println(s);
        }
        fileReader.close();
        reader.close();
    }
}

// C:\Users\MyWORID\Desktop\1.txt