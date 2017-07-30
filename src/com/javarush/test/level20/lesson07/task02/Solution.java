package com.javarush.test.level20.lesson07.task02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static String greeting = "Hello world";

    public static class OutputToConsole implements Externalizable {
        private int i = 8;
        public OutputToConsole(){}

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }


        public OutputToConsole(int ii) {
            this.i = ii;
        }

        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++)  {
                System.out.write(greeting.charAt(i));
                System.out.flush();
            }
        }
    }
}
