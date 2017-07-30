package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
        String filenameRead = BF.readLine();
        String filenameWrite = BF.readLine();
        BF.close();
        FileInputStream reader = new FileInputStream(filenameRead);
        FileOutputStream writer = new FileOutputStream(filenameWrite);
        byte[] buffer = null;
        while (reader.available() >0)
        {
            buffer = new byte[reader.available()];
            reader.read(buffer);
            for (int i = 0; i < buffer.length; i++)
            {
                if (i % 2 != 0)
                {
                    writer.write(buffer[i]);
                }
            }

        }
        reader.close();
        writer.close();
    }
}
// C:\Users\MyWORID\Desktop\1.txt