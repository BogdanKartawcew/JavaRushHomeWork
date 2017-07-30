package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main (String[] args) throws Exception{
        Map<String, String> map = new LinkedHashMap<>();
        //map.put("name", "Ivanov");
        //map.put("country", "Ukraine");
        //map.put("dfvdfv", "ffvsfv");
        map.put("ev", null);
        System.out.println(getCondition(map).toString());
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
        StringBuilder newResult = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet())
        {
            if (entry.getValue() != null)
                result.append(entry.getKey() + " = '" + entry.getValue() + "' and ");
        }
        try{
        newResult = newResult.replace(0,0,result.substring(0, result.length()-5));} // це зробив через те, що якщо вся мапа пуста, то робиться індекс "-5", якого не існує
        catch (Exception e){}
        return newResult;
    }
}
