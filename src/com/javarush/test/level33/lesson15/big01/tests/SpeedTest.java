package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MyWORID on 07.07.2017.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        long startGetIds = new Date().getTime();
        for (String s : strings) ids.add(shortener.getId(s));
        long endGetIds = new Date().getTime();
        return endGetIds - startGetIds;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        long startGetIds = new Date().getTime();
        for (Long s : ids) strings.add(shortener.getString(s));
        long endGetIds = new Date().getTime();
        return endGetIds - startGetIds;
    }

    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        Assert.assertTrue(getTimeForGettingIds(shortener1, origStrings, ids1)
                > getTimeForGettingIds(shortener2, origStrings, ids2));
        Assert.assertEquals(getTimeForGettingStrings(shortener1, ids1, origStrings),
                getTimeForGettingStrings(shortener2, ids2, origStrings), 5);
    }
}
