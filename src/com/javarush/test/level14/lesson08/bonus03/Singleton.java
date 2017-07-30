package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by MyWORID on 04.09.2016.
 */
public class Singleton
{private static Singleton singleton;
    private Singleton()
    {
        singleton = new Singleton();
    }
    static Singleton getInstance()
    {
        return  singleton;
    }
}
