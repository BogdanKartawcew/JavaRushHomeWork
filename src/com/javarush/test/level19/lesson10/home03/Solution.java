package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        FileReader read = new FileReader(args[0]);
        BufferedReader file = new BufferedReader(read);
        String line = null;
        while ((line = file.readLine()) != null) {
            String[] result = line.split(" \\d");
            String name = result[0];
            line =  line.replaceAll(result[0]+" ", "");
            String[] toInt = line.split(" ");
            int day = Integer.parseInt(toInt[0]);
            int month = Integer.parseInt(toInt[1]);
            int year = Integer.parseInt(toInt[2]);
            Date date = new GregorianCalendar(year, month-1, day).getTime();
            PEOPLE.add(new Person(name,date));
        }
        read.close();
        file.close();
    }

}
