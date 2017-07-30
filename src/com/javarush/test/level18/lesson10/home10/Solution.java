package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> list = new TreeSet<>();
        String fileName = reader.readLine();
        int index = fileName.lastIndexOf(".");
        String mainfilename = fileName.substring(0, index);
        while (!"end".equals(fileName))
        {
            list.add(fileName);
            fileName = reader.readLine();
        }
        reader.close();
        /*System.out.println(list);
        System.out.println(mainfilename);*/

        FileOutputStream file = new FileOutputStream(mainfilename/* + "main.txt"*/);

        for (String set: list)
        {
            FileInputStream readerFile = new FileInputStream(set);
            while (readerFile.available()>0)
            {
                int data = readerFile.read();
                file.write(data);
            }
            readerFile.close();
        }
        file.close();
    }
}
/*
Lion.avi.part37
Lion.avi.part2
Lion.avi.part1
end
C:\Users\MyWORID\Desktop\1.txt



C:\Users\MyWORID\Desktop\test\1.txt
C:\Users\MyWORID\Desktop\test\2.txt
C:\Users\MyWORID\Desktop\test\4.txt
C:\Users\MyWORID\Desktop\test\6.txt
C:\Users\MyWORID\Desktop\test\7.txt
C:\Users\MyWORID\Desktop\test\8.txt
C:\Users\MyWORID\Desktop\test\9.txt
C:\Users\MyWORID\Desktop\test\5.txt
C:\Users\MyWORID\Desktop\test\3.txt
end

 */
