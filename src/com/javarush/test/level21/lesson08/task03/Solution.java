package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        protected int i;
        protected int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
        {
            return new A(getI(), getJ());
        }
    }

    public static class B extends A{
        protected String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public B clone() throws CloneNotSupportedException {
            throw  new CloneNotSupportedException();
        }
    }

    public static class C extends B /*implements Cloneable*/ {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone() throws CloneNotSupportedException //люди ще пишуть протектед, мені пройшло паблік.
        {
            /*C c = new C(i, j, name);
            c.i = this.i;
            c.j = this.j;
            c.name = this.name;
            return c;*/
            return new C(getI(), getJ(), getName());
        }
    }
}
