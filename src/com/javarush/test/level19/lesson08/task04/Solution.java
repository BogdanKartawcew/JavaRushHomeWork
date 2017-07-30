package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        /*ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result2 = engine.eval(result.replace("=",""));

        System.out.println(result.replaceAll("(\\r|\\n)", ""));
        System.out.println(result2);*/

        String[] results = result.split(" ");
        long a = Integer.parseInt(results[0]);
        long b = Integer.parseInt(results[2]);

        long wynik = 0;

        String[] line = result.split("");
        for (String s:line)
        {
            if (s.equals("-")) wynik = a-b;
            if (s.equals("*")) wynik = a*b;
            if (s.equals("+")) wynik = a+b;
        }
        System.out.println(result+wynik);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("2 - 2 = ");
        }
    }
}

