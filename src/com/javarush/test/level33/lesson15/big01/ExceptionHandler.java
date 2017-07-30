package com.javarush.test.level33.lesson15.big01;

/**
 * Created by MyWORID on 11.06.2017.
 */
public class ExceptionHandler extends RuntimeException
{
    public static void log(Exception e)
    {
        System.out.println(e.toString());
    }
}
