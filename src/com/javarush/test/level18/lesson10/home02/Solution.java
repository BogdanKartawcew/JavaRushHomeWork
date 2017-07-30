package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    static
    {
        String[] args = new String[3];
        args[0] = "C:/Users/MyWORID/Desktop/1.txt";
        try
        {
            main(args);
        }
        catch (IOException e)
        {

        }
    }
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        double ilosc = 0;
        double probel = 0;
        while (inputStream.available() >0)
        {ilosc++;
            int data = inputStream.read();
            if ((char) data == 32)
            {probel++;}
        }
        double wynik = (probel/ilosc) * 100;
        System.out.println(wynik);
        inputStream.close();
    }
}
