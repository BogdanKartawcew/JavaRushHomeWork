package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {HashMap<String, String> map = new HashMap<>();
        {
            map.put("Kartawcew", "Bogdan");
            map.put("Kartawcewa", "Valerija");
            map.put("dfvdfv", "dfvdf");
            map.put("ffvdvd", "dfvbdfvb");
            map.put("dfvdfvfhrh", "dfvdfv");
            map.put("dffdhfgh", "ehrghdfb");
            map.put("awererf", "khklghk");
            map.put("tyjhnfgn", "dshrhnfg");
            map.put("fgntyjtyhdfg", "rtgg");
            map.put("rthrth", "rtr");
        }
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        return map.containsValue(name) ? 1 : 0;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        return map.containsKey(lastName) ? 1 : 0;
    }
}
