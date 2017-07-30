package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader File1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter File2 = new BufferedWriter(new FileWriter(reader.readLine()));


        String s;
        while ((s = File1.readLine()) != null) {
            File1.read();
            String[] tmp = s.split(" ");

            for (String item : tmp) {
                long num = Math.round(Double.parseDouble(item));
                File2.write(String.valueOf(num)+" ");
            }
        }

        reader.close();
        File1.close();
        File2.close();

    }
}


/*
C:\Users\MyWORID\Desktop\123456.txt
C:\Users\MyWORID\Desktop\789.txt

вивід має бути: 3 4 6
через пробел
*/
