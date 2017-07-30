package com.javarush.test.level15.lesson12.home02;

/* Тренировка мозга
Найти логическую ошибку: метод doAction в реализации интерфейса Movable должен выдавать "moving".
Исправьте ошибку, при необходимости измените (отрефакторите) интерфейс Movable.
Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }
    public static class Duck implements Flyable, Movable {
        @Override
        public void doFly(String x) {
            System.out.println(x);
        }
        public void doMove(String y) {
            System.out.println(y);
        }
    }
    public static class Util {
        static void fly(Flyable animal) {
            String x = "flying";
            animal.doFly(x);
        }
        static void move(Movable animal) {
            String y = "moving";
            animal.doMove(y);
        }
    }
    public static interface Flyable {
        void doFly(String x);
    }
    public static interface Movable {
        void doMove(String y);
    }
}
