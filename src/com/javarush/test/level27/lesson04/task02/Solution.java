package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            System.out.println("first");
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock)
        {
            synchronized (this)
            {
                System.out.println("sec");
                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println("do");
    }
}