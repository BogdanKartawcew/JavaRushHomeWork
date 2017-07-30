package com.javarush.test.level32.lesson04.task01;

import java.io.PrintWriter;
import java.io.StringWriter;

/* Пишем стек-трейс
Реализуйте логику метода getStackTrace, который в виде одной строки должен возвращать весь стек-трейс переданного исключения.
Используйте подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        /*StackTraceElement[] error = throwable.getStackTrace();
        StringWriter writer = new StringWriter();
        for (StackTraceElement ms : error)
        {
            writer.write(String.valueOf(ms));
        }
        return writer.toString();*/ // com.javarush.test.level32.lesson04.task01.Solution.main(Solution.java:11) - очєнь цікаве вийшло в мене :)

        StringWriter errors = new StringWriter();
        throwable.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}
