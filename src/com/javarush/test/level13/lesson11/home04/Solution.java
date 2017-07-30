package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        File file = new File(filename);
ArrayList<String> list = new ArrayList<>();
        while (true)
        {String s = reader.readLine();
            list.add(s);
            if (s.equals("exit")) break;
        }

        FileWriter writer = new FileWriter(file.getAbsoluteFile());
        for(String str: list) {
            writer.write(str);
            String lineSeparator = System.lineSeparator();
            writer.write(lineSeparator);
        }
        writer.close();
    }
}


