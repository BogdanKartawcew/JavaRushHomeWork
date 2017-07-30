package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (isValuePresent){ //створив цей цикл і вставив нотіфай
        System.out.println("Got: " + value);
            isValuePresent = false;
            notifyAll();
        }
        return value;
    }
// всюди докладав щоб мінялось значення true\false
    public synchronized void put(int value) {
        while (!isValuePresent) // створив цей цикл
        {
            this.value = value;
            System.out.println("Put: " + value);
            isValuePresent = true;
        }
    }
}
