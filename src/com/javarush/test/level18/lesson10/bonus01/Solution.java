package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[1];
        String fileOutputName = args[2];

        if (args[0].equals("-e"))
        {
            FileInputStream file1 = new FileInputStream(fileName);
            FileOutputStream file2 = new FileOutputStream(fileOutputName);
            while (file1.available()>0)
            {
                int data = file1.read();
                file2.write(data+1);
            }
            file1.close();
            file2.close();
        }
        else if (args[0].equals("-d"))
        {
            FileInputStream file1 = new FileInputStream(fileName);
            FileOutputStream file2 = new FileOutputStream(fileOutputName);
            while (file1.available()>0)
            {
                int data = file1.read();
                file2.write(data-1);
            }
            file1.close();
            file2.close();

        }
    }
}
