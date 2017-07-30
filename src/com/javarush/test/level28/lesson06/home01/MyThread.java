package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by MyWORID on 10.05.2017.
 */
public class MyThread extends Thread {
        public MyThread() {
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

    private static AtomicInteger priority = new AtomicInteger(0);
    private void init() {
        priority.incrementAndGet();
        priority.compareAndSet(11, 1);

        int newPriority = priority.get();
        if (getThreadGroup() != null) {
            if (newPriority > getThreadGroup().getMaxPriority()) {
                newPriority = getThreadGroup().getMaxPriority();
            }
        }
        setPriority(newPriority);
    }
}


   /* public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        int maxPri = this.getThreadGroup().getMaxPriority();
        if (priority.get() >= maxPri)
        {
            this.setPriority(maxPri);
        }
        if (priority.get() == 10)
        {
            priority.set(1);
        }
        else
        {
            this.setPriority(priority.getAndIncrement());
        }
    }


    {
        priority.compareAndSet(11, 1);
        setPriority(priority.getAndIncrement());
    }*/