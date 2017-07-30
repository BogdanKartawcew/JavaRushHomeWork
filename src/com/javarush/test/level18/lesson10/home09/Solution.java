package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;

        try
        {
            while (true)
            {
                filename = reader.readLine();
                FileInputStream file = new FileInputStream(filename);
                file.close();
                System.out.println("Закрываем file.close()");

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(filename);
        }
        catch (IOException e)
        {
            System.out.println("ANOTHER ERROR");
        }
        reader.close();
        System.out.println("Закрываем reader.close()");*/ //такий код (мій власний) працює, але не проходить






        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;

        try
        {
            while (true)
            {
                filename = reader.readLine();
                FileInputStream file = new FileInputStream(filename);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(filename);
        }
        catch (IOException e)
        {
            System.out.println("ANOTHER ERROR");
        }
        reader.close(); //виявилось що не треба закривати file і що не можна класти зайві виводи на екран.
    }
}
//    C:\Users\MyWORID\Desktop\1.txt