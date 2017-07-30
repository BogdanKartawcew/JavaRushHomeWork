package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by MyWORID on 21.05.2017.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String message = "";
        boolean ready = false;
        while (!ready)
        {
            try
            {
                message = reader.readLine();
                ready = true;
            }
            catch (Exception e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return message;
    }

    public static int readInt()
    {
        int message = 0;
        boolean ready = false;
        while (!ready)
        {
            try
            {
                message = Integer.parseInt(readString());
                ready = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return message;
    }
}

