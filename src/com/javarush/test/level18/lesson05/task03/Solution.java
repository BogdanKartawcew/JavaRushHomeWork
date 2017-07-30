package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());
        byte[] b = new byte[file1.available()];
        while (file1.available()>0){
            int countOfReadingBytes = file1.read(b);
            file3.write(b, 0, countOfReadingBytes/2);
            file2.write(b, countOfReadingBytes/2, countOfReadingBytes-countOfReadingBytes/2);
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
//C:\Users\MyWORID\Desktop\1234.txt
//C:\Users\MyWORID\Desktop\1.txt
//C:\Users\MyWORID\Desktop\2.txt