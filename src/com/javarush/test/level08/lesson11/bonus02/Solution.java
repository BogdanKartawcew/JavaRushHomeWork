package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<String, String>();
        while (true)
        {
            String city = reader.readLine();
            if (city.equals(""))break;
            String lastname = reader.readLine();
            if (lastname.equals("")) break;
            else
            {
                map.put(city, lastname);
            }
        }

        String vvid = reader.readLine();
        for(Map.Entry<String, String> pair : map.entrySet()){
            if(vvid.equals(pair.getKey()))
                System.out.println(pair.getValue());
            else continue;
        }
    }
}
