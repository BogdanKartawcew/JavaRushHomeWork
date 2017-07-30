package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override

    /*це рекурсія. щось подібне можна було б зробити з арраєм*/
    public void uncaughtException(Thread t, Throwable e)
    {
        t.interrupt();
        if (e.getCause() != null){
            uncaughtException(t, e.getCause());
        }
        System.out.println(e.toString());

        /*StringBuilder message = new StringBuilder("");
        t.interrupt();
        if (e.getCause() != null){
            message = message.append(e.getCause());
        }
        System.out.println(message);*/ // так висвітлює тільки одну помилку а не всі
    }
    public static void main(String[] args){
        Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }
}
