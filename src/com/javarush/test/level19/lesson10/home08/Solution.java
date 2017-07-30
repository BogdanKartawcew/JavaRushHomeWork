package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "windows-1251"));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        while ((line= file.readLine())!=null)
        {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(line));
            stringBuilder.reverse();
            String reverseString = stringBuilder.toString();
            System.out.println(reverseString);
        }
        reader.close();
        file.close();
    }
}
// C:\Users\MyWORID\Desktop\1.txt