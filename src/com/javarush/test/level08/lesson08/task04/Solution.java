package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Bodia", new Date("NOVEMBER 19 1995"));
        map.put("Lerka", new Date("DECEMBER 5 1999"));
        map.put("Jazz", new Date("JANUARY 12 2009"));
        map.put("Ox", new Date("NOVEMBER 17 1992"));
        map.put("Tato", new Date("AUGUST 20 1971"));
        map.put("Mama", new Date("MAY 12 1971"));
        map.put("Max", new Date("OCTOBER 17 1999"));
        map.put("Brenda", new Date("AUGUST 10 2001"));
        map.put("Uliana", new Date("FEBRUARY 1 1996"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        for (Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
             it.hasNext(); )
        {
            Map.Entry<String, Date> pair = it.next();
            if (pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6 || pair.getValue().getMonth() == 7)

                it.remove();
        }
    }
}
