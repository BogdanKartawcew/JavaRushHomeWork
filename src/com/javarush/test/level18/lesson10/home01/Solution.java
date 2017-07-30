package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
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
        long sum = 0;
        while (inputStream.available() >0)
        {
            int data = inputStream.read();
            if ((char) data >= 65 && data <= 90 || data >= 97 && data <= 122)
            {sum++;}
        }
        System.out.println(sum);
        inputStream.close();
    }
}
//C:\Users\MyWORID\Desktop\1.txt
