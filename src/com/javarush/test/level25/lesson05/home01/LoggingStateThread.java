package com.javarush.test.level25.lesson05.home01;

import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.State.NEW;
import static java.lang.Thread.State.RUNNABLE;

public class LoggingStateThread extends Thread
{//так ця програма вивдить всі значення але не приймається
    Thread currentThread;

    public LoggingStateThread(Thread target)
    {
        super();
        this.currentThread = target;
        setDaemon(true);
        System.out.println(currentThread.getState());
    }

    @Override
    public void run()
    {
        State state = currentThread.getState();
        Thread.State currentState;
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.currentThread.getState())
            {
                state = this.currentThread.getState();
                System.out.println(state);
            }
        }
    }


/*
    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.target.getState())
            {
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }*/
}
