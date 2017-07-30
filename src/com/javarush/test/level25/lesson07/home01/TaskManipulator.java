package com.javarush.test.level25.lesson07.home01;

import static java.lang.Thread.State.RUNNABLE;
import static java.lang.Thread.State.TERMINATED;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    public int startDate;
    public int stopDate;
    public String temp;

    @Override
    public void run()
    {

    }

    @Override
    public void start(String threadName)
    {
        temp = threadName;
        startDate = (int) System.currentTimeMillis();
    }

    @Override
    public void stop()
    {
        stopDate = (int) System.currentTimeMillis();
        if ((stopDate - startDate) >= 1)
        {
            System.out.println(temp);
            int size = ((stopDate - startDate) / 100);
            for (int i = 0; i < size; i++)
            {
                System.out.println(temp);
            }
        }
    }
}