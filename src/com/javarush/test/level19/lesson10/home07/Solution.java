package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    /*public static void main(String[] args) throws IOException
    {
        //BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\MyWORID\\Desktop\\1.txt"), "windows-1251"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MyWORID\\Desktop\\2.txt"));
        String line;
        while ((line= reader.readLine())!=null)
        {String[] result = line.split(" ");
            for (String s : result)
            {if (s.length()>6) writer.write(s+",");}
        }
        reader.close();
        writer.close();
        EndOfFile("C:\\Users\\MyWORID\\Desktop\\2.txt");
    }
    public static void EndOfFile(String filename) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        String PS = " ";
        file.seek(file.length()-1);
        file.writeBytes(PS);
        file.close();
    }*/  // мій код має доступ до останнього символа в файлі, от тільки можу замінити на будь-який символ окрім пустого

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\MyWORID\\Desktop\\1.txt"), "windows-1251"));
        //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MyWORID\\Desktop\\2.txt"));
        ArrayList<String> list = new ArrayList<String>();
        String line;
        while ((line= reader.readLine())!=null)
        {String[] result = line.split(" ");
            for (String s : result)
            {if (s.length()>6) list.add(s);
            }
        }
        for (int i = 0; i<list.size(); i++)
        {
            if (i == list.size() - 1)
            {
                writer.write(list.get(i));
            }
            else
            {
                writer.write(list.get(i) + ",");
            }
        }
        reader.close();
        writer.close();
    }
}
