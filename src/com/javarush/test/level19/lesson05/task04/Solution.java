package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
        String filenameRead = BF.readLine();
        String filenameWrite = BF.readLine();
        BF.close();
        String string = "";
        Scanner scanner = new Scanner(new File(filenameRead));
        String str[];
        while (scanner.hasNext())
        {
            string = scanner.nextLine();
            str = string.split("");
            for (int i=0; i <str.length; i++)
            {
                if(str[i].equals(".")) str[i] = "!";
                StringWriteToFile(filenameWrite, str[i]);
            }
        }
        scanner.close();
    }
    public static void StringWriteToFile(String filenameWriteTo, String toWrite) throws IOException { // записуємо стрінг в кінець файла
        RandomAccessFile fileAddString = new RandomAccessFile(filenameWriteTo, "rw");
        long LengthFile = 0, position = 0;
        LengthFile = fileAddString.length();
        fileAddString.seek(0);
        String PS = "";
        while (position < LengthFile) {
            PS += fileAddString.readLine();
            position = fileAddString.getFilePointer();
        }
        fileAddString.writeBytes(toWrite);
        fileAddString.close();
    }
}
// C:\Users\MyWORID\Desktop\1.txt