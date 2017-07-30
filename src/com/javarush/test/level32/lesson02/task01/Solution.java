package com.javarush.test.level32.lesson02.task01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution
{
    public static void main(String... args)
    {
        String fileName = args[0];
        int position = Integer.parseInt(args[1]);
        String text = args[2];

        /*String fileName = "C:\\Users\\MyWORID\\Desktop\\test\\1.txt";
        int position = 16;
        String text = "234567";*/

        try
        {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            long fileLength = 0;
            fileLength = raf.length();

            if (fileLength < position) raf.seek(fileLength);
            else raf.seek(position);

            raf.writeBytes(text);
            raf.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
