package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new n1());
        threads.add(new n2());
        threads.add(new n3());
        threads.add(new n4());
        threads.add(new n5());
    }
    public  static void main(String[] args) throws InterruptedException
    {
    }


    public static class n1 extends Thread {
        public void run() {
            while (true) {}
        }
    }
    public static class n2 extends Thread {
        @Override
        public void run()
        {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            { System.out.println("InterruptedException");
            }
        }

    }
    public static class n3 extends Thread {
        public void run(){
            try {
                while (true){
                    sleep(500);
                    System.out.println("Ура");
                }
            } catch (Exception e) {
            }
        }
    }
    public static class n4 extends Thread implements  Message {
        /*public void showWarning()
        {
            this.interrupt();
            try
            {
                this.join();
            }
            catch(Exception e)
            {

            }
        }

        public void run()
        {
            Thread current = Thread.currentThread();
            while(!current.interrupted())
            {

            }
        }*/
        public void showWarning()
        {
            {
                this.interrupt();
                try
                {
                    this.join();
                }
                catch(Exception e)
                {
                }
            }
        }

        public void run()
        {
            while(!Thread.interrupted());
        }

    }
    public static class n5 extends Thread {
        /*public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summa = 0;

            while(true)
            {
                try
                {
                    String a = reader.readLine();
                    while (!a.equals("N"))
                    {
                        summa +=Integer.parseInt(a);
                    }
                    System.out.println(summa);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }*/
        public void run()
        {
            int sum = 0;
            String s;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                while (!((s = reader.readLine()).equals("N")))
                {
                    sum = sum + Integer.parseInt(s);
                }
                System.out.println(sum);
            }
            catch (IOException e)
            {

            }
        }
    }

}

