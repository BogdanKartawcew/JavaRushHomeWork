package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MyWORID on 08.04.2017.
 */
public class Producer implements Runnable
{
    public Producer(ConcurrentHashMap<String, String> map)
    {
    }

    @Override
    public void run()
    {
        try {
            int i = 0;
            while (true){
                i++;
                System.out.println("Some text for "+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
