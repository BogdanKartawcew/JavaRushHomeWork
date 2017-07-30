package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by MyWORID on 11.06.2017.
 */
public class Solution
{
    public static void main (String [] args)
    {
        new Solution().testStrategy(new HashMapStorageStrategy(), 1000);
        new Solution().testStrategy(new OurHashMapStorageStrategy(), 1000);
        new Solution().testStrategy(new FileStorageStrategy(), 1000);
        new Solution().testStrategy(new OurHashBiMapStorageStrategy(), 1000);
        new Solution().testStrategy(new HashBiMapStorageStrategy(), 1000);
        new Solution().testStrategy(new DualHashBidiMapStorageStrategy(), 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    /*должен для переданного множества строк возвращать множество идентификаторов*/
    {
        Set<Long> result = new HashSet<>();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) result.add(shortener.getId(iterator.next()));
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    /*будет возвращать множество строк, которое соответствует переданному множеству идентификаторов*/
    {
        Set<String> result = new HashSet<>();
        Iterator<Long> iterator = keys.iterator();
        while (iterator.hasNext()) result.add(shortener.getString(iterator.next()));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    /*будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber*/
    {
        Helper.printMessage(strategy.getClass().getSimpleName()); //Выводить имя класса стратегии. Имя не должно включать имя пакета
        Set<String> testStrings = new HashSet<>(); //Генерировать тестовое множество строк
        for (long i = 0; i < elementsNumber; i++) {
            testStrings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy); //Создавать объект типа Shortener, используя переданную стратегию
        long startGetIds = new Date().getTime();
        Set<Long> idsSet = getIds(shortener, testStrings);
        long endGetIds = new Date().getTime();
        Helper.printMessage("GetIds time = "+ (endGetIds-startGetIds));

        long startGetStrings = new Date().getTime();
        Set<String> stringsSet = getStrings(shortener, idsSet);
        long endGetStrings = new Date().getTime();
        Helper.printMessage("GetStrings time = "+ (endGetStrings-startGetStrings));

        if(stringsSet.equals(testStrings))
            Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
        //System.out.println();
    }
}
