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
import java.util.regex.Pattern;

public class druha_sproba {
    public static void main(String[] args) throws IOException
    {
//        //     ArrayList<Character> list = new ArrayList<>();
//       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String url = reader.readLine();
//        url = url.
//
//        String resultStr = url.substring(url.indexOf('?') + 1, url.indexOf('&'));
//        list.add(resultStr)

//        String str = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
//        Matcher matcher = Pattern.compile(".+\\?|.+\\&").matcher(str);
//        String res = "";
//        while (matcher.find())
//            res = matcher.group();
//        System.out.println(res.substring(0));

        //Pattern pattern = Pattern.compile(".+\\?|.+\\&");
        /*String str = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String tmp;
        System.out.println((tmp = str.substring(0, str.lastIndexOf('='))).substring(tmp.lastIndexOf('&' | '?') + 1));*/
        String data = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
//разбиваем строку на несколько подстрок на основании
// встречаемого символа новой строки
        String[]lines=data.split("=");

//проходим каждую подстроку
        for (String line : lines)
        {
            //находим индекс первого вхождения символа "/" в подстроке
            int pos = line.indexOf("?");
            //вычленяем имя атрибута из подстроки

            //вычленяем значение атрибута
            String value = line.substring(pos + 1, line.length());
            //вывод на экран вычлененных значений в нужном нам формате.
            System.out.println(value);

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

/*
"[&](.*?)[=]"*/


