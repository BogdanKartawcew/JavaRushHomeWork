package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MyWORID on 07.07.2017.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener)
    {
        String s1 = Helper.generateRandomString();
        String s2 = Helper.generateRandomString();
        String s3 = s1;
        Long i1 = shortener.getId(s1);
        Long i2 = shortener.getId(s2);
        Long i3 = shortener.getId(s3);
        Assert.assertNotEquals(i2, i1);
        Assert.assertNotEquals(i2, i3);
        Assert.assertEquals(i1, i3);
        String S1 = shortener.getString(i1);
        String S2 = shortener.getString(i2);
        String S3 = shortener.getString(i3);
        Assert.assertEquals(s1, S1);
        Assert.assertEquals(s2, S2);
        Assert.assertEquals(s3, S3);
    }

    @Test
    public void testHashMapStorageStrategy()
    {
        HashMapStorageStrategy object = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        OurHashMapStorageStrategy object = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy object = new FileStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy object = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy object = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy object = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(object);
        testStorage(shortener);
    }
}
