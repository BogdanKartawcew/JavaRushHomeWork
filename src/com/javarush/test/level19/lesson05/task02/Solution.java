package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string = "";
        Scanner scanner = new Scanner(new File(reader.readLine()));
        reader.close();
        int count = 0;
        String str[];

        while (scanner.hasNext()){
            string = scanner.nextLine();
            str = string.split("[,;:.!?\\s]+");
            for (int i = 0; i < str.length; i++)
            {
                if (str[i].equals("world")){
                    count++;
                }
            }
        }
        scanner.close();
        System.out.println(count);
    }
}
// C:\Users\MyWORID\Desktop\1.txt