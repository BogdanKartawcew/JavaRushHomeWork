package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //ищем ? в ссылке и отсекаем его
        int index1 = s.indexOf('?') + 1;
        //убираем из строки все что до ?
        System.out.println(s);
        s = s.substring(index1);
        System.out.println(s);
        //разделяем сроку на массив строк делитель &
        String[] massyv = s.split("&");
        //инициализуем вспомогательные объкты

        String tmp;
        ArrayList<String> objs = new ArrayList<>();
        String summary = "";
        for (int i = 0; i < massyv.length; i++)
        {
            //удаляем лишние ? и пробелы:
//            massyv[i] = massyv[i].replace('?', ' ').trim();
            //работаем только со строками в которых есть параметры
            if (!(massyv[i].equals("")))
            {
                //обрабатываем отдельно строки начинающиеся с obj, добавляем в отдельный ArrayList
                if (massyv[i].startsWith("obj"))
                {
                    objs.add(massyv[i]);
                }
                //собираем строку из частей строк массива massyv, из того что стоит перед =
                if (massyv[i].indexOf('=') != -1)
                {
                    int ind = massyv[i].indexOf('=');
                    tmp = massyv[i].substring(0, ind);
                    summary += tmp + " ";
                } else summary += massyv[i] + " ";
            }
        }
        //выводим название параметров
        System.out.println(summary);
        //ищем obj и вызываем метод alert
        for (String tmp1: objs)
        {
            //на всякий проверяем не пустая ли строка
            if (tmp1 != "")
            {
                //берем значение параметра
                int ind1 = tmp1.indexOf('=') + 1;
                tmp1 =  tmp1.substring(ind1);
                tmp1.trim();
                if (isDouble(tmp1))
                {
                    alert(Double.parseDouble(tmp1));
                } else alert(tmp1);
            }
        }
    }
    private static boolean isDouble(String s) throws NumberFormatException{
        try{
            Double.parseDouble(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }
    public static void alert(String value) {
        System.out.println("String " + value);
    }
}


// ml?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa
