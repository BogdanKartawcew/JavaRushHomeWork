package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
        Scanner scanner = new Scanner(new File(filenameRead));
        int count = 0;
        String str[];
        String toWrite;
        String string = "";
        while (scanner.hasNext()){
            string = scanner.nextLine();
            str = string.split(" ");
            for (int i = 0; i < str.length; i++)
            {
                //str[i].matches("[-+]?\\d+");
                boolean k = isDigit(str[i]);
                if (k==true)
                {
                    toWrite =str[i] + " ";
                    StringWriteToFile(filenameWrite, toWrite);
                }
            }
        }
        scanner.close();
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void StringWriteToFile(String filenameWriteTo, String toWrite) throws IOException {
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