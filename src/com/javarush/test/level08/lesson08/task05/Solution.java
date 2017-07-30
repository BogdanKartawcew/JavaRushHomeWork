package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{public static void main(String[] args)
{
    HashMap<String , String> map = createMap();
    removeTheFirstNameDuplicates(map);
    System.out.println(map);
}

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Lera" , "Kartawcewa");
        map.put("Lera", "Palijczuk" );
        map.put("Bogdan", "Kartawcew" );
        map.put("Vika", "Palijczuk" );
        map.put("Max", "Kartawcew" );
        map.put("Roman", "Kartawcew" );
        map.put("Halyna", "Kartawcewa" );
        map.put("Halyna", "Sarabyn" );
        map.put( "Mychajlo", "Janysziwskyj");
        map.put("Ox", "Kartawcewa" );


        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> pair : map.entrySet())
            list.add(pair.getValue());
        for (int a = 0; a < list.size(); )
        {
            int count = 0;
            for (int b = 0; b < list.size(); b++)
            {
                if ((list.get(a).equals(list.get(b))) && a != b) count++;
            }
            if (count == 0) list.remove(a);
            else a++;
        }
        for (int c = 0; c < list.size(); c++)
        {
            removeItemFromMapByValue(map, list.get(c));
        }

//        HashMap<String, String> copy = new HashMap<String, String>(map);
//        for (String value : copy.values())
//            if (Collections.frequency(copy.values(), value) > 1)
//                removeItemFromMapByValue(map, value);
    }
    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }

    }
}
