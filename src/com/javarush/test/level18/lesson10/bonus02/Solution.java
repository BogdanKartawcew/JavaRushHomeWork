package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args[0].equals("-c"))
        {
            int maxID = 0;
            int id = 0;
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
            String rr;
            while ((rr = reader1.readLine())!=null)
            {
                try
                {
                    id = Integer.parseInt(rr.substring(0,8).trim());
                    if (maxID < id)maxID = id;
                }
                catch (NumberFormatException e){}
                catch (StringIndexOutOfBoundsException e){}
            }
            reader1.close();
            //самі ввели ID

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            String[] arrayArgs =
                    {Integer.toString(maxID+1),args[1],args[2],args[3]};
            while (arrayArgs[0].length() < 8){arrayArgs[0] += " ";}
            while (arrayArgs[1].length() < 30){arrayArgs[1] += " ";}
            while (arrayArgs[2].length() < 8){arrayArgs[2] += " ";}
            while (arrayArgs[3].length() < 4){arrayArgs[3] += " ";}
            bufferedWriter.newLine();
            bufferedWriter.write(arrayArgs[0]+arrayArgs[1]+arrayArgs[2]+arrayArgs[3]);
            bufferedWriter.close();
        }


    }
}


//   C:\Users\MyWORID\Desktop\test\test.txt