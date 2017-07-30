package com.javarush.test.level12.lesson12.bonus02;

/* Нужно добавить в программу новую функциональность
Сделать класс Pegas(пегас) на основе класса Horse(лошадь) и интерфейса Fly(летать).
*/

public class Solution
{
    public static void main(String[] args)
    {
        Horse horse = new Pegas();
        horse.run();
    }

    public static interface Fly
    {
        public  void fly();
    }

    public static  class Horse
    {
        public void run()
        {

        }
    }

    public static  class Pegas extends Horse implements Fly
    {
        public  void fly()
        {

        }
    }
}
