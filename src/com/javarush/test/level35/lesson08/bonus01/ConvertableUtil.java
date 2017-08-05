package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil
{

    public static <T> Map convert(List<? extends Convertable> list)
    {
        Map result = new HashMap();
        for (Convertable<T> temp : list)
        { result.put(temp.getKey(), temp);}

        return result;
    }
}
