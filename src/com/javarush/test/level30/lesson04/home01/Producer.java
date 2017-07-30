package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by MyWORID on 18.05.2017.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {

            try
            {
                if(!Thread.currentThread().isInterrupted()) {
                    for (int i = 1; i < 10; i++) {
                        ShareItem item = new ShareItem("ShareItem-" + i, i);
                        System.out.format("Элемент '%s' добавлен%n", item.description);
                        queue.offer(item);
                        Thread.sleep(100);
                        if (queue.hasWaitingConsumer()) {
                            System.out.println("Consumer в ожидании!");
                        }
                    }
                }
            }
            catch (InterruptedException e)
            {
            }
        }
}
