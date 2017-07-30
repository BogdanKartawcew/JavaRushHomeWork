package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by MyWORID on 21.05.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
   private int i;
    public BinaryRepresentationTask(int i)
    {
        this.i = i;
    }

    protected String compute()
    {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return  result;
    }
}
