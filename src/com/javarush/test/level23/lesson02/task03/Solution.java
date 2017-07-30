package com.javarush.test.level23.lesson02.task03;

/* Запретите создание экземпляров класса
Запретите создание экземпляров класса Listener.
*/
public class Solution {

    public static abstract class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}

    /*Чтобы запретить создание экземпляра класса, нужен приватный конструктор и сделать класс абстрактным,
        если вам нужно запретить наследование класса, нужно его сделать финальным,
        если нужно запретить создание экземпляра и запретить наследование, то final class + private конструктор*/
